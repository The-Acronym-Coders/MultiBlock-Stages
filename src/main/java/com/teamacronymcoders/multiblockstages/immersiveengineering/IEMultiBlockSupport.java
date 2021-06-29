package com.teamacronymcoders.multiblockstages.immersiveengineering;

import com.teamacronymcoders.multiblockstages.MultiBlockCommand;
import com.teamacronymcoders.multiblockstages.MultiBlockStage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;

public class IEMultiBlockSupport {
    private static IEMultiBlockHandler multiBlockHandler;

    public static void setup() {
        multiBlockHandler = new IEMultiBlockHandler();
        MinecraftForge.EVENT_BUS.register(multiBlockHandler);
        if(ModList.get().isLoaded("crafttweaker")) {
            MinecraftForge.EVENT_BUS.addListener(MultiBlockCommand::addDumpCommands);
        }
    }

    public static void addMultiBlockStage(MultiBlockStage multiBlockStage) {
        multiBlockHandler.addMultiBlockStage(multiBlockStage);
    }
}
