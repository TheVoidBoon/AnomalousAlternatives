package com.alternativeprocedures.anomalousalternatives.DataGen;

import com.alternativeprocedures.anomalousalternatives.AnomalousAlternativesDataGen;
import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.block.ModBlocks;
import com.alternativeprocedures.anomalousalternatives.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {


    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner{

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "SCPAnomalousAlternatives Recipes";
        }
    }



    @Override
    protected void buildRecipes() {

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT))
                .group("titanium")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.METAL_PLATING.get())
                .pattern(" T ")
                .pattern("TIT")
                .pattern(" T ")
                .define('T', ModItems.TITANIUM_PLATE.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.TITANIUM_PLATE.get()), has(ModItems.TITANIUM_PLATE))
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .group("titanium")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TITANIUM_NUGGET.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_NUGGET.get()), has(ModItems.TITANIUM_NUGGET))
                .group("titanium")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.TITANIUM_PLATE.get())
                .pattern("TI")
                .pattern("IT")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .define('I', Items.IRON_NUGGET)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .group("titanium")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CONCRETE_TILES.get())
                .pattern("CC")
                .pattern("CC")
                .define('C', Items.WHITE_CONCRETE)
                .unlockedBy(getHasName(Items.WHITE_CONCRETE), has(Items.WHITE_CONCRETE))
                .group("concrete")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK))
                .group("titanium")
                .save(output, "titanium_ingot_from_nuggets");

        shapeless(RecipeCategory.MISC, ModItems.TITANIUM_NUGGET.get(), 9)
                .requires(ModItems.TITANIUM_INGOT)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT))
                .group("titanium")
                .save(output);




        List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.RAW_TITANIUM,ModBlocks.TITANIUM_ORE,ModBlocks.DEEPSLATE_TITANIUM_ORE);

        oreSmelting(TITANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 200,"titanium");
        oreBlasting(TITANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 100,"titanium");

    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, SCPAnomalousAlternatives.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }


}
