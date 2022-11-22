package net.outercloud.upgradeables.Hoppers.Common;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.outercloud.upgradeables.Upgradeables;

public class CommonHopperScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    private PropertyDelegate screenPropertyDelegate;

    public CommonHopperEntity.HopperType hopperType = CommonHopperEntity.HopperType.WOODEN;

    public CommonHopperScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(1), new ArrayPropertyDelegate(1), true);
    }

    public CommonHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate screenPropertyDelegate, boolean isClient) {
        super(Upgradeables.COMMON_HOPPER_SCREEN_HANDLER, syncId);

        this.screenPropertyDelegate = screenPropertyDelegate;

        checkDataCount(screenPropertyDelegate, 1);

        Upgradeables.LOGGER.info("Handler Property on open" + screenPropertyDelegate.get(0) + " " + isClient);

        this.inventory = inventory;

//        checkSize(inventory, 1);

        Upgradeables.LOGGER.info("Inventory Size " + inventory.size());

        inventory.onOpen(playerInventory.player);

        switch (inventory.size()){
            case 3 -> {
                this.addSlot(new Slot(inventory, 0, 80 - 18, 20));
                this.addSlot(new Slot(inventory, 1, 80, 20));
                this.addSlot(new Slot(inventory, 2, 80 + 18, 20));
            }
            default -> {
                this.addSlot(new Slot(inventory, 0, 80, 20));
            }
        }

//        if(!isClient) addSlots();

        int j;

        for(j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, j * 18 + 51));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 109));
        }

        this.addProperties(screenPropertyDelegate);
    }

    public void addSlots(){
        Upgradeables.LOGGER.info("Updated slots!");

        switch (hopperType){
            case STONE -> {
                this.addSlot(new Slot(inventory, 0, 80 - 18, 20));
                this.addSlot(new Slot(inventory, 1, 80, 20));
                this.addSlot(new Slot(inventory, 2, 80 + 18, 20));
            }
            default -> {
                this.addSlot(new Slot(inventory, 0, 80, 20));
            }
        }
    }

    @Override
    public void setProperty(int id, int value) {
        super.setProperty(id, value);

        Upgradeables.LOGGER.info("Updated propety!");

        hopperType = CommonHopperEntity.HopperType.values()[screenPropertyDelegate.get(0)];

//        addSlots();
    }

    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public ItemStack transferSlot(PlayerEntity player, int index) {
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
        Upgradeables.LOGGER.info("Handler Property on close" + screenPropertyDelegate.get(0));

        super.close(player);
        this.inventory.onClose(player);
    }
}
