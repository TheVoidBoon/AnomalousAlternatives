package com.alternativeprocedures.anomalousalternatives.entity.client.scp131;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import com.alternativeprocedures.anomalousalternatives.entity.variant.scp131Variant;

public class scp131RenderState extends LivingEntityRenderState {

    public final AnimationState idleAnimationState = new AnimationState();
    public scp131Variant variant;
}
