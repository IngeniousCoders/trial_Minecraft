package com.ingeniousmc.tutrialmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup TUTORIAL_MOD = new ItemGroup("tutorialModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.AMETHYST.get());
        }
    };
}
