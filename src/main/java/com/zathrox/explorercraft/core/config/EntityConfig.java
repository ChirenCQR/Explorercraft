package com.zathrox.explorercraft.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EntityConfig {

    public static ForgeConfigSpec.BooleanValue enderreeper_enabled;
    public static ForgeConfigSpec.BooleanValue infested_skeleton_enabled;
    public static ForgeConfigSpec.BooleanValue wizard_enabled;

    public static void init(ForgeConfigSpec.Builder common, ForgeConfigSpec.Builder client) {
        common.push("Spawn Entities");
        common.comment("Disable spawning of entities in the mod");
        enderreeper_enabled = common
                .comment("Decide if you want the Enderreeper to spawn in your world (The End Dimension)")
                .define("entity.enderreeper_enabled", true);
        infested_skeleton_enabled = common
                .comment("Decide if you want the Infested Skeleton to spawn in your world")
                .define("entity.infested_skeleton_enabled", true);
        common.pop();
    }
}
