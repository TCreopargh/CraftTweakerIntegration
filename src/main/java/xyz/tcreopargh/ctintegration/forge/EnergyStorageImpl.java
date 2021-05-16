package xyz.tcreopargh.ctintegration.forge;

public class EnergyStorageImpl implements IEnergyStorage{

    private final net.minecraftforge.energy.IEnergyStorage internal;

    public EnergyStorageImpl(net.minecraftforge.energy.IEnergyStorage storage) {
        this.internal = storage;
    }

    @Override
    public Object getInternal() {
        return internal;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return internal.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return internal.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return internal.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored() {
        return internal.getMaxEnergyStored();
    }

    @Override
    public boolean canExtract() {
        return internal.canExtract();
    }

    @Override
    public boolean canReceive() {
        return internal.canReceive();
    }
}
