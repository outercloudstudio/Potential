package net.outercloud.upgradeables.Hoppers.Stone;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreenHandler;
import net.outercloud.upgradeables.Upgradeables;

public class StoneHopperScreenHandler extends AbstractHopperScreenHandler {
    public static final ScreenHandlerType<?> screenHandlerType = Upgradeables.STONE_HOPPER_SCREEN_HANDLER;

    public StoneHopperScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(syncId, playerInventory, new SimpleInventory(2), Upgradeables.STONE_HOPPER_SCREEN_HANDLER);
    }

    public StoneHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(syncId, playerInventory, inventory, Upgradeables.STONE_HOPPER_SCREEN_HANDLER);
    }

    @Override
    public int getInventorySize() {
        return 2;
    }

    @Override
    public void addSlots() {
        addSlot(new Slot(inventory, 0, 80 - 18, 20));
        addSlot(new Slot(inventory, 1, 80, 20));
        addSlot(new Slot(inventory, 2, 80 + 18, 20));
    }
}
