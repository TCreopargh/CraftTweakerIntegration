package xyz.tcreopargh.ctintegration.sereneseasons;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ModOnly("sereneseasons")
@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "sereneseasons.ISeasonState")
public interface ISeasonState {

    @ZenGetter("dayDuration")
    int getDayDuration();

    @ZenGetter("subSeasonDuration")
    int getSubSeasonDuration();

    @ZenGetter("seasonDuration")
    int getSeasonDuration();

    @ZenGetter("cycleDuration")
    int getCycleDuration();

    @ZenGetter("seasonCycleTicks")
    int getSeasonCycleTicks();

    @ZenGetter("day")
    int getDay();

    @ZenGetter("season")
    int getSeason();

    @ZenGetter("subSeason")
    int getSubSeason();

    @ZenGetter("subSeasonName")
    String getSubSeasonName();

    @ZenGetter("seasonName")
    String getSeasonName();

    @ZenGetter("tropicalSeason")
    int getTropicalSeason();

    @ZenGetter("tropicalSeasonName")
    String getTropicalSeasonName();

    Object getInternal();
}

