package xyz.tcreopargh.ctintegration.sereneseasons;

import crafttweaker.annotations.ModOnly;

public class ImplSeasonState implements ISeasonState {
    private sereneseasons.api.season.ISeasonState internal;

    public sereneseasons.api.season.ISeasonState getInternal() {
        return internal;
    }

    public void setInternal(sereneseasons.api.season.ISeasonState internal) {
        this.internal = internal;
    }

    public ImplSeasonState(sereneseasons.api.season.ISeasonState seasonState) {
        this.internal = seasonState;
    }

    @Override
    public int getDayDuration() {
        return internal.getDayDuration();
    }

    @Override
    public int getSubSeasonDuration() {
        return internal.getSubSeasonDuration();
    }

    @Override
    public int getSeasonDuration() {
        return internal.getSeasonDuration();
    }

    @Override
    public int getCycleDuration() {
        return internal.getCycleDuration();
    }

    @Override
    public int getSeasonCycleTicks() {
        return internal.getSeasonCycleTicks();
    }

    @Override
    public int getDay() {
        return internal.getDay();
    }

    @Override
    public int getSeason() {
        return internal.getSeason().ordinal();
    }

    @Override
    public int getSubSeason() {
        return internal.getSubSeason().ordinal();
    }

    @Override
    public String getSubSeasonName() {
        return internal.getSubSeason().name();
    }

    @Override
    public String getSeasonName() {
        return internal.getSeason().name();
    }

    @Override
    public int getTropicalSeason() {
        return internal.getTropicalSeason().ordinal();
    }

    @Override
    public String getTropicalSeasonName() {
        return internal.getTropicalSeason().name();
    }
}
