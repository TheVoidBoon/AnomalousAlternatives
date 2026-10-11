package com.alternativeprocedures.anomalousalternatives.DataGen;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.block.ModBlocks;
import com.alternativeprocedures.anomalousalternatives.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;


public class ModModelProvider extends ModelProvider{


    public ModModelProvider(PackOutput output) {
        super(output, SCPAnomalousAlternatives.MODID);
    }


    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){
        itemModels.generateFlatItem(ModItems.BANANA.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.Scp035.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SCP3521.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_TITANIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TITANIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TITANIUM_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TITANIUM_PLATE.get(), ModelTemplates.FLAT_ITEM);


        /* BLOCKS */

        blockModels.createTrivialCube(ModBlocks.CONCRETE_TILES.get());
        blockModels.createTrivialCube(ModBlocks.TITANIUM_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
        blockModels.createTrivialCube(ModBlocks.TITANIUM_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.METAL_PLATING.get());



    }


}
