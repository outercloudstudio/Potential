package net.outercloud.upgradeables;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.outercloud.upgradeables.Hoppers.AbstractHopperEntity;
import net.outercloud.upgradeables.Hoppers.AbstractHopperScreenHandler;
import net.outercloud.upgradeables.Hoppers.Diamond.DiamondHopper;
import net.outercloud.upgradeables.Hoppers.Diamond.DiamondHopperEntity;
import net.outercloud.upgradeables.Hoppers.Diamond.DiamondHopperScreenHandler;
import net.outercloud.upgradeables.Hoppers.Gold.GoldHopper;
import net.outercloud.upgradeables.Hoppers.Gold.GoldHopperEntity;
import net.outercloud.upgradeables.Hoppers.Gold.GoldHopperScreenHandler;
import net.outercloud.upgradeables.Hoppers.Stone.StoneHopper;
import net.outercloud.upgradeables.Hoppers.Stone.StoneHopperEntity;
import net.outercloud.upgradeables.Hoppers.Stone.StoneHopperScreenHandler;
import net.outercloud.upgradeables.Hoppers.Wooden.WoodenHopper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Upgradeables implements ModInitializer {
	public static final String ID = "upgradeables";
	public static final Logger LOGGER = LoggerFactory.getLogger("Upgradeables");

	public static final WoodenHopper WOODEN_HOPPER = new WoodenHopper(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
	public static final BlockEntityType<AbstractHopperEntity> WOODEN_HOPPER_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier(ID, "wooden_hopper"),
			FabricBlockEntityTypeBuilder.create(AbstractHopperEntity::new, WOODEN_HOPPER).build()
	);
	public static final ScreenHandlerType<AbstractHopperScreenHandler> WOODEN_HOPPER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ID, "wooden_hopper"), AbstractHopperScreenHandler::new);

	public static final StoneHopper STONE_HOPPER = new StoneHopper(FabricBlockSettings.of(Material.STONE).requiresTool().strength(2.0F, 6.0F));
	public static final BlockEntityType<StoneHopperEntity> STONE_HOPPER_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier(ID, "stone_hopper"),
			FabricBlockEntityTypeBuilder.create(StoneHopperEntity::new, STONE_HOPPER).build()
	);
	public static final ScreenHandlerType<StoneHopperScreenHandler> STONE_HOPPER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ID, "stone_hopper"), StoneHopperScreenHandler::new);

	public static final GoldHopper GOLD_HOPPER = new GoldHopper(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final BlockEntityType<GoldHopperEntity> GOLD_HOPPER_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier(ID, "gold_hopper"),
			FabricBlockEntityTypeBuilder.create(GoldHopperEntity::new, GOLD_HOPPER).build()
	);
	public static final ScreenHandlerType<GoldHopperScreenHandler> GOLD_HOPPER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ID, "gold_hopper"), GoldHopperScreenHandler::new);

	public static final DiamondHopper DIAMOND_HOPPER = new DiamondHopper(FabricBlockSettings.of(Material.METAL, MapColor.DIAMOND_BLUE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final BlockEntityType<DiamondHopperEntity> DIAMOND_HOPPER_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier(ID, "diamond_hopper"),
			FabricBlockEntityTypeBuilder.create(DiamondHopperEntity::new, DIAMOND_HOPPER).build()
	);
	public static final ScreenHandlerType<DiamondHopperScreenHandler> DIAMOND_HOPPER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ID, "diamond_hopper"), DiamondHopperScreenHandler::new);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(ID, "wooden_hopper"), WOODEN_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "wooden_hopper"), new BlockItem(WOODEN_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));

		Registry.register(Registry.BLOCK, new Identifier(ID, "stone_hopper"), STONE_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "stone_hopper"), new BlockItem(STONE_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));

		Registry.register(Registry.BLOCK, new Identifier(ID, "gold_hopper"), GOLD_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "gold_hopper"), new BlockItem(GOLD_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));

		Registry.register(Registry.BLOCK, new Identifier(ID, "diamond_hopper"), DIAMOND_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "diamond_hopper"), new BlockItem(DIAMOND_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));
	}
}
