package com.teamacronymcoders.multiblockstages.immersiveengineering;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.util.ResourceLocation;
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
