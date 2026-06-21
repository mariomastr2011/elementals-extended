package mariomastr.elementalsextended;

import mariomastr.elementalsextended.block.EeBlocks;
import mariomastr.elementalsextended.item.EeItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementalsExtended implements ModInitializer {
	public static final String MOD_ID = "elementals-extended";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing items...");
		EeItems.initialize();

		LOGGER.info("Initializing blocks...");
		EeBlocks.initialize();
	}


}