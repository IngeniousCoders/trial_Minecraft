package com.ingeniousmc.tutrialmod.item;

import com.ingeniousmc.tutrialmod.block.ModBlocks;
import com.ingeniousmc.tutrialmod.entity.ModEntityTypes;
import com.ingeniousmc.tutrialmod.fluid.ModFluids;
import com.ingeniousmc.tutrialmod.item.custom.Firestone;
import com.ingeniousmc.tutrialmod.item.custom.ModSpawnEggItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, tutorialMod.MOD_ID);

    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Firestone(new Item.Properties().group(ModItemGroup.TUTORIAL_MOD).maxDamage(100)));

    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModItemTier.AMETHYST, 500, 0.1f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_PICKAXE1 = ITEMS.register("amethyst_pickaxe1",
            () -> new PickaxeItem(ModItemTier.AMETHYST, 50, -5f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModItemTier.AMETHYST, 501, -0.1f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModItemTier.AMETHYST, 50, -5f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModItemTier.AMETHYST, 50, -5f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_LEGGING = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> AMETHYST_HORSE_ARMOR = ITEMS.register("amethyst_horse_armor",
            () -> new HorseArmorItem(9, "amethyst",
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<ModSpawnEggItem> BUFF_ZOMBIE_SPAWN_EGG = ITEMS.register("buff_zombie_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BUFF_ZOMBIE, 0x464F56, 0x1D6336,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<ModSpawnEggItem> PIGEON_SPAWN_EGG = ITEMS.register("pigeon_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.PIGEON, 0x879995, 0x576ABC,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_MOD)));

    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(() -> ModFluids.OIL_FLUID.get(),
                    new Item.Properties().maxStackSize(1).group(ModItemGroup.TUTORIAL_MOD)));


    public static final RegistryObject<Item> OATS = ITEMS.register("oats",
            () -> new BlockItem(ModBlocks.OATS.get(),
                    new Item.Properties().food(new Food.Builder().hunger(1).saturation(5.1f)
                            .fastToEat().build()).group(ModItemGroup.TUTORIAL_MOD)));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
