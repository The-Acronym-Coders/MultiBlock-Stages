package com.teamacronymcoders.multiblockstages.immersiveengineering;

import blusunrize.immersiveengineering.api.MultiblockHandler;
import blusunrize.immersiveengineering.api.MultiblockHandler.IMultiblock;
import com.teamacronymcoders.multiblockstages.MultiBlockCommand;
import com.teamacronymcoders.multiblockstages.MultiBlockStage;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.mc1120.commands.CTChatCommand;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;
import java.util.stream.Collectors;

public class IEMultiBlockSupport {
    private static IEMultiBlockHandler multiBlockHandler;

    public static void setup() {
        multiBlockHandler = new IEMultiBlockHandler();
        MinecraftForge.EVENT_BUS.register(multiBlockHandler);

        CTChatCommand.registerCommand(new MultiBlockCommand("ie") {
            @Override
            public List<String> getMultiBlockNames() {
                return MultiblockHandler.getMultiblocks().stream()
                        .map(IMultiblock::getUniqueName)
                        .collect(Collectors.toList());
            }
        });
    }

    public static void addMultiBlockStage(MultiBlockStage multiBlockStage) {
        multiBlockHandler.addMultiBlockStage(multiBlockStage);
    }
}
