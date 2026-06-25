package mariomastr.elementalsextended.item;

import mariomastr.elementalsextended.ElementalsExtended;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Weapon;

import java.util.function.Function;

public class EeItems {
    public static final Item TIDE_ROD = register("tide_rod", Item::new, new Item.Properties());
    public static final Item INFUSED_TIDE_ROD = register("infused_tide_rod", Item::new, new Item.Properties());
    public static final Item GROUND_NAUTILUS_SHELL = register("ground_nautilus_shell", Item::new, new Item.Properties());
    public static final Item HAMMER = register(
            "hammer",
            hammer -> new HammerItem(EeToolMaterials.HAMMER_TOOL_MATERIAL, 10, -3.7f, hammer),
            new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.TOOL, HammerItem.createToolProperties())
                    .attributes(HammerItem.createAttributes())
                    .component(DataComponents.WEAPON, new Weapon(1))
    );

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(ElementalsExtended.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize(){
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> {
                        creativeTab.accept(EeItems.TIDE_ROD);
                        creativeTab.accept(EeItems.INFUSED_TIDE_ROD);
                        creativeTab.accept(EeItems.GROUND_NAUTILUS_SHELL);
                });

         CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                 .register((creativeTab) -> {
                     creativeTab.accept(EeItems.HAMMER);
                 });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> {
                    creativeTab.accept(EeItems.HAMMER);
                });
    }
}
