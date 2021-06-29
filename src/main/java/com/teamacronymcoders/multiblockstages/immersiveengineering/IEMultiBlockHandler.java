package com.teamacronymcoders.multiblockstages.immersiveengineering;

import blusunrize.immersiveengineering.api.multiblocks.MultiblockHandler.IMultiblock;
import blusunrize.immersiveengineering.api.multiblocks.MultiblockHandler.MultiblockFormEvent;
import com.google.common.collect.Maps;
import com.teamacronymcoders.multiblockstages.MultiBlockStage;
import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;

public class IEMultiBlockHandler {
    private Map<ResourceLocation, MultiBlockStage> multiBlockStages;

    public IEMultiBlockHandler() {
        multiBlockStages = Maps.newHashMap();
    }

    public void addMultiBlockStage(MultiBlockStage multiBlockStage) {
        multiBlockStages.put(multiBlockStage.getMultiBlockLocation(),  multiBlockStage);
    }

    @SubscribeEvent
    public void multiBlockForm(MultiblockFormEvent multiblockFormEvent) {
        IMultiblock multiblock = multiblockFormEvent.getMultiblock();
        PlayerEntity entityPlayer = multiblockFormEvent.getPlayer();
        MultiBlockStage stage = multiBlockStages.get(multiblock.getUniqueName());
        if (multiBlockStages.containsKey(multiblock.getUniqueName())) {
            if (!GameStageHelper.hasStage(entityPlayer, stage.getGameStage())) {
                if (entityPlayer.getEntityWorld().isRemote) {
                    entityPlayer.sendStatusMessage(new StringTextComponent(stage.getFailureMessage()), true);
                }
                multiblockFormEvent.setCanceled(true);
            }
        }
    }
}
