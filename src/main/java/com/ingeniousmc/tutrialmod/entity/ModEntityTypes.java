package com.ingeniousmc.tutrialmod.entity;

import com.ingeniousmc.tutrialmod.entity.custom.BuffZombieEntity;
import com.ingeniousmc.tutrialmod.entity.custom.PigeonEntity;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
        = DeferredRegister.create(ForgeRegistries.ENTITIES, tutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFF_ZOMBIE =
            ENTITY_TYPES.register("buff_zombie",
                    () -> EntityType.Builder.create(BuffZombieEntity::new,
                                    EntityClassification.MONSTER).size(1f, 3f)
                            .build(new ResourceLocation(tutorialMod.MOD_ID, "buff_zombie").toString()));

    public static final RegistryObject<EntityType<PigeonEntity>> PIGEON =
            ENTITY_TYPES.register("pigeon",
                    () -> EntityType.Builder.create(PigeonEntity::new,
                                    EntityClassification.CREATURE).size(0.4f, 0.3f)
                            .build(new ResourceLocation(tutorialMod.MOD_ID, "pigeon").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

