package com.ingeniousmc.tutrialmod.entity.render;

import com.ingeniousmc.tutrialmod.entity.custom.BuffZombieEntity;
import com.ingeniousmc.tutrialmod.entity.model.BuffZombieModel;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffZombieRenderer extends MobRenderer<BuffZombieEntity, BuffZombieModel<BuffZombieEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(tutorialMod.MOD_ID, "textures/entity/buff_zombie.png");

    public BuffZombieRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BuffZombieModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffZombieEntity entity) {
        return TEXTURE;
    }
}
