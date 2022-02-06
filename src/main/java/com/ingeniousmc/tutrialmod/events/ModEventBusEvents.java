package com.ingeniousmc.tutrialmod.events;

import com.ingeniousmc.tutrialmod.entity.ModEntityTypes;
import com.ingeniousmc.tutrialmod.entity.custom.BuffZombieEntity;
import com.ingeniousmc.tutrialmod.entity.custom.PigeonEntity;
import com.ingeniousmc.tutrialmod.item.custom.ModSpawnEggItem;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = tutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.PIGEON.get(), PigeonEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}