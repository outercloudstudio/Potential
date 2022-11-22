package net.outercloud.upgradeables.Hoppers.Gold;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreen;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreenHandler;

public class GoldHopperScreen extends AbstractHopperScreen {
    public GoldHopperScreen(AbstractHopperScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public Identifier getTexture() {
        return new Identifier("upgradeables:textures/gui/container/gold_hopper.png");
    }
}
