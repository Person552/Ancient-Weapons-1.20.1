package me.dinoson850.ancientweapons.datagen;

import me.dinoson850.ancientweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BONE_CLUB, 1)
                .pattern(" BB")
                .pattern("MBB")
                .pattern("SM ")
                .input('S', Items.STICK)
                .input('M', Items.MOSS_BLOCK)
                .input('B', ModItems.ANCIENT_BONE)
                .criterion(hasItem(ModItems.ANCIENT_BONE), conditionsFromItem(ModItems.ANCIENT_BONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BONE_CLEAVER, 1)
                .pattern(" FB")
                .pattern(" BT")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('T', Items.TORCHFLOWER_SEEDS)
                .input('F', ModItems.ANCIENT_FANG)
                .input('B', ModItems.ANCIENT_BONE)
                .criterion(hasItem(ModItems.ANCIENT_BONE), conditionsFromItem(ModItems.ANCIENT_BONE))
                .criterion(hasItem(ModItems.ANCIENT_FANG), conditionsFromItem(ModItems.ANCIENT_FANG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BONE_FALX, 1)
                .pattern(" FB")
                .pattern(" BP")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('P', Items.PITCHER_POD)
                .input('F', ModItems.ANCIENT_FANG)
                .input('B', ModItems.ANCIENT_BONE)
                .criterion(hasItem(ModItems.ANCIENT_BONE), conditionsFromItem(ModItems.ANCIENT_BONE))
                .offerTo(exporter);
    }
}
