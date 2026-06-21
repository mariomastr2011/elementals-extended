package mariomastr.elementalsextended.client.datagen;

import mariomastr.elementalsextended.block.EeBlocks;
import mariomastr.elementalsextended.item.EeItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class EeModelProvider extends FabricModelProvider {
    public EeModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(EeBlocks.POLISHED_PRISMARINE);
        blockModelGenerators.createTrivialCube(EeBlocks.CHISELED_PRISMARINE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(EeItems.TIDE_ROD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(EeItems.INFUSED_TIDE_ROD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(EeItems.GROUND_NAUTILUS_SHELL, ModelTemplates.FLAT_ITEM);
    }
}
