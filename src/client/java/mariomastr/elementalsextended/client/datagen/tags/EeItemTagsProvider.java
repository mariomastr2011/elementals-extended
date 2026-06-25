package mariomastr.elementalsextended.client.datagen.tags;

import mariomastr.elementalsextended.ElementalsExtended;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class EeItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public EeItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        this.builder(ItemTags.PICKAXES)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ElementalsExtended.MOD_ID, "hammer")));
    }
}
