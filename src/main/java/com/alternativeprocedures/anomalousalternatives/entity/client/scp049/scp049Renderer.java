package com.alternativeprocedures.anomalousalternatives.entity.client.scp049;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.client.ModModelLayerLocations;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp049Entity;
import net.minecraft.resources.Identifier;

public class scp049Renderer extends MobRenderer<scp049Entity,scp049RenderState,scp049Model> {


    public scp049Renderer(EntityRendererProvider.Context context) {
        super(context, new scp049Model(context.bakeLayer(ModModelLayerLocations.SCP049)), 0.65f);
    }

    @Override
    public scp049RenderState createRenderState() {return new scp049RenderState();}

    @Override
    public Identifier getTextureLocation(scp049RenderState scp049RenderState) {
        return Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "textures/entity/scp049/scp049.png");
    }



    @Override
    public void extractRenderState(scp049Entity entity, scp049RenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
