package net.rotgruengelb.create_railway_additions.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rotgruengelb.create_railway_additions.CreateRailwayAdditions;
import net.rotgruengelb.create_railway_additions.block.custom.SpeakerBlock;

public class ModBlocks {
    public static final Block TEST_BLOCK = registerBlock("test_block",
        new Block(FabricBlockSettings.of(Material.METAL).strength(0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block SPEAKER = registerBlock("speaker",
            new SpeakerBlock(FabricBlockSettings.of(Material.WOOD).strength(3f).requiresTool()), ItemGroup.REDSTONE);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(CreateRailwayAdditions.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(CreateRailwayAdditions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        CreateRailwayAdditions.LOGGER.debug("Registering Mod blocks for 'Create Railway Additions'");
    }
}