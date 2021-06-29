package com.teamacronymcoders.multiblockstages;

import com.blamejared.crafttweaker.api.actions.IRuntimeAction;
import com.google.common.base.Strings;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.LogicalSide;

public abstract class ActionAddMultiBlockStage implements IRuntimeAction {
    private final String gameStage;
    private final ResourceLocation multiBlockLocation;
    private final String failureMessage;

    public ActionAddMultiBlockStage(String gameStage, ResourceLocation multiBlockLocation) {
        this(gameStage, multiBlockLocation, "You cannot form this MultiBlock! Further Progression is Required.");
    }

    public ActionAddMultiBlockStage(String gameStage, ResourceLocation multiBlockLocation, String failureMessage) {
        this.gameStage = gameStage;
        this.multiBlockLocation = multiBlockLocation;
        this.failureMessage = failureMessage;
    }

    /**
     * Decides which side the action should be applied on. Returning true makes sure the client and server both know.
     */
    @Override
    public boolean shouldApplyOn(LogicalSide side) {
        return true;
    }

    @Override
    public void apply() {
        if (Strings.isNullOrEmpty(getGameStage())) {
            throw new IllegalArgumentException("Stage cannot be Empty");
        } else if (Strings.isNullOrEmpty(getMultiBlockLocation().toString())) {
            throw new IllegalArgumentException("MultiBlock Location cannot be Empty");
        } else if (Strings.isNullOrEmpty(getFailureMessage())) {
            throw new IllegalArgumentException("Failure Message cannot be Empty");
        }

        addToHandler(new MultiBlockStage(getGameStage(), getMultiBlockLocation(), getFailureMessage()));
    }

    public abstract void addToHandler(MultiBlockStage multiBlockStage);

    @Override
    public String describe() {
        return "Added MultiBlock " + this.getMultiBlockLocation() + " to Stage " + getGameStage();
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
