package net.outercloud.upgradeables.Hoppers.Stone;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.outercloud.upgradeables.Hoppers.AbstractHopperEntity;
import net.outercloud.upgradeables.Upgradeables;

public class StoneHopperEntity extends AbstractHopperEntity {

    public StoneHopperEntity(BlockPos pos, BlockState state) {
        super(pos, state, Upgradeables.STONE_HOPPER_ENTITY);
    }

    @Override
    public int getInventorySize() {
        return 3;
    }

    @Override
    public int getCooldown() {
        return 32;
    }

    @Override
    public Text getContainerName() {
        return Text.translatable("block.upgradeables.stone_hopper");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new StoneHopperScreenHandler(syncId, playerInventory, this);
    }
}
