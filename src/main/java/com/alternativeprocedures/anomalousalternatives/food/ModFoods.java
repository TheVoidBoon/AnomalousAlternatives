package com.alternativeprocedures.anomalousalternatives.food;

import com.alternativeprocedures.anomalousalternatives.effect.ModEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.level.block.SoundType;

public class ModFoods {

    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build();
    public static final FoodProperties RAW_VENISON = new FoodProperties.Builder().nutrition(4).saturationModifier(0.2f).build();
    public static final FoodProperties COOKED_VENISON = new FoodProperties.Builder().nutrition(9).saturationModifier(1.5f).build();
    public static final FoodProperties SCP3521 = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).alwaysEdible().build();
    public static final FoodProperties SCP207 = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).alwaysEdible().build();


    public static final Consumable BANANA_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2f).build();
    public static final Consumable RAW_VENISON_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 120), 0.1f)).build();
    public static final Consumable COOKED_VENISON_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2f).build();
    public static final Consumable SCP3521_CONSUMABLE = Consumables.defaultFood().consumeSeconds(0.5f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.BANANA_INFLATION_EFFECT, 800))).build();
    public static final Consumable SCP207_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.COLA_OVERDOSE_EFFECT, 1200))).sound(SoundEvents.GENERIC_DRINK).build();


}
