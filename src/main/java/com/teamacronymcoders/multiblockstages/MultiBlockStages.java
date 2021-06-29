package com.teamacronymcoders.multiblockstages;

import com.teamacronymcoders.multiblockstages.immersiveengineering.IEMultiBlockSupport;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import static com.teamacronymcoders.multiblockstages.MultiBlockStages.MOD_ID;

@Mod(MOD_ID)
public class MultiBlockStages {
    public static final String MOD_ID = "multiblockstages";
    public static final String MOD_NAME = "MultiBlock Stages";

    public MultiBlockStages() {
        if (ModList.get().isLoaded("immersiveengineering")) {
            IEMultiBlockSupport.setup();
        }
    }
}
