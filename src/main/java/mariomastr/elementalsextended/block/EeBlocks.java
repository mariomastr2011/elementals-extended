package mariomastr.elementalsextended.block;

import mariomastr.elementalsextended.ElementalsExtended;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class EeBlocks {

    public static final Block POLISHED_PRISMARINE = register(
            "polished_prismarine",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.STONE)
    );

    public static final Block CHISELED_PRISMARINE = register(
            "chiseled_prismarine",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.STONE)
    );

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        ResourceKey<Item> itemKey = keyOfItem(name);

        Block block = blockFactory.apply(settings.setId(blockKey));

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ElementalsExtended.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ElementalsExtended.MOD_ID, name));
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((creativeTab) -> {
                    creativeTab.accept(EeBlocks.POLISHED_PRISMARINE.asItem());
                    creativeTab.accept(EeBlocks.CHISELED_PRISMARINE.asItem());
            });
    }
}
