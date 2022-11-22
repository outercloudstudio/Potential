package net.outercloud.upgradeables;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.outercloud.upgradeables.Hoppers.Common.CommonHopperEntity;
import net.outercloud.upgradeables.Hoppers.Common.CommonHopperScreenHandler;
import net.outercloud.upgradeables.Hoppers.Wooden.WoodenHopper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Upgradeables implements ModInitializer {
	public static final String ID = "upgradeables";
	public static final Logger LOGGER = LoggerFactory.getLogger("Upgradeables");

	public static final WoodenHopper WOODEN_HOPPER = new WoodenHopper(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static final WoodenHopper STONE_HOPPER = new WoodenHopper(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	public static final BlockEntityType<CommonHopperEntity> COMMON_HOPPER_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier(ID, "common_hopper_entity"),
			FabricBlockEntityTypeBuilder.create(CommonHopperEntity::new, WOODEN_HOPPER, STONE_HOPPER).build()
	);

	public static final ScreenHandlerType<CommonHopperScreenHandler> COMMON_HOPPER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ID, "common_hopper_screen_handler"), CommonHopperScreenHandler::new);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(ID, "wooden_hopper"), WOODEN_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "wooden_hopper"), new BlockItem(WOODEN_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));
		Registry.register(Registry.BLOCK, new Identifier(ID, "stone_hopper"), STONE_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "stone_hopper"), new BlockItem(STONE_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));
	}
}
