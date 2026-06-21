package mariomastr.elementalsextended.client.datagen;

import mariomastr.elementalsextended.client.datagen.lang.EeEnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ElementalsExtendedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EeEnglishLangProvider::new);
		pack.addProvider(EeModelProvider::new);
		pack.addProvider(EeRecipeProvider::new);
	}
}
