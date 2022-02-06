package com.ingeniousmc.tutrialmod.entity.render;

import com.ingeniousmc.tutrialmod.entity.custom.PigeonEntity;
import com.ingeniousmc.tutrialmod.entity.model.PigeonModel;
import com.ingeniousmc.tutrialmod.tutorialMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PigeonRenderer extends MobRenderer<PigeonEntity, PigeonModel<PigeonEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(tutorialMod.MOD_ID, "textures/entity/pigeon.png");

    public PigeonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PigeonModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(PigeonEntity entity) {
        return TEXTURE;
    }
}
