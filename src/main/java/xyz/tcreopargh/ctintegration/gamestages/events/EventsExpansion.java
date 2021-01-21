package xyz.tcreopargh.ctintegration.gamestages.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.events.IEventManager")
@ZenRegister
@ModOnly("gamestages")
public class EventsExpansion {

    public static final EventList<CTGameStageAddEvent> stageAddEvents = new EventList<>();
    public static final EventList<CTGameStageRemoveEvent> stageRemoveEvents = new EventList<>();
    public static final EventList<CTGameStageClearedEvent> stageClearedEvents = new EventList<>();

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
}
