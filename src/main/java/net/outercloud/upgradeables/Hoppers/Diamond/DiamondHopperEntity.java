package net.outercloud.upgradeables.Hoppers.Diamond;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.outercloud.upgradeables.Hoppers.AbstractHopperEntity;
import net.outercloud.upgradeables.Upgradeables;

public class DiamondHopperEntity extends AbstractHopperEntity {

    public DiamondHopperEntity(BlockPos pos, BlockState state) {
        super(pos, state, Upgradeables.DIAMOND_HOPPER_ENTITY);
    }

    @Override
    public int getInventorySize() {
        return 8;
    }

    @Override
    public int getCooldown() {
        return 1;
    }

    @Override
    public Text getContainerName() {
        return Text.translatable("block.upgradeables.diamond_hopper");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new DiamondHopperScreenHandler(syncId, playerInventory, this);
    }
}
