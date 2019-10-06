package com.zathrox.explorercraft.common.world.feature;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import com.zathrox.explorercraft.core.registry.ExplorerBiomes;
import com.zathrox.explorercraft.core.registry.ExplorerBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class WillowTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {

    private static final BlockState WILLOW_LOG = ExplorerBlocks.WILLOW_LOG.getDefaultState();
    private static final BlockState INFECTED_WILLOW_LOG = ExplorerBlocks.INFECTED_WILLOW_LOG.getDefaultState();
    private static final BlockState WILLOW_LEAVES = ExplorerBlocks.WILLOW_LEAVES.getDefaultState();

    public WillowTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyIn) {
        super(configFactoryIn, doBlockNotifyIn);
    }

    private void crossSection(IWorldGenerationReader worldIn, BlockPos pos, float p_208529_3_, MutableBoundingBox p_208529_4_, Set<BlockPos> changedBlocks) {
        int i = (int)((double)p_208529_3_ + 0.618D);

        for(int j = -i; j <= i; ++j) {
            for(int k = -i; k <= i; ++k) {
                if (Math.pow((double)Math.abs(j) + 0.5D, 2.0D) + Math.pow((double)Math.abs(k) + 0.5D, 2.0D) <= (double)(p_208529_3_ * p_208529_3_)) {
                    BlockPos blockpos = pos.add(j, 0, k);
                    if (isAirOrLeaves(worldIn, blockpos)) {
                        this.setLogState(changedBlocks, worldIn, blockpos, WILLOW_LEAVES, p_208529_4_);
                    }
                }
            }
        }

    }

    private float treeShape(int p_208527_1_, int p_208527_2_) {
        if ((float)p_208527_2_ < (float)p_208527_1_ * 0.3F) {
            return -1.0F;
        } else {
            float f = (float)p_208527_1_ / 2.0F;
            float f1 = f - (float)p_208527_2_;
            float f2 = MathHelper.sqrt(f * f - f1 * f1);
            if (f1 == 0.0F) {
                f2 = f;
            } else if (Math.abs(f1) >= f) {
                return 0.0F;
            }

            return f2 * 0.5F;
        }
    }

    private float foliageShape(int y) {
        if (y >= 0 && y < 5) {
            return y != 0 && y != 4 ? 3.0F : 2.0F;
        } else {
            return -1.0F;
        }
    }

    private void foliageCluster(IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox p_202393_3_, Set<BlockPos> changedBlocks) {
        for(int i = 0; i < 5; ++i) {
            this.crossSection(worldIn, pos.up(i), this.foliageShape(i), p_202393_3_, changedBlocks);
        }

    }

    private int makeLimb(Set<BlockPos> p_208523_1_, IWorldGenerationReader worldIn, BlockPos blockPos, BlockPos p_208523_4_, boolean p_208523_5_, MutableBoundingBox p_208523_6_) {
        if (!p_208523_5_ && Objects.equals(blockPos, p_208523_4_)) {
            return -1;
        } else {
            BlockPos blockpos = p_208523_4_.add(-blockPos.getX(), -blockPos.getY(), -blockPos.getZ());
            int i = this.getGreatestDistance(blockpos);
            float f = (float)blockpos.getX() / (float)i;
            float f1 = (float)blockpos.getY() / (float)i;
            float f2 = (float)blockpos.getZ() / (float)i;

            Random random = new Random();
            int chance = random.nextInt(5);
            for(int j = 0; j <= i; ++j) {
                BlockPos blockpos1 = blockPos.add((double)(0.5F + (float)j * f), (double)(0.5F + (float)j * f1), (double)(0.5F + (float)j * f2));
                if (p_208523_5_) {
                    if (chance == 0 && checkBiome((IWorld) worldIn, blockPos)) {
                        this.setLogState(p_208523_1_, worldIn, blockpos1, INFECTED_WILLOW_LOG.with(LogBlock.AXIS, this.getLoxAxis(blockPos, blockpos1)), p_208523_6_);
                    } else {
                        this.setLogState(p_208523_1_, worldIn, blockpos1, WILLOW_LOG.with(LogBlock.AXIS, this.getLoxAxis(blockPos, blockpos1)), p_208523_6_);
                    }

                } else if (!func_214587_a(worldIn, blockpos1)) {
                    return j;
                }
            }

            return -1;
        }
    }

    private boolean checkBiome(IWorld world, BlockPos pos) {
        return world.getBiome(pos) == ExplorerBiomes.FUNGAL_FOREST;
    }
    /**
     * Returns the absolute greatest distance in the BlockPos object.
     */
    private int getGreatestDistance(BlockPos posIn) {
        int i = MathHelper.abs(posIn.getX());
        int j = MathHelper.abs(posIn.getY());
        int k = MathHelper.abs(posIn.getZ());
        if (k > i && k > j) {
            return k;
        } else {
            return j > i ? j : i;
        }
    }

    private Direction.Axis getLoxAxis(BlockPos p_197170_1_, BlockPos p_197170_2_) {
        Direction.Axis direction$axis = Direction.Axis.Y;
        int i = Math.abs(p_197170_2_.getX() - p_197170_1_.getX());
        int j = Math.abs(p_197170_2_.getZ() - p_197170_1_.getZ());
        int k = Math.max(i, j);
        if (k > 0) {
            if (i == k) {
                direction$axis = Direction.Axis.X;
            } else if (j == k) {
                direction$axis = Direction.Axis.Z;
            }
        }

        return direction$axis;
    }

    private void makeFoliage(IWorldGenerationReader worldIn, int p_208525_2_, BlockPos pos, List<FoliageCoordinates> p_208525_4_, MutableBoundingBox p_208525_5_, Set<BlockPos> changedBlocks) {
        for(WillowTreeFeature.FoliageCoordinates WillowTreeFeature$foliagecoordinates : p_208525_4_) {
            if (this.trimBranches(p_208525_2_, WillowTreeFeature$foliagecoordinates.getBranchBase() - pos.getY())) {
                this.foliageCluster(worldIn, WillowTreeFeature$foliagecoordinates, p_208525_5_, changedBlocks);
            }
        }

    }

    private boolean trimBranches(int p_208522_1_, int p_208522_2_) {
        return (double)p_208522_2_ >= (double)p_208522_1_ * 0.2D;
    }

    private void makeTrunk(Set<BlockPos> p_208526_1_, IWorldGenerationReader p_208526_2_, BlockPos p_208526_3_, int p_208526_4_, MutableBoundingBox p_208526_5_) {
        this.makeLimb(p_208526_1_, p_208526_2_, p_208526_3_, p_208526_3_.up(p_208526_4_), true, p_208526_5_);
    }

    private void makeBranches(Set<BlockPos> p_208524_1_, IWorldGenerationReader p_208524_2_, int p_208524_3_, BlockPos p_208524_4_, List<WillowTreeFeature.FoliageCoordinates> p_208524_5_, MutableBoundingBox p_208524_6_) {
        for(WillowTreeFeature.FoliageCoordinates WillowTreeFeature$foliagecoordinates : p_208524_5_) {
            int i = WillowTreeFeature$foliagecoordinates.getBranchBase();
            BlockPos blockpos = new BlockPos(p_208524_4_.getX(), i, p_208524_4_.getZ());
            if (!blockpos.equals(WillowTreeFeature$foliagecoordinates) && this.trimBranches(p_208524_3_, i - p_208524_4_.getY())) {
                this.makeLimb(p_208524_1_, p_208524_2_, blockpos, WillowTreeFeature$foliagecoordinates, true, p_208524_6_);
            }
        }

    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        Random random = new Random(rand.nextLong());
        int i = this.checkLocation(changedBlocks, worldIn, position, 8 + random.nextInt(6), boundsIn);
        if (i == -1) {
            return false;
        } else {
            this.setDirtAt(worldIn, position.down(), position);
            int j = (int)((double)i * 0.618D);
            if (j >= i) {
                j = i - 1;
            }

            double d0 = 1.0D;
            int k = (int)(1.382D + Math.pow(1.0D * (double)i / 13.0D, 2.0D));
            if (k < 1) {
                k = 1;
            }

            int l = position.getY() + j;
            int i1 = i - 2;
            List<WillowTreeFeature.FoliageCoordinates> list = Lists.newArrayList();
            list.add(new WillowTreeFeature.FoliageCoordinates(position.up(i1), l));

            for(; i1 >= 0; --i1) {
                float f = this.treeShape(i, i1);
                if (!(f < 0.0F)) {
                    for(int j1 = 0; j1 < k; ++j1) {
                        double d1 = 1.5D;
                        double d2 = d1 * (double)f * ((double)random.nextFloat() + 0.681D);
                        double d3 = (double)(random.nextFloat() * 2.0F) * Math.PI;
                        double d4 = d2 * Math.sin(d3) + 0.7D;
                        double d5 = d2 * Math.cos(d3) + 0.7D;
                        BlockPos blockpos = position.add(d4, (double)(i1 - 1), d5);
                        BlockPos blockpos1 = blockpos.up(5);
                        if (this.makeLimb(changedBlocks, worldIn, blockpos, blockpos1, false, boundsIn) == -1) {
                            int k1 = position.getX() - blockpos.getX();
                            int l1 = position.getZ() - blockpos.getZ();
                            double d6 = (double)blockpos.getY() - Math.sqrt((double)(k1 * k1 + l1 * l1)) * 0.681D;
                            int i2 = d6 > (double)l ? l : (int)d6;
                            BlockPos blockpos2 = new BlockPos(position.getX(), i2, position.getZ());
                            if (this.makeLimb(changedBlocks, worldIn, blockpos2, blockpos, false, boundsIn) == -1) {
                                list.add(new WillowTreeFeature.FoliageCoordinates(blockpos, blockpos2.getY()));
                            }
                        }
                    }
                }
            }

            this.makeFoliage(worldIn, i, position, list, boundsIn, changedBlocks);
            this.makeTrunk(changedBlocks, worldIn, position, j, boundsIn);
            this.makeBranches(changedBlocks, worldIn, i, position, list, boundsIn);

            for(int j2 = position.getY() - 6 + i; j2 <= position.getY() + i; ++j2) {
                int l2 = j2 - (position.getY() + i);
                int j3 = 2 - l2 / 2;
                BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                for(int i4 = position.getX() - j3; i4 <= position.getX() + j3; ++i4) {
                    for(int j4 = position.getZ() - j3; j4 <= position.getZ() + j3; ++j4) {
                        blockpos$mutableblockpos1.setPos(i4, j2, j4);
                        if (isLeaves(worldIn, blockpos$mutableblockpos1)) {
                            BlockPos blockpos4 = blockpos$mutableblockpos1.west();
                            BlockPos blockpos5 = blockpos$mutableblockpos1.east();
                            BlockPos blockpos1 = blockpos$mutableblockpos1.north();
                            BlockPos blockpos2 = blockpos$mutableblockpos1.south();
                            if (rand.nextInt(1) == 0 && isAir(worldIn, blockpos4)) {
                                this.addVine(worldIn, blockpos4, VineBlock.EAST);
                            }

                            if (rand.nextInt(1) == 0 && isAir(worldIn, blockpos5)) {
                                this.addVine(worldIn, blockpos5, VineBlock.WEST);
                            }

                            if (rand.nextInt(1) == 0 && isAir(worldIn, blockpos1)) {
                                this.addVine(worldIn, blockpos1, VineBlock.SOUTH);
                            }

                            if (rand.nextInt(1) == 0 && isAir(worldIn, blockpos2)) {
                                this.addVine(worldIn, blockpos2, VineBlock.NORTH);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    private void addVine(IWorldGenerationReader worldIn, BlockPos pos, BooleanProperty prop) {
        BlockState blockstate = ExplorerBlocks.WILLOW.getDefaultState().with(prop, Boolean.valueOf(true));
        this.setBlockState(worldIn, pos, blockstate);
        Random random = new Random();
        int i = 5 + random.nextInt(4);

        for(BlockPos blockpos = pos.down(); isAir(worldIn, blockpos) && i > 0; --i) {
            this.setBlockState(worldIn, blockpos, blockstate);
            blockpos = blockpos.down();
        }

    }

    private int checkLocation(Set<BlockPos> p_208528_1_, IWorldGenerationReader p_208528_2_, BlockPos p_208528_3_, int p_208528_4_, MutableBoundingBox p_208528_5_) {
        if (!isSoilOrFarm(p_208528_2_, p_208528_3_.down(), getSapling())) {
            return -1;
        } else {
            int i = this.makeLimb(p_208528_1_, p_208528_2_, p_208528_3_, p_208528_3_.up(p_208528_4_ - 1), false, p_208528_5_);
            if (i == -1) {
                return p_208528_4_;
            } else {
                return i < 6 ? -1 : i;
            }
        }
    }

    static class FoliageCoordinates extends BlockPos {
        private final int branchBase;

        public FoliageCoordinates(BlockPos pos, int p_i45635_2_) {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.branchBase = p_i45635_2_;
        }

        public int getBranchBase() {
            return this.branchBase;
        }
    }

}