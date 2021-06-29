package com.teamacronymcoders.multiblockstages;

import net.minecraft.util.ResourceLocation;

public class MultiBlockStage {
    private final String gameStage;
    private final ResourceLocation multiBlockLocation;
    private final String failureMessage;

    public MultiBlockStage(String gameStage, ResourceLocation multiBlockLocation, String failureMessage) {
        this.gameStage = gameStage;
        this.multiBlockLocation = multiBlockLocation;
        this.failureMessage = failureMessage;
    }

    public String getGameStage() {
        return gameStage;
    }

    public ResourceLocation getMultiBlockLocation() {
        return multiBlockLocation;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
