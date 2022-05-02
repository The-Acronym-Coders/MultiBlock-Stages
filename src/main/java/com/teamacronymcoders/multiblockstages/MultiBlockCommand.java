package com.teamacronymcoders.multiblockstages;

import blusunrize.immersiveengineering.api.multiblocks.MultiblockHandler;
import blusunrize.immersiveengineering.api.multiblocks.MultiblockHandler.IMultiblock;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.plugin.CraftTweakerPlugin;
import com.blamejared.crafttweaker.api.plugin.ICommandRegistrationHandler;
import com.blamejared.crafttweaker.api.plugin.ICraftTweakerPlugin;
import com.mojang.brigadier.Command;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.stream.Collectors;

@CraftTweakerPlugin("multiblockstages:commands")
public class MultiBlockCommand implements ICraftTweakerPlugin {

	@Override
	public void registerCommands(ICommandRegistrationHandler handler) {
		handler.registerDump("ieMultiblocks", new TextComponent("Outputs a list of all Immersive Engineering multiblock names to the log."), builder -> {
			builder.executes(context -> {
				CraftTweakerAPI.LOGGER.info("ieMultiblocks" + ":");
				List<ResourceLocation> multiBlockList = getMultiBlockNames();
				for (ResourceLocation name : multiBlockList) {
					CraftTweakerAPI.LOGGER.info(name.toString());
				}
				final TextComponent message = new TextComponent(ChatFormatting.GREEN + "IE Multiblock list generated! Check the crafttweaker.log file!" + ChatFormatting.RESET);
				context.getSource().sendSuccess(message, false);

				return Command.SINGLE_SUCCESS;
			});
		});
	}

    public static List<ResourceLocation> getMultiBlockNames() {
		return MultiblockHandler.getMultiblocks().stream()
				.map(IMultiblock::getUniqueName)
				.collect(Collectors.toList());
	};
}
