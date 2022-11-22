package net.outercloud.upgradeables;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.outercloud.upgradeables.Hoppers.Common.CommonHopperScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class UpgradeablesClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Upgradeables Client");

	@Override
	public void onInitializeClient() {
		HandledScreens.register(Upgradeables.COMMON_HOPPER_SCREEN_HANDLER, CommonHopperScreen::new);
	}
}
