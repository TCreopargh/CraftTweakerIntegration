package xyz.tcreopargh.ctintegration.gamestages.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.darkhax.gamestages.event.GameStageEvent;
import stanhebben.zenscript.annotations.ZenClass;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "gamestages.GameStageAddedEvent")
@ModOnly("gamestages")
public class CTGameStageAddedEvent implements IGameStageEvent {

    private final GameStageEvent.Added event;

    public CTGameStageAddedEvent(GameStageEvent.Added event) {
        this.event = event;
    }

    @Override
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getEntityPlayer());
    }

    @Override
    public String getGameStage() {
        return event.getStageName();
    }
}
