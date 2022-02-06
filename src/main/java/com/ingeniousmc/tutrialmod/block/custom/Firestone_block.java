package com.ingeniousmc.tutrialmod.block.custom;

import com.ingeniousmc.tutrialmod.item.custom.Firestone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class Firestone_block extends Block {
    public Firestone_block(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(!worldIn.isRemote){
            if(handIn == Hand.MAIN_HAND){
                System.out.println("I clicked a firestoneblock with MAIN hand");
            }
            if(handIn == Hand.OFF_HAND){
                System.out.println("I clicked a firestoneblock with OFF hand");
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote){
            System.out.println("Left Clicked");
        }
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        float chance = 0.35f;
        if(chance < rand.nextFloat()) {
            worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0d,0.05d,0d);

            worldIn.addParticle(new BlockParticleData(ParticleTypes.BLOCK, stateIn), pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0.0D, 0.05D, 0.0D);
        }

        super.animateTick(stateIn, worldIn, pos, rand);
    }
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn, 9);
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
