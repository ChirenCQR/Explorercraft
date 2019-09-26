package com.zathrox.explorercraft.core.registry;

import com.google.common.collect.Lists;
import com.zathrox.explorercraft.common.entity.EnderreeperEntity;
import com.zathrox.explorercraft.common.entity.InfestedSkeletonEntity;
import com.zathrox.explorercraft.common.entity.WizardEntity;
import com.zathrox.explorercraft.core.Explorercraft;
import com.zathrox.explorercraft.core.config.EntityConfig;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Explorercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("rawtypes")
public class ExplorerEntities {
    private static List<EntityType> entities = Lists.newArrayList();
    private static List<Item> spawnEggs = Lists.newArrayList();

    public static final EntityType<InfestedSkeletonEntity> OVERGROWN_SKELETON = createEntity(InfestedSkeletonEntity.class, InfestedSkeletonEntity::new, EntityClassification.MONSTER, "infested_skeleton", 0.6F, 1.99F, 16777215, 10092400);
    //public static final EntityType<EntityOvergrownSkeleton2> OVERGROWN_SKELETON2 = createEntity(EntityOvergrownSkeleton2.class, EntityOvergrownSkeleton2::new, EntityClassification.MONSTER, "overgrown_skeleton2", 0.6F, 1.99F, 14562431, 13484272);
    public static final EntityType<EnderreeperEntity> ENDERREEPER = createEntity(EnderreeperEntity.class, EnderreeperEntity::new, EntityClassification.MONSTER, "enderreeper", 0.6F, 1.99F, 3801171, 7078066);
    public static final EntityType<WizardEntity> WIZARD = createEntity(WizardEntity.class, WizardEntity::new, EntityClassification.MONSTER, "wizard", 0.6F, 1.99F, 4869992, 16433238);


    private static <T extends Entity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation(Explorercraft.MOD_ID, name);

        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
                .size(width, height).setTrackingRange(64)
                .setShouldReceiveVelocityUpdates(true)
                .setUpdateInterval(3)

                .build(location.toString());

        entity.setRegistryName(location);

        entities.add(entity);
        spawnEggs.add(createSpawnEggForEntity(entity, eggPrimary, eggSecondary, ItemGroup.MISC));

        return entity;
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : entities) {
            event.getRegistry().register(entity);
        }

        EntitySpawnPlacementRegistry.register(OVERGROWN_SKELETON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
        //EntitySpawnPlacementRegistry.register(OVERGROWN_SKELETON2, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
        EntitySpawnPlacementRegistry.register(ENDERREEPER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
        EntitySpawnPlacementRegistry.register(WIZARD, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::func_223315_a);
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : spawnEggs) {
            event.getRegistry().register(spawnEgg);
        }
    }

    public static Item createSpawnEggForEntity(@SuppressWarnings("rawtypes") EntityType entityType, int eggColor1, int eggColor2, ItemGroup itemGroup) {
        return new SpawnEggItem(entityType, eggColor1, eggColor2, new Item.Properties().group(itemGroup)).setRegistryName(entityType.getRegistryName() + "_spawn_egg");
    }

    private static void registerEntityWorldSpawn(EntityType<?> type, int weight, int minCount, int maxCount, Biome... biomes) {
        for(Biome biome : biomes) {
            if(biome != null) {
                biome.getSpawns(type.getClassification()).add(new Biome.SpawnListEntry(type, weight, minCount, maxCount));
            }
        }
    }

    public static void registerEntityWorldSpawns() {
        if(EntityConfig.enderreeper_enabled.get()) {
            registerEntityWorldSpawn(ENDERREEPER, 1, 1, 1, Biomes.THE_END);
        }
        if(EntityConfig.infested_skeleton_enabled.get()) {
            registerEntityWorldSpawn(OVERGROWN_SKELETON, 1, 4, 4, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.BAMBOO_JUNGLE, Biomes.BAMBOO_JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.MODIFIED_JUNGLE, ExplorerBiomes.BAMBOO_FOREST);
        }
    }
}