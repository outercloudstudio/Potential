package net.outercloud.upgradeables.Hoppers.Gold;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.outercloud.upgradeables.Hoppers.AbstractHopperEntity;
import net.outercloud.upgradeables.Upgradeables;

public class GoldHopperEntity extends AbstractHopperEntity {

    public GoldHopperEntity(BlockPos pos, BlockState state) {
        super(pos, state, Upgradeables.GOLD_HOPPER_ENTITY);
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
        return Text.translatable("block.upgradeables.gold_hopper");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GoldHopperScreenHandler(syncId, playerInventory, this);
    }
}
