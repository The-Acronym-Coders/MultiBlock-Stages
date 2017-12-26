package com.teamacronymcoders.multiblockstages.immersiveengineering;

import blusunrize.immersiveengineering.api.MultiblockHandler;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("immersiveengineering")
@ZenClass("mods.multiblockstages.IEMultiBlockStages")
public class IEMultiBlockStages {
    @ZenMethod
    public static void addStage(String stage, String multiBlockName) {
        CraftTweakerAPI.apply(new ActionAddIEMultiBlockStage(stage, multiBlockName));
    }

    @ZenMethod
    public static void addStage(String stage, String multiBlockName, String failureMessage) {
        CraftTweakerAPI.apply(new ActionAddIEMultiBlockStage(stage, multiBlockName, failureMessage));
    }
}
