package xyz.tcreopargh.ctintegration.bloodmagic;

import WayofTime.bloodmagic.core.data.SoulTicket;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.text.ITextComponent;
import stanhebben.zenscript.annotations.*;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "bloodmagic.SoulNetork")
@ModOnly("bloodmagic")
@ZenRegister
public class SoulNetwork {
    private final WayofTime.bloodmagic.core.data.SoulNetwork network;

    public SoulNetwork(WayofTime.bloodmagic.core.data.SoulNetwork network) {
        this.network = network;
    }

    @ZenMethod
    public void add(int amount, int maximum) {
        network.add(new SoulTicket(amount), maximum);
    }

    @ZenMethod
    public void add(ITextComponent description, int amount, int maximum) {
        network.add(new SoulTicket(CraftTweakerMC.getITextComponent(description), amount), maximum);
    }

    @ZenMethod
    public void syphon(ITextComponent description, int amount, @Optional boolean skipEvent) {
        network.syphon(new SoulTicket(CraftTweakerMC.getITextComponent(description), amount), skipEvent);
    }

    @ZenMethod
    public void hurtPlayer(IPlayer player, float syphon) {
        network.hurtPlayer(CraftTweakerMC.getPlayer(player), syphon);
    }

    @ZenMethod
    public IPlayer getCachedPlayer() {
        return CraftTweakerMC.getIPlayer(network.getCachedPlayer());
    }

    @ZenGetter("orbTier")
    public int getOrbTier() {
        return network.getOrbTier();
    }

    @ZenSetter("orbTier")
    public void setOrbTier(int tier) {
        network.setOrbTier(tier);
    }

    @ZenGetter("currentEssence")
    public int getCurrentEssence() {
        return network.getCurrentEssence();
    }

    @ZenSetter("currentEssence")
    public void setCurrentEssence(int amount) {
        network.setCurrentEssence(amount);
    }

    @ZenMethod
    public void clear() {
        network.clear();
    }
}
