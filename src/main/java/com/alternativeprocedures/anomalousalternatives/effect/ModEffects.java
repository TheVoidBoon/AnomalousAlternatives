package com.alternativeprocedures.anomalousalternatives.effect;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, SCPAnomalousAlternatives.MODID);

    public static  final Holder<MobEffect> BANANA_INFLATION_EFFECT = MOB_EFFECTS.register("banana_inflation",
        () -> new BananaInflationEffect(MobEffectCategory.NEUTRAL, 0x36ebab));



    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }



}
