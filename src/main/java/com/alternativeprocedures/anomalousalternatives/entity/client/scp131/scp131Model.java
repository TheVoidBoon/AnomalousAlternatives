package com.alternativeprocedures.anomalousalternatives.entity.client.scp131;

import com.alternativeprocedures.anomalousalternatives.entity.client.deer.DeerAnimations;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class scp131Model extends EntityModel<scp131RenderState>{
    private final ModelPart Eyepod;

    private final KeyframeAnimation idlingAnimation;
    private final KeyframeAnimation walkingAnimation;

    public scp131Model (ModelPart root) {
        super(root);
        this.Eyepod = root.getChild("Eyepod");


        this.idlingAnimation = scp131Animations.idle.bake(root);
        this.walkingAnimation = scp131Animations.walk_cycle.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Eyepod = partdefinition.addOrReplaceChild("Eyepod", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Thing_r1 = Eyepod.addOrReplaceChild("Thing_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -2.0F, -0.6981F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(scp131RenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot,state.xRot);

        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }
    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f,30f);
        headPitch = Mth.clamp(headPitch, -25f,45f);

        this.Eyepod.yRot = headYaw * ((float)Math.PI / 180f);
        this.Eyepod.xRot = headPitch * ((float)Math.PI / 180f);


    }

}
