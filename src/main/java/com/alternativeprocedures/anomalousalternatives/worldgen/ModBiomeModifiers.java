package com.alternativeprocedures.anomalousalternatives.worldgen;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.Weighted;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    // PF to BiomeModifier
    // NeoForge Class -> Places PlacedFeatures into specific Biomes

    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_TITANIUM_ORE = registerKey("add_overworld_titanium_ore");

    public static final ResourceKey<BiomeModifier> SPAWN_DEER = registerKey("spawn_deer");


    public static void bootstrap(BootstrapContext<BiomeModifier>  context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_OVERWORLD_TITANIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OVERWORLD_TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SPAWN_DEER, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),biomes.getOrThrow(Biomes.FLOWER_FOREST),biomes.getOrThrow(Biomes.DARK_FOREST)),
                new Weighted<>(new MobSpawnSettings.SpawnerData(ModEntities.DEER.get(), 3,6), 20)));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, name));
    }

}
