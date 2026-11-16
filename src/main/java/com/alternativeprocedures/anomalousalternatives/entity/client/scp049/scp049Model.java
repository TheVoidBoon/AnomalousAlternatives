package com.alternativeprocedures.anomalousalternatives.entity.client.scp049;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class scp049Model extends EntityModel<scp049RenderState> {
    private final ModelPart head;
    private final ModelPart Mask;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;


    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idlingAnimation;
    private final KeyframeAnimation chasingAnimation;
    private final KeyframeAnimation targetingAnimation;
    private final KeyframeAnimation chasingendAnimation;

    public scp049Model (ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.Mask = this.head.getChild("Mask");
        this.body = root.getChild("body");
        this.right_arm = this.body.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");

        this.walkingAnimation = scp049Animations.Walk.bake(root);
        this.idlingAnimation = scp049Animations.idle.bake(root);
        this.chasingAnimation = scp049Animations.Chase.bake(root);
        this.targetingAnimation = scp049Animations.Target.bake(root);
        this.chasingendAnimation = scp049Animations.chase_end.bake(root);

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -15.5F, -9.3676F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-4.0F, -15.0F, -8.8676F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -4.1324F, -3.1416F, 0.0F, -3.1416F));

        PartDefinition Mask = head.addOrReplaceChild("Mask", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -2.4496F, 9.6487F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Mask.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(53, 0).addBox(-0.5F, -8.2906F, 11.6197F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(29, 34).addBox(-0.5F, -10.2906F, 5.6197F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9778F, -2.2564F, 2.7925F, 0.0F, 3.1416F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 18).addBox(-4.5F, 3.0F, -8.3676F, 9.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-4.0F, -7.0F, -7.8676F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -4.1324F, -3.1416F, 0.0F, -3.1416F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(28, 45).addBox(-8.0F, -7.0F, -6.8676F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.0F, -4.1324F, -3.1416F, 0.0F, -3.1416F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(-6.0F, 1.0F, 0.0F));

        PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -0.8676F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.1324F, 0.7352F, 3.1416F, 0.0F, 3.1416F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

        PartDefinition left_leg_r1 = left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(44, 45).addBox(0.0F, 5.0F, -6.8676F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, -4.1324F, -3.1416F, 0.0F, -3.1416F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        PartDefinition right_leg_r1 = right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-4.0F, 5.0F, -6.8676F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.0F, -4.1324F, -3.1416F, 0.0F, -3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(scp049RenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot,state.xRot);


        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 1f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
        this.targetingAnimation.apply(state.targetingAnimationState, state.ageInTicks, 1f);

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f,30f);
        headPitch = Mth.clamp(headPitch, -25f,45f);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch * ((float)Math.PI / 180f);


    }

}
