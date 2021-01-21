package xyz.tcreopargh.ctintegration.gamestages.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IPlayerEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "gamestages.IGameStageEvent")
@ModOnly("gamestages")
public interface IGameStageEvent extends IPlayerEvent {
    @ZenGetter("gameStage")
    String getGameStage();
}
