package net.outercloud.upgradeables.Hoppers.Stone;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreen;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreenHandler;

public class StoneHopperScreen extends AbstractHopperScreen {
    public StoneHopperScreen(AbstractHopperScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier("upgradeables:textures/gui/container/stone_hopper.png");
    }
}
