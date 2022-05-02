package com.teamacronymcoders.multiblockstages.immersiveengineering;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType.Method;
import org.openzen.zencode.java.ZenCodeType.Name;

@ZenRegister(modDeps = {"immersiveengineering"})
@Name("mods.multiblockstages.IEMultiBlockStages")
public class IEMultiBlockStages {
    @Method
    public static void addStage(String stage, ResourceLocation multiBlockName) {
        CraftTweakerAPI.apply(new ActionAddIEMultiBlockStage(stage, multiBlockName));
    }

    @Method
    public static void addStage(String stage, ResourceLocation multiBlockName, String failureMessage) {
        CraftTweakerAPI.apply(new ActionAddIEMultiBlockStage(stage, multiBlockName, failureMessage));
    }
}
