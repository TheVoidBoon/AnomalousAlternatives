package com.alternativeprocedures.anomalousalternatives.entity.client.scp131;


import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.client.ModModelLayerLocations;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp131Entity;
import com.alternativeprocedures.anomalousalternatives.entity.variant.scp131Variant;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

import java.util.Map;


public class scp131Renderer extends MobRenderer<scp131Entity, scp131RenderState, scp131Model> {
    private static final Map<scp131Variant, Identifier> VARIANT_TO_TEXTURE =
            Util.make(Maps.newEnumMap(scp131Variant.class), map ->{
                map.put(scp131Variant.ORANGE, Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID,"textures/entity/scp131/scp131_orange.png" ));
                map.put(scp131Variant.YELLOW, Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID,"textures/entity/scp131/scp131_yellow.png" ));
    });


    public scp131Renderer(EntityRendererProvider.Context context) {
        super(context, new scp131Model(context.bakeLayer(ModModelLayerLocations.SCP131)), 0.65f);
    }

    @Override
    public scp131RenderState createRenderState() {
        return new scp131RenderState();
    }

    @Override
    public Identifier getTextureLocation(scp131RenderState scp131RenderState) {
            return VARIANT_TO_TEXTURE.get(scp131RenderState.variant);
    }

    @Override
    public void extractRenderState(scp131Entity entity, scp131RenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.variant = entity.getVariant();
    }


}
