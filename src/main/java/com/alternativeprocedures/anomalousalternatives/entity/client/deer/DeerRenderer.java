package com.alternativeprocedures.anomalousalternatives.entity.client.deer;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.client.ModModelLayerLocations;
import com.alternativeprocedures.anomalousalternatives.entity.custom.DeerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class DeerRenderer extends MobRenderer<DeerEntity, DeerRenderState, DeerModel> {
    public DeerRenderer(EntityRendererProvider.Context context) {
        super(context, new DeerModel(context.bakeLayer(ModModelLayerLocations.DEER)), 0.65f);
    }

    @Override
    public Identifier getTextureLocation(DeerRenderState deerRenderState) {
        return Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "textures/entity/deer/deer.png");
    }

    @Override
    public DeerRenderState createRenderState() {
        return new DeerRenderState();
    }

    @Override
    public void extractRenderState(DeerEntity entity, DeerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
