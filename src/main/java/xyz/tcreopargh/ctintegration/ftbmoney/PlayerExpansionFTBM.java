package xyz.tcreopargh.ctintegration.ftbmoney;

import com.feed_the_beast.mods.money.FTBMoney;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ModOnly("ftbmoney")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionFTBM {

    @ZenGetter("ftbMoney")
    public static long getMoney(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return FTBMoney.getMoney(mcPlayer);
    }

    @ZenSetter("ftbMoney")
    public static void setMoney(IPlayer player, long value) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        FTBMoney.setMoney(mcPlayer, value);
    }
}
