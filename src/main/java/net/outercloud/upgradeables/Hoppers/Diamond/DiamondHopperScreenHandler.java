package net.outercloud.upgradeables.Hoppers.Diamond;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreenHandler;
import net.outercloud.upgradeables.Upgradeables;

public class DiamondHopperScreenHandler extends AbstractHopperScreenHandler {
    public static final ScreenHandlerType<?> screenHandlerType = Upgradeables.DIAMOND_HOPPER_SCREEN_HANDLER;

    public DiamondHopperScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(syncId, playerInventory, new SimpleInventory(8), Upgradeables.DIAMOND_HOPPER_SCREEN_HANDLER);
    }

    public DiamondHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(syncId, playerInventory, inventory, Upgradeables.DIAMOND_HOPPER_SCREEN_HANDLER);
    }

    @Override
    public int getInventorySize() {
        return 8;
    }

    @Override
    public void addSlots() {
        addSlot(new Slot(inventory, 0, 80 - 63, 20));
        addSlot(new Slot(inventory, 1, 80 - 45, 20));
        addSlot(new Slot(inventory, 2, 80 - 27, 20));
        addSlot(new Slot(inventory, 3, 80 - 9, 20));
        addSlot(new Slot(inventory, 4, 80 + 9, 20));
        addSlot(new Slot(inventory, 5, 80 + 27, 20));
        addSlot(new Slot(inventory, 6, 80 + 45, 20));
        addSlot(new Slot(inventory, 7, 80 + 63, 20));
    }
}
