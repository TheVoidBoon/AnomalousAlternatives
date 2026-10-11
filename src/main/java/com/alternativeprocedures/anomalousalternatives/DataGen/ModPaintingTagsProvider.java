package com.alternativeprocedures.anomalousalternatives.DataGen;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagsProvider extends PaintingVariantTagsProvider {


    public ModPaintingTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SCPAnomalousAlternatives.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
                .add(TagEntry.optionalElement(ModPaintings.TUNG_KEY.identifier()));
    }
}
