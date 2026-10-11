package com.alternativeprocedures.anomalousalternatives.entity.client.deer;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DeerModel extends EntityModel<DeerRenderState> {
    private final ModelPart Torso;
    private final ModelPart Head;
    private final ModelPart Ears;
    private final ModelPart Neck;
    private final ModelPart Antlers;
    private final ModelPart Left_leg_1;
    private final ModelPart Left_leg_2;
    private final ModelPart Right_leg_1;
    private final ModelPart Right_leg_2;


    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idlingAnimation;


    public DeerModel (ModelPart root) {
        super(root);
        this.Torso = root.getChild("Torso");
        this.Head = root.getChild("Head");
        this.Ears = this.Head.getChild("Ears");
        this.Neck = this.Head.getChild("Neck");
        this.Antlers = this.Head.getChild("Antlers");
        this.Left_leg_1 = root.getChild("Left_leg_1");
        this.Left_leg_2 = root.getChild("Left_leg_2");
        this.Right_leg_1 = root.getChild("Right_leg_1");
        this.Right_leg_2 = root.getChild("Right_leg_2");

        this.walkingAnimation = DeerAnimations.walk_cycle.bake(root);
        this.idlingAnimation = DeerAnimations.idle.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.1958F, -9.7223F, 7.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 12.0F, 1.0F));

        PartDefinition Tail_r1 = Torso.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(48, 39).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, 9.0F, 0.829F, 0.0F, 0.0F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 41).addBox(-2.0F, 0.0F, -4.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(48, 33).addBox(-2.0F, 2.0F, -8.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -7.5F));

        PartDefinition Ears = Head.addOrReplaceChild("Ears", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -2.0F));

        PartDefinition Left_ear_r1 = Ears.addOrReplaceChild("Left_ear_r1", CubeListBuilder.create().texOffs(48, 46).addBox(1.5089F, -4.306F, -1.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.0F, 0.0F, 1.2654F));

        PartDefinition Right_ear_r1 = Ears.addOrReplaceChild("Right_ear_r1", CubeListBuilder.create().texOffs(32, 49).addBox(-3.5088F, -4.306F, -1.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.0F, 0.0F, -1.2654F));

        PartDefinition Neck = Head.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(-0.5F, 13.0F, 8.5F));

        PartDefinition Neck_r1 = Neck.addOrReplaceChild("Neck_r1", CubeListBuilder.create().texOffs(18, 41).addBox(-1.8F, -3.0F, -3.0F, 3.8F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -8.0F, -8.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition Antlers = Head.addOrReplaceChild("Antlers", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 7.5F));

        PartDefinition Left_antler_r1 = Antlers.addOrReplaceChild("Left_antler_r1", CubeListBuilder.create().texOffs(32, 41).addBox(2.0261F, -4.1809F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, -9.5F, -0.387F, -0.8036F, 0.5152F));

        PartDefinition Right_antler_r1 = Antlers.addOrReplaceChild("Right_antler_r1", CubeListBuilder.create().texOffs(48, 25).addBox(-10.0261F, -4.1809F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, -9.5F, -0.387F, 0.8036F, -0.5152F));

        PartDefinition Left_leg_1 = partdefinition.addOrReplaceChild("Left_leg_1", CubeListBuilder.create().texOffs(0, 25).addBox(0.0F, 0.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 11.0F, -5.0F));

        PartDefinition Left_leg_2 = partdefinition.addOrReplaceChild("Left_leg_2", CubeListBuilder.create().texOffs(24, 25).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, 6.0F));

        PartDefinition Right_leg_1 = partdefinition.addOrReplaceChild("Right_leg_1", CubeListBuilder.create().texOffs(12, 25).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, -5.0F));

        PartDefinition Right_leg_2 = partdefinition.addOrReplaceChild("Right_leg_2", CubeListBuilder.create().texOffs(36, 25).addBox(-1.0F, 1.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 10.0F, 6.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(DeerRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot,state.xRot);


        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f,30f);
        headPitch = Mth.clamp(headPitch, -25f,45f);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch * ((float)Math.PI / 180f);


    }

}
