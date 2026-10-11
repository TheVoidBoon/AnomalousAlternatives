package com.alternativeprocedures.anomalousalternatives.effect;

import com.alternativeprocedures.anomalousalternatives.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForgeMod;

public class BananaInflationEffect extends MobEffect {
    public BananaInflationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public void onMobRemoved(ServerLevel level, LivingEntity mob, int amplifier, Entity.RemovalReason reason) {

        ItemStack banana = new ItemStack(ModItems.BANANA.get(), 64);
        ItemEntity bananaEntity = new ItemEntity(level,mob.getX(),mob.getY(),mob.getZ(),banana);



        level.addFreshEntity(bananaEntity);


        super.onMobRemoved(level, mob, amplifier, reason);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {

        mob.hurtServer(serverLevel, mob.damageSources().magic(), 3.0F * (amplification + 1));


        return super.applyEffectTick(serverLevel, mob , amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
