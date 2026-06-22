package mariomastr.elementalsextended.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends Item {
    private static final int BREAK_RANGE = 3;

    public HammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {

    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity owner) {
        for (int x = 0; x < BREAK_RANGE; x++) {
            for (int y = 0; y < BREAK_RANGE; y++) {
                for (int z = 0; z < BREAK_RANGE; z++) {
                    level.destroyBlock(new BlockPos(
                            // shift all the values by +2 to center the break
                            pos.getX()+(BREAK_RANGE-(x+2)),
                            pos.getY()+(BREAK_RANGE-(y+2)),
                            pos.getZ()+(BREAK_RANGE-(z+2))),
                            true, owner);
                }
            }
        }

        return true;
    }
}
