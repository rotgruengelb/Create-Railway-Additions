package net.rotgruengelb.create_railway_additions.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rotgruengelb.create_railway_additions.CreateRailwayAdditions;
import net.rotgruengelb.create_railway_additions.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<SpeakerBlockEntity> SPEAKER;

    public static void registerBlockEntities() {
        SPEAKER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CreateRailwayAdditions.MOD_ID, "speaker"),
                FabricBlockEntityTypeBuilder.create(SpeakerBlockEntity::new,
                        ModBlocks.SPEAKER).build(null));
    }

}
