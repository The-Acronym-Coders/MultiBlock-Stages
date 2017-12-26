package com.teamacronymcoders.multiblockstages;

import com.google.common.base.Strings;
import crafttweaker.IAction;

import java.util.Objects;

public abstract class ActionAddMultiBlockStage implements IAction {
    private final String gameStage;
    private final String multiBlockName;
    private final String failureMessage;

    public ActionAddMultiBlockStage(String gameStage, String multiBlockName) {
        this(gameStage, multiBlockName, "You cannot form this MultiBlock! Further Progression is Required.");
    }

    public ActionAddMultiBlockStage(String gameStage, String multiBlockName, String failureMessage) {
        this.gameStage = gameStage;
        this.multiBlockName = multiBlockName;
        this.failureMessage = failureMessage;
    }

    @Override
    public void apply() {
        if (Strings.isNullOrEmpty(getGameStage())) {
            throw new IllegalArgumentException("Stage cannot be Empty");
        } else if (Strings.isNullOrEmpty(getMultiBlockName())) {
            throw new IllegalArgumentException("MultiBlock Name cannot be Empty");
        } else if (Strings.isNullOrEmpty(getFailureMessage())) {
            throw new IllegalArgumentException("Failure Message cannot be Empty");
        }

        addToHandler(new MultiBlockStage(getGameStage(), getMultiBlockName(), getFailureMessage()));
    }

    public abstract void addToHandler(MultiBlockStage multiBlockStage);

    @Override
    public String describe() {
        return "Added MultiBlock " + this.getMultiBlockName() + " to Stage " + getGameStage();
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
