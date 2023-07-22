package net.rotgruengelb.create_railway_additions;

import net.fabricmc.api.ModInitializer;

import net.rotgruengelb.create_railway_additions.block.ModBlocks;
import net.rotgruengelb.create_railway_additions.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateRailwayAdditions implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "create_railway_additions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}