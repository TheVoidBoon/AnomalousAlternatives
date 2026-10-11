package com.alternativeprocedures.anomalousalternatives.DataGen;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SCPAnomalousAlternatives.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.CONCRETE_TILES.get())
                .add(ModBlocks.METAL_PLATING.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.TITANIUM_BLOCK.get());

    }
}
