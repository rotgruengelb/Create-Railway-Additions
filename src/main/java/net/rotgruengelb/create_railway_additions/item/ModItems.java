package net.rotgruengelb.create_railway_additions.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rotgruengelb.create_railway_additions.CreateRailwayAdditions;

public class ModItems {

    public static final Item TEST = registerItem("test",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CreateRailwayAdditions.MOD_ID, name), item);
    }
    public static void registerModItems() {
        CreateRailwayAdditions.LOGGER.debug("Registering Mod items for 'Create Railway Additions'");
    }
}
