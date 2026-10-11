package com.alternativeprocedures.anomalousalternatives.entity.client.scp131;


import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.client.ModModelLayerLocations;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp131Entity;
import net.minecraft.resources.Identifier;


public class scp131Renderer extends MobRenderer<scp131Entity, scp131RenderState, scp131Model> {
    public scp131Renderer(EntityRendererProvider.Context context) {
        super(context, new scp131Model(context.bakeLayer(ModModelLayerLocations.SCP131)), 0.65f);
    }

    @Override
    public scp131RenderState createRenderState() {
        return new scp131RenderState();
    }

    @Override
    public Identifier getTextureLocation(scp131RenderState scp131RenderState) {
            return Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "textures/entity/scp131/scp131_orange.png");
    }

    @Override
    public void extractRenderState(scp131Entity entity, scp131RenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }


}
