package com.alternativeprocedures.anomalousalternatives.entity.custom;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class scp049_2Entity extends PathfinderMob {
    public scp049_2Entity(EntityType<? extends PathfinderMob> type, Level level) {super(type, level);}

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
        goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class,true));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class,true));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieVillager.class,true));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class,true));
        goalSelector.addGoal(3, new MeleeAttackGoal(this,1d, false));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        goalSelector.addGoal(8, new RandomStrollGoal(this, 1d));


    }

    public static AttributeSupplier.Builder createAttributes(){
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30d)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.TEMPT_RANGE, 16d)
                .add(Attributes.FOLLOW_RANGE, 24d)
                .add(Attributes.ATTACK_DAMAGE, 8d)
                .add(Attributes.ATTACK_SPEED, 1d);


    }
}
