package com.alternativeprocedures.anomalousalternatives.block;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.block.custom.FlatLampBlock;
import com.alternativeprocedures.anomalousalternatives.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SCPAnomalousAlternatives.MODID);


    public static final DeferredBlock<Block> CONCRETE_TILES = registerBlock("concrete_tiles",
            properties -> new Block(properties.strength(4f)));
    public static final DeferredBlock<Block> CHECKERED_TILES = registerBlock("checkered_tiles",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2,4),(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE))));
    public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3,5),(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))));
    public static final DeferredBlock<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            properties -> new Block((properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL))));
    public static final DeferredBlock<Block> METAL_PLATING = registerBlock("metal_plating",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL).explosionResistance(100)));
    public static final DeferredBlock<Block> LAVENDER_FLOWER = registerBlock("lavender_flower",
            properties -> new FlowerBlock(MobEffects.BLINDNESS, 10f, properties.noCollision().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> POTTED_LAVENDER_FLOWER = registerBlock("potted_lavender_flower",
            properties -> new FlowerPotBlock(LAVENDER_FLOWER.get(),properties.instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> HEAVY_DOOR = registerBlock("heavy_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.IRON).noOcclusion().explosionResistance(100)));
    public static final DeferredBlock<Block> FLAT_LAMP = registerBlock("flat_lamp",
            properties -> new FlatLampBlock(properties.strength(1.5f).lightLevel(state -> 15)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> METAL_GRATE = registerBlock("metal_grate",
            properties -> new Block(properties.requiresCorrectToolForDrops().strength(2f).noOcclusion()));



    private static <T extends  Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
