package com.alternativeprocedures.anomalousalternatives.effect;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.ModEntities;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp049_2Entity;
import com.alternativeprocedures.anomalousalternatives.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.datafix.fixes.EntityFallDistanceFloatToDoubleFix;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;




public class HeartAttackEffect extends MobEffect {
    public HeartAttackEffect(MobEffectCategory category, int color) {super(category, color);}

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {

        mob.hurtServer(serverLevel, mob.damageSources().magic(), 8F * (amplification + 1));


        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onMobRemoved(ServerLevel level, LivingEntity mob, int amplifier, Entity.RemovalReason reason) {


        super.onMobRemoved(level, mob, amplifier, reason);
    }



    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {return true;}
}
