package com.alternativeprocedures.anomalousalternatives.entity.client.scp049_2;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.client.ModModelLayerLocations;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp049_2Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;


public class scp049_2Renderer extends MobRenderer<scp049_2Entity,scp049_2RenderState,scp049_2Model> {

    public scp049_2Renderer(EntityRendererProvider.Context context) {
        super(context, new scp049_2Model(context.bakeLayer(ModModelLayerLocations.SCP049_2)), 0.65f);
    }

    @Override
    public scp049_2RenderState createRenderState() {return new scp049_2RenderState();}

    @Override
    public Identifier getTextureLocation(scp049_2RenderState scp049_2RenderState) {
        return Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "textures/entity/scp049_2/scp049_2.png");
    }



    @Override
    public void extractRenderState(scp049_2Entity entity, scp049_2RenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
