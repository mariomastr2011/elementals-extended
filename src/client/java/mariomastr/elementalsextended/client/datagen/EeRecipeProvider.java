package mariomastr.elementalsextended.client.datagen;

import mariomastr.elementalsextended.item.EeItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class EeRecipeProvider extends FabricRecipeProvider {
    public EeRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderLookup<Item> itemHolderLookup = registries.lookupOrThrow(Registries.ITEM);

                // define the ground nautilus shell recipe, two per one nautilus shell
                shapeless(RecipeCategory.MISC, EeItems.GROUND_NAUTILUS_SHELL, 2)
                        .requires(Items.NAUTILUS_SHELL)
                        .unlockedBy(getHasName(Items.NAUTILUS_SHELL), has(Items.NAUTILUS_SHELL))
                        .save(output);

                shaped(RecipeCategory.MISC, EeItems.INFUSED_TIDE_ROD)
                        .pattern(" G ")
                        .pattern("GRG")
                        .pattern(" G ")
                        .define('G', EeItems.GROUND_NAUTILUS_SHELL)
                        .define('R', EeItems.TIDE_ROD)
                        .unlockedBy(getHasName(EeItems.GROUND_NAUTILUS_SHELL), has(EeItems.GROUND_NAUTILUS_SHELL))
                        .unlockedBy(getHasName(EeItems.TIDE_ROD), has(EeItems.TIDE_ROD))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
