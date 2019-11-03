package com.teamacronymcoders.multiblockstages.immersiveengineering;

import blusunrize.immersiveengineering.api.MultiblockHandler.IMultiblock;
import blusunrize.immersiveengineering.api.MultiblockHandler.MultiblockFormEvent;
import com.google.common.collect.Maps;
import com.teamacronymcoders.multiblockstages.MultiBlockStage;
import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;

public class IEMultiBlockHandler {
    private Map<String, MultiBlockStage> multiBlockStages;

    public IEMultiBlockHandler() {
        multiBlockStages = Maps.newHashMap();
    }

    public void addMultiBlockStage(MultiBlockStage multiBlockStage) {
        multiBlockStages.put(multiBlockStage.getMultiBlockName(),  multiBlockStage);
    }

    @SubscribeEvent
    public void multiBlockForm(MultiblockFormEvent.Post multiblockFormEvent) {
        IMultiblock multiblock = multiblockFormEvent.getMultiblock();
        EntityPlayer entityPlayer = multiblockFormEvent.getEntityPlayer();
        if (multiBlockStages.containsKey(multiblock.getUniqueName())) {
            MultiBlockStage stage = multiBlockStages.get(multiblock.getUniqueName());
            if (!GameStageHelper.hasStage(entityPlayer, stage.getGameStage())) {
                multiblockFormEvent.setCanceled(true);
                if (entityPlayer.getEntityWorld().isRemote) {
                    entityPlayer.sendStatusMessage(new TextComponentString(stage.getFailureMessage()), true);
                }
            }
        }
    }
}
