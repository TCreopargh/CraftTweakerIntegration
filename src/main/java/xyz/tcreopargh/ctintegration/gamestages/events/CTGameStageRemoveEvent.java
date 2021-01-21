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
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "gamestages.GameStageRemoveEvent")
@ModOnly("gamestages")
public class CTGameStageRemoveEvent implements IEventCancelable, IGameStageEvent {

    private final GameStageEvent.Remove event;

    public CTGameStageRemoveEvent(GameStageEvent.Remove event) {
        this.event = event;
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean b) {
        event.setCanceled(b);
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
