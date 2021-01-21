package xyz.tcreopargh.ctintegration.gamestages.events;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.darkhax.gamestages.event.GameStageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.events.IEventManager")
@ZenRegister
@ModOnly("gamestages")
public class EventsExpansion {

    private static final EventList<CTGameStageAddEvent> stageAddEvents = new EventList<>();
    private static final EventList<CTGameStageRemoveEvent> stageRemoveEvents = new EventList<>();
    private static final EventList<CTGameStageClearedEvent> stageClearedEvents = new EventList<>();

    @ZenMethod
    public static IEventHandle onGameStageAdd(IEventManager manager, IEventHandler<CTGameStageAddEvent> event) {
        return stageAddEvents.add(event);
    }

    @ZenMethod
    public static IEventHandle onGameStageRemove(IEventManager manager, IEventHandler<CTGameStageRemoveEvent> event) {
        return stageRemoveEvents.add(event);
    }

    @ZenMethod
    public static IEventHandle onGameStageCleared(IEventManager manager, IEventHandler<CTGameStageClearedEvent> event) {
        return stageClearedEvents.add(event);
    }


    public static final class EventHandler {
        @SubscribeEvent
        public static void onGameStageAdd(GameStageEvent.Add event) {
            if (stageAddEvents.hasHandlers()) {
                stageAddEvents.publish(new CTGameStageAddEvent(event));
            }
        }

        @SubscribeEvent
        public static void onGameStageRemove(GameStageEvent.Remove event) {
            if (stageRemoveEvents.hasHandlers()) {
                stageRemoveEvents.publish(new CTGameStageRemoveEvent(event));
            }
        }

        @SubscribeEvent
        public static void onGameStageCleared(GameStageEvent.Cleared event) {
            if (stageClearedEvents.hasHandlers()) {
                stageClearedEvents.publish(new CTGameStageClearedEvent(event));
            }
        }
    }

}
