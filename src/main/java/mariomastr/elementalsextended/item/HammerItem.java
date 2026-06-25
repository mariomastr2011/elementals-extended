package mariomastr.elementalsextended.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

import java.util.Arrays;
import java.util.List;

public class HammerItem extends Item {
    private static final int BREAK_RANGE = 3;
    private static final Block[] UNBREAKABLE_BLOCKS = new Block[] {
            Blocks.AIR,
            Blocks.BARRIER,
            Blocks.BEDROCK,
            Blocks.CAVE_AIR,
            Blocks.COMMAND_BLOCK,
            Blocks.CHAIN_COMMAND_BLOCK,
            Blocks.END_GATEWAY,
            Blocks.END_PORTAL,
            Blocks.END_PORTAL_FRAME,
            Blocks.DRAGON_EGG,
            Blocks.JIGSAW,
            Blocks.LIGHT,
            Blocks.MOVING_PISTON,
            Blocks.NETHER_PORTAL,
            Blocks.REPEATING_COMMAND_BLOCK,
            Blocks.STRUCTURE_BLOCK,
            Blocks.END_PORTAL_FRAME,
            Blocks.VOID_AIR,
    };

    public HammerItem(ToolMaterial material, int attackDamage, float attackSpeed, Properties properties) {
        super(properties.pickaxe(material, attackDamage, attackSpeed));
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 6.0f, 1, true);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 10.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.7f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();

    }

    @Override
    public boolean mineBlock(@NonNull ItemStack itemStack, @NonNull Level level, @NonNull BlockState state, @NonNull BlockPos pos, @NonNull LivingEntity owner) {
        // mine the original block
        boolean returnState = super.mineBlock(itemStack, level, state, pos, owner);

        // don't break multiple blocks if the user is not a player or if the player is sneaking
        if (!(owner instanceof Player player)) return returnState;
        if (player.isShiftKeyDown()) return returnState;

        int blocksBroken = 0;
        for (int x = 0; x < BREAK_RANGE; x++) {
            for (int y = 0; y < BREAK_RANGE; y++) {
                for (int z = 0; z < BREAK_RANGE; z++) {
                    BlockPos posToBreak = new BlockPos(
                            // shift all the values by +2 to center the break
                            pos.getX() + (BREAK_RANGE - (x + 2)),
                            pos.getY() + (BREAK_RANGE - (y + 2)),
                            pos.getZ() + (BREAK_RANGE - (z + 2)));

                    // only destroy the block if it is normally breakable by the player
                    Block blockToBreak = level.getBlockState(posToBreak).getBlock();

                    if (!Arrays.asList(UNBREAKABLE_BLOCKS).contains(blockToBreak)) {
                        level.destroyBlock(posToBreak, true, owner);

                        // only increase the damage the hammer will take if the block does not instant mine
                        if (blockToBreak.defaultBlockState().getDestroySpeed(level, posToBreak) != 0.0f) blocksBroken++;
                    }
                }
            }
        }

        itemStack.hurtAndBreak(blocksBroken, owner, EquipmentSlot.MAINHAND);

        return returnState;
    }
}
