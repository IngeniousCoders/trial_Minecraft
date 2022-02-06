package com.ingeniousmc.tutrialmod.tileentity;

import com.ingeniousmc.tutrialmod.block.ModBlocks;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.tileentity.TileEntityType.Builder.create;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, tutorialMod.MOD_ID);

    public static RegistryObject<TileEntityType<LightningChannelerTile>> LIGHTNING_CHANNELER_TILE =
            TILE_ENTITIES.register("lightning_channeler_tile", () -> create(
                    LightningChannelerTile::new, ModBlocks.LIGHTNING_CHANNELER.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
