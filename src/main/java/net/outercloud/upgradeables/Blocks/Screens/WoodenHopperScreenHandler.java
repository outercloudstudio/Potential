package net.outercloud.upgradeables.Blocks.Screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.outercloud.upgradeables.Upgradeables;

public class WoodenHopperScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public WoodenHopperScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(1));
    }

    public WoodenHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Upgradeables.WOODEN_HOPPER_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        checkSize(inventory, 1);
        inventory.onOpen(playerInventory.player);

        Upgradeables.LOGGER.info("Opened Screen");

        int j;
        for(j = 0; j < 1; ++j) {
            this.addSlot(new Slot(inventory, j, 80, 20));
        }

        for(j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, j * 18 + 51));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 109));
        }
    }

    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public ItemStack transferSlot(PlayerEntity player, int index) {
        Upgradeables.LOGGER.info("Transferring slot");

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (index < this.inventory.size()) {
                if (!this.insertItem(itemStack2, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return itemStack;
    }

    public void close(PlayerEntity player) {
        Upgradeables.LOGGER.info("Closed");

        super.close(player);
        this.inventory.onClose(player);
    }
}
