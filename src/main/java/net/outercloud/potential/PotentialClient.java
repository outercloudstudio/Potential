package net.outercloud.potential;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.outercloud.potential.Blocks.Entities.WoodenHopperEntity;
import net.outercloud.potential.Blocks.Screens.Client.WoodenHopperScreen;
import net.outercloud.potential.Blocks.WoodenHopper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class PotentialClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Potential Client");

	@Override
	public void onInitializeClient() {
		HandledScreens.register(Potential.WOODEN_HOPPER_SCREEN_HANDLER, WoodenHopperScreen::new);
	}
}
