package mariomastr.elementalsextended.item;

import net.minecraft.world.item.ToolMaterial;


public class EeToolMaterials {
    public static final ToolMaterial HAMMER_TOOL_MATERIAL = new ToolMaterial(
            ToolMaterial.IRON.incorrectBlocksForDrops(),
            750,
            2,
            1.5f,
            15,
            // replace this with custom items once they are added
            ToolMaterial.IRON.repairItems()
    );
}
