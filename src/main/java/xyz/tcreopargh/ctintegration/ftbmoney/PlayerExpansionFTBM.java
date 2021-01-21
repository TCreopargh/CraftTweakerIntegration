package xyz.tcreopargh.ctintegration.ftbmoney;

import com.feed_the_beast.mods.money.FTBMoney;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ftbmoney")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionFTBM {

    @ZenMethod
    public static long getFTBMoney(IPlayer player) {
        EntityPlayer mcPlayer = (EntityPlayer) player.getInternal();
        return FTBMoney.getMoney(mcPlayer);
    }

    @ZenMethod
    public static void setFTBMoney(IPlayer player, long value) {
        EntityPlayer mcPlayer = (EntityPlayer) player.getInternal();
        FTBMoney.setMoney(mcPlayer, value);
    }

    @ZenMethod
    public static void addFTBMoney(IPlayer player, long value) {
        EntityPlayer mcPlayer = (EntityPlayer) player.getInternal();
        FTBMoney.setMoney(mcPlayer, FTBMoney.getMoney(mcPlayer) + value);
    }

    @ZenMethod
    public static void removeFTBMoney(IPlayer player, long value) {
        EntityPlayer mcPlayer = (EntityPlayer) player.getInternal();
        FTBMoney.setMoney(mcPlayer, FTBMoney.getMoney(mcPlayer) - value);
    }
}
