package xyz.tcreopargh.ctintegration.baubles;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("baubles")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionBaubles {

    @ZenGetter("baublesInventory")
    public static IBaublesInventory getBaublesInventory(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(mcPlayer);
        return new ImplBaubleInventory(handler);
    }

    @ZenMethod
    public static int isBaubleEquipped(IPlayer player, IItemStack bauble) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        ItemStack mcItemStack = CraftTweakerMC.getItemStack(bauble);
        return BaublesApi.isBaubleEquipped(mcPlayer, mcItemStack.getItem());
    }
}
