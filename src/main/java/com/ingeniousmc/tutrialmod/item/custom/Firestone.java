package com.ingeniousmc.tutrialmod.item.custom;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class Firestone extends Item {
    public Firestone(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }
    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if(!world.isRemote) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClickOnCertainBlockState(clickedBlock, context, playerEntity);
            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.tutrialmod.firestone"));
        }else{
            tooltip.add(new TranslationTextComponent("tooltip.tutrialmod.firestone_shift"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context, PlayerEntity playerEntity) {
        boolean playerIsNotOnFire = !playerEntity.isBurning();

        if(random.nextFloat()>0.5f){
        //player on fire
            lightEntityOnFire(playerEntity, 10);
        }else if (playerIsNotOnFire&& BlockIsValidForResistance(clickedBlock)){
            //player resistance
            gainFirePowerAndBreakBlocks(playerEntity, context.getWorld(), context.getPos());
        }else{
            PowerStrike(context);


        }

    }

    private boolean BlockIsValidForResistance(BlockState clickedBlock) {
        return clickedBlock.getBlock() == Blocks.OBSIDIAN;
    }
    public static void lightEntityOnFire(Entity entity, int seconds){
        entity.setFire(seconds);
    }
    private static void gainFirePowerAndBreakBlocks(PlayerEntity playerEntity, World world, BlockPos pos){
    gainFireResistance(playerEntity);
    world.destroyBlock(pos, false);
    }
    public static void gainFireResistance(PlayerEntity playerEntity){
        playerEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 100000));
    }
    public static void PowerStrike(ItemUseContext context){

        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos().offset(context.getFace());

            if (AbstractFireBlock.canLightBlock(world, blockpos, context.getPlacementHorizontalFacing())) {
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE,
                        SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);

                BlockState blockstate = AbstractFireBlock.getFireForPlacement(world, blockpos);

                world.setBlockState(blockpos, blockstate, 11);
                }

            }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if(container.attemptDamageItem(1, random, null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
        }





