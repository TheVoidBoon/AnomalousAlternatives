package com.alternativeprocedures.anomalousalternatives.entity.custom;

import com.alternativeprocedures.anomalousalternatives.effect.ModEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class scp049Entity extends PathfinderMob {


    public scp049Entity(EntityType<? extends PathfinderMob> type, Level level) {super(type, level);}

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            this.setupAnimationStates();
        }
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class,20));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class,true));
        goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ZombieVillager.class,true));
        goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Villager.class,true));
        goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Zombie.class,true));
        goalSelector.addGoal(4, new MeleeAttackGoal(this,1d, false));
        goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        goalSelector.addGoal(6, new RandomStrollGoal(this, 1d));



    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        if(target != null){
            if(target.hasEffect(ModEffects.LAVENDER_SCENT)){

            }
            else {
            super.setTarget(target);
            }
        }

    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {


        target.asLivingEntity().addEffect(new MobEffectInstance(ModEffects.HEART_ATTACK_EFFECT, 300));

        return super.doHurtTarget(level, target);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.TEMPT_RANGE, 15d)
                .add(Attributes.FOLLOW_RANGE, 15d)
                .add(Attributes.ATTACK_DAMAGE, 2d)
                .add(Attributes.ATTACK_SPEED, 1d);


    }


}
