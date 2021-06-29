package com.teamacronymcoders.multiblockstages;

import blusunrize.immersiveengineering.api.multiblocks.MultiblockHandler;
import blusunrize.immersiveengineering.api.multiblocks.MultiblockHandler.IMultiblock;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.impl.commands.CTCommandCollectionEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.stream.Collectors;

public class MultiBlockCommand {
	@SubscribeEvent
	public static void addDumpCommands(CTCommandCollectionEvent event) {
		event.registerDump("ieMultiblocks", "Outputs a list of all Immersive Engineering multiblock names to the log.", context -> {
			CraftTweakerAPI.logDump("ieMultiblocks" + ":");
			List<ResourceLocation> multiBlockList = getMultiBlockNames();
			for (ResourceLocation name : multiBlockList) {
				CraftTweakerAPI.logDump(name.toString());
			}
			final StringTextComponent message = new StringTextComponent(TextFormatting.GREEN + "IE Multiblock list generated! Check the crafttweaker.log file!" + TextFormatting.RESET);
			context.getSource().sendFeedback(message, false);

			return 0;
		});
	}

    public static List<ResourceLocation> getMultiBlockNames() {
		return MultiblockHandler.getMultiblocks().stream()
				.map(IMultiblock::getUniqueName)
				.collect(Collectors.toList());
	};
}
