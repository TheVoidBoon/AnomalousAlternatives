package com.alternativeprocedures.anomalousalternatives.effect;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ColaOverdoseEffect extends MobEffect {
    public ColaOverdoseEffect(MobEffectCategory category, int color){ super(category, color); }


    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {

        mob.hurtServer(serverLevel, mob.damageSources().magic(), 0.1F * (amplification + 1));
        addAttributeModifier(Attributes.MOVEMENT_SPEED, Identifier.withDefaultNamespace("effect.speed"),
                (double)0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, Identifier.withDefaultNamespace("effect.haste"),
                (double)0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);


        return super.applyEffectTick(serverLevel, mob , amplification);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }

}
