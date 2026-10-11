package com.alternativeprocedures.anomalousalternatives.food;

import com.alternativeprocedures.anomalousalternatives.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {

    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build();
    public static final FoodProperties SCP3521 = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build();


    public static final Consumable BANANA_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2f).build();
    public static final Consumable SCP3521_CONSUMABLE = Consumables.defaultFood().consumeSeconds(1f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.BANANA_INFLATION_EFFECT, 800), 1f)).build();


}
