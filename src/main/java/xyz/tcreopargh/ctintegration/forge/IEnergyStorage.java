package xyz.tcreopargh.ctintegration.forge;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "IEnergyStorage")
public interface IEnergyStorage {

    Object getInternal();

    @ZenMethod
    int receiveEnergy(int maxReceive, @Optional boolean simulate);

    @ZenMethod
    int extractEnergy(int maxExtract, @Optional boolean simulate);

    @ZenMethod
    int getEnergyStored();

    @ZenMethod
    int getMaxEnergyStored();

    @ZenMethod
    boolean canExtract();

    @ZenMethod
    boolean canReceive();
}
