package com.teamacronymcoders.multiblockstages.immersiveengineering;

import com.teamacronymcoders.multiblockstages.ActionAddMultiBlockStage;
import com.teamacronymcoders.multiblockstages.MultiBlockStage;

public class ActionAddIEMultiBlockStage extends ActionAddMultiBlockStage {
    public ActionAddIEMultiBlockStage(String stage, String multiBlockName) {
        super(stage, multiBlockName);
    }

    public ActionAddIEMultiBlockStage(String stage, String multiBlockName, String failureMessage) {
        super(stage, multiBlockName, failureMessage);
    }

    @Override
    public void addToHandler(MultiBlockStage multiBlockStage) {
        IEMultiBlockSupport.addMultiBlockStage(multiBlockStage);
    }
}
