package com.teamacronymcoders.multiblockstages.immersiveengineering;

import com.teamacronymcoders.multiblockstages.MultiBlockStage;
import net.minecraftforge.common.MinecraftForge;

public class IEMultiBlockSupport {
    private static IEMultiBlockHandler multiBlockHandler;

    public static void setup() {
        multiBlockHandler = new IEMultiBlockHandler();
        MinecraftForge.EVENT_BUS.register(multiBlockHandler);
    }

    public static void addMultiBlockStage(MultiBlockStage multiBlockStage) {
        multiBlockHandler.addMultiBlockStage(multiBlockStage);
    }
}
