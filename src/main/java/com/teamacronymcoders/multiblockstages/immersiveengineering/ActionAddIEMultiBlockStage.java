package com.teamacronymcoders.multiblockstages.immersiveengineering;

import com.teamacronymcoders.multiblockstages.ActionAddMultiBlockStage;
import com.teamacronymcoders.multiblockstages.MultiBlockStage;
import net.minecraft.util.ResourceLocation;

public class ActionAddIEMultiBlockStage extends ActionAddMultiBlockStage {
    public ActionAddIEMultiBlockStage(String stage, ResourceLocation multiBlockName) {
        super(stage, multiBlockName);
    }

    public ActionAddIEMultiBlockStage(String stage, ResourceLocation multiBlockName, String failureMessage) {
        super(stage, multiBlockName, failureMessage);
    }

    @Override
    public void addToHandler(MultiBlockStage multiBlockStage) {
        IEMultiBlockSupport.addMultiBlockStage(multiBlockStage);
    }
}
