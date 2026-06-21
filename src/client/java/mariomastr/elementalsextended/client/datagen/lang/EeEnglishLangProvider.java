package mariomastr.elementalsextended.client.datagen.lang;

import mariomastr.elementalsextended.block.EeBlocks;
import mariomastr.elementalsextended.item.EeItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EeEnglishLangProvider extends FabricLanguageProvider {

    public EeEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup){
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(EeItems.TIDE_ROD, "Tide Rod");
        translationBuilder.add(EeItems.INFUSED_TIDE_ROD, "Infused Tide Rod");
        translationBuilder.add(EeItems.GROUND_NAUTILUS_SHELL, "Ground Nautilus Shell");

        translationBuilder.add(EeBlocks.POLISHED_PRISMARINE.asItem(), "Polished Prismarine");
        translationBuilder.add(EeBlocks.CHISELED_PRISMARINE.asItem(), "Chiseled Prismarine");
    }
}
