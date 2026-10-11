package com.alternativeprocedures.anomalousalternatives.item;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.food.ModFoods;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import  net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SCPAnomalousAlternatives.MODID);


    public static final DeferredItem<Item> Scp035 = ITEMS.registerSimpleItem("scp035");
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.registerSimpleItem("raw_titanium");
    public static final DeferredItem<Item> TITANIUM_INGOT = ITEMS.registerSimpleItem("titanium_ingot");
    public static final DeferredItem<Item> TITANIUM_NUGGET = ITEMS.registerSimpleItem("titanium_nugget");
    public static final DeferredItem<Item> TITANIUM_PLATE = ITEMS.registerSimpleItem("titanium_plate");

    public static final DeferredItem<Item> BANANA = ITEMS.registerItem("banana",
            properties -> new Item(properties.food(ModFoods.BANANA, ModFoods.BANANA_CONSUMABLE)));
    public static final DeferredItem<Item> SCP3521= ITEMS.registerItem("scp3521",
            properties -> new Item(properties.food(ModFoods.SCP3521, ModFoods.SCP3521_CONSUMABLE)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.scpanomalousalternatives.scp3521.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
