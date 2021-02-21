package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.server.IServer;
import crafttweaker.api.text.ITextComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ZenExpansion("crafttweaker.server.IServer")
@ZenRegister
public class ServerExpansionMC {

    @ZenGetter("players")
    public static IPlayer[] getPlayers(IServer server) {
        MinecraftServer mcServer = CraftTweakerMC.getMCServer(server);
        List<IPlayer> players = new ArrayList<>();
        mcServer.getPlayerList().getPlayers().forEach(p -> {
            players.add(CraftTweakerMC.getIPlayer(p));
        });
        return players.toArray(new IPlayer[0]);
    }

    @ZenMethod
    public static IPlayer getPlayerByUUID(IServer server, String uuid) {
        MinecraftServer mcServer = CraftTweakerMC.getMCServer(server);
        EntityPlayer mcPlayer = mcServer.getPlayerList().getPlayerByUUID(UUID.fromString(uuid));
        return CraftTweakerMC.getIPlayer(mcPlayer);
    }

    @ZenMethod
    public static IPlayer getPlayerByUsername(IServer server, String name) {
        MinecraftServer mcServer = CraftTweakerMC.getMCServer(server);
        EntityPlayer mcPlayer = mcServer.getPlayerList().getPlayerByUsername(name);
        return CraftTweakerMC.getIPlayer(mcPlayer);
    }

    @ZenGetter("playerCount")
    public static int getPlayerCount(IServer server) {
        MinecraftServer mcServer = CraftTweakerMC.getMCServer(server);
        return mcServer.getPlayerList().getCurrentPlayerCount();
    }

    @ZenGetter("maxPlayers")
    public static int getMaxPlayers(IServer server) {
        MinecraftServer mcServer = CraftTweakerMC.getMCServer(server);
        return mcServer.getMaxPlayers();
    }

    @ZenMethod
    public static void broadcastMessage(IServer server, ITextComponent message, @Optional boolean isSystem) {
        MinecraftServer mcServer = CraftTweakerMC.getMCServer(server);
        net.minecraft.util.text.ITextComponent mcTextComponent = CraftTweakerMC.getITextComponent(message);
        mcServer.getPlayerList().sendMessage(mcTextComponent, isSystem);
    }
}
