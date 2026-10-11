package com.alternativeprocedures.anomalousalternatives.creativemodetab;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.block.ModBlocks;
import com.alternativeprocedures.anomalousalternatives.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SCPAnomalousAlternatives.MODID);

    public static final Supplier<CreativeModeTab> ANOMALOUS_ITEMS_TAB = CREATIVE_MODE_TABS.register("anomalous_items_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Scp035.get()))
                .title(Component.translatable("creativemodetab.anomalousalternatives_items"))
                .withTabsAfter(Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID,"anomalous_blocks_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModItems.Scp035);
                    output.accept(ModItems.SCP3521);
                    output.accept(ModItems.TITANIUM_PLATE);
                    output.accept(ModItems.TITANIUM_NUGGET);
                    output.accept(ModItems.TITANIUM_INGOT);
                    output.accept(ModItems.RAW_TITANIUM);
                }).build() );





    public static final Supplier<CreativeModeTab> ANOMALOUS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("anomalous_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CONCRETE_TILES.get()))
                    .title(Component.translatable("creativemodetab.anomalousalternatives_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CONCRETE_TILES);
                        output.accept(ModBlocks.TITANIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE);
                        output.accept(ModBlocks.TITANIUM_BLOCK);
                        output.accept(ModBlocks.METAL_PLATING);
                    }).build() );


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
