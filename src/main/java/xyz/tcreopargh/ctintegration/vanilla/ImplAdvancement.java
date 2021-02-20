package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.text.ITextComponent;
import net.minecraft.advancements.Advancement;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.ArrayList;
import java.util.List;

public class ImplAdvancement implements IAdvancement {
    private final Advancement internal;

    public ImplAdvancement(Advancement internal) {
        this.internal = internal;
    }

    @Override
    public Advancement getInternal() {
        return internal;
    }

    @Override
    public String getId() {
        return internal.getId().toString();
    }

    @Override
    public ITextComponent getDisplayText() {
        return CraftTweakerMC.getITextComponent(internal.getDisplayText());
    }

    @Override
    public ITextComponent getTitle() {
        if (internal.getDisplay() != null) {
            return CraftTweakerMC.getITextComponent(internal.getDisplay().getTitle());
        } else {
            return null;
        }
    }

    @Override
    public ITextComponent getDescription() {
        if (internal.getDisplay() != null) {
            return CraftTweakerMC.getITextComponent(internal.getDisplay().getDescription());
        } else {
            return null;
        }
    }

    @Override
    public String[][] getRequirements() {
        return internal.getRequirements();
    }

    @Override
    public int getRequirementCount() {
        return internal.getRequirementCount();
    }

    @Override
    public List<IAdvancement> getChildren() {
        List<IAdvancement> children = new ArrayList<>();
        internal.getChildren().forEach(c -> children.add(new ImplAdvancement(c)));
        return children;
    }

    @Override
    public List<String> getCriterion() {
        List<String> criterion = new ArrayList<>();
        internal.getCriteria().forEach((k, v) -> criterion.add(k));
        return criterion;
    }

    @Override
    public IAdvancement getParent() {
        if(internal.getParent() == null) {
            return null;
        }
        return new ImplAdvancement(internal.getParent());
    }

    @Override
    public void applyRewards(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        if (mcPlayer instanceof EntityPlayerMP) {
            internal.getRewards().apply((EntityPlayerMP) mcPlayer);
        }
    }

}
