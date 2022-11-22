package net.outercloud.upgradeables.Hoppers.Diamond;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreen;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreenHandler;

public class DiamondHopperScreen extends AbstractHopperScreen {
    public DiamondHopperScreen(AbstractHopperScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier("upgradeables:textures/gui/container/diamond_hopper.png");
    }
}
