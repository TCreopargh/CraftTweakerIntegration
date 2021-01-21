package xyz.tcreopargh.ctintegration.gamestages.events;

import net.darkhax.gamestages.event.GameStageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public static void onGameStageAdd(GameStageEvent.Add event) {
        if (EventsExpansion.stageAddEvents.hasHandlers()) {
            EventsExpansion.stageAddEvents.publish(new CTGameStageAddEvent(event));
        }
    }

    @SubscribeEvent
    public static void onGameStageRemove(GameStageEvent.Remove event) {
        if (EventsExpansion.stageRemoveEvents.hasHandlers()) {
            EventsExpansion.stageRemoveEvents.publish(new CTGameStageRemoveEvent(event));
        }
    }

    @SubscribeEvent
    public static void onGameStageCleared(GameStageEvent.Cleared event) {
        if (EventsExpansion.stageClearedEvents.hasHandlers()) {
            EventsExpansion.stageClearedEvents.publish(new CTGameStageClearedEvent(event));
        }
    }
}
