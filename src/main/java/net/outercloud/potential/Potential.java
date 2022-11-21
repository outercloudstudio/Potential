package net.outercloud.potential;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.outercloud.potential.Blocks.Entities.WoodenHopperEntity;
import net.outercloud.potential.Blocks.WoodenHopper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Potential implements ModInitializer {
	public static final String ID = "potential";
	public static final Logger LOGGER = LoggerFactory.getLogger("Potential");

	public static final WoodenHopper WOODEN_HOPPER = new WoodenHopper(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static final BlockEntityType<WoodenHopperEntity> WOODEN_HOPPER_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier(ID, "wooden_hopper"),
			FabricBlockEntityTypeBuilder.create(WoodenHopperEntity::new, WOODEN_HOPPER).build()
	);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(ID, "wooden_hopper"), WOODEN_HOPPER);
		Registry.register(Registry.ITEM, new Identifier(ID, "wooden_hopper"), new BlockItem(WOODEN_HOPPER, new FabricItemSettings().group(ItemGroup.REDSTONE)));
	}
}
