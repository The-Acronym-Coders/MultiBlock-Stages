package com.teamacronymcoders.multiblockstages;

public class MultiBlockStage {
    private final String gameStage;
    private final String multiBlockName;
    private final String failureMessage;

    public MultiBlockStage(String gameStage, String multiBlockName, String failureMessage) {
        this.gameStage = gameStage;
        this.multiBlockName = multiBlockName;
        this.failureMessage = failureMessage;
    }

    public String getGameStage() {
        return gameStage;
    }

    public String getMultiBlockName() {
        return multiBlockName;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
