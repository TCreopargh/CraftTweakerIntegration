package xyz.tcreopargh.ctintegration.thread;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "thread.Thread")
@ZenRegister
public class CTThread {

    private final Thread internal;

    public CTThread(IRunnable action) {
        internal = new Thread(() -> {
            try {
                action.run();
            } catch (InterruptedException e) {
                CraftTweakerAPI.logError(e.getMessage(), e);
            }
        });
    }

    public CTThread(String name, IRunnable action) {

        internal = new Thread(() -> {
            try {
                action.run();
            } catch (InterruptedException e) {
                CraftTweakerAPI.logError(e.getMessage(), e);
            }
        });
        internal.setName(name);
    }

    @ZenMethod
    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
        }
    }

    @ZenMethod
    public static CTThread create(IRunnable action) {
        return new CTThread(action);
    }

    @ZenMethod
    public static CTThread create(String name, IRunnable action) {
        return new CTThread(name, action);
    }

    @ZenMethod
    public void run() {
        internal.run();
    }

    @ZenMethod
    public void start() {
        internal.start();
    }

    @ZenMethod
    public boolean isDeamon() {
        return internal.isDaemon();
    }

    @ZenMethod
    public void setDeamon(boolean deamon) {
        internal.setDaemon(deamon);
    }

    @ZenMethod
    public String getName() {
        return internal.getName();
    }

    @ZenMethod
    public void setName(String name) {
        internal.setName(name);
    }

    @ZenMethod
    public long getId() {
        return internal.getId();
    }

    @ZenMethod
    public boolean isAlive() {
        return internal.isAlive();
    }

    @ZenMethod
    public int getPriority() {
        return internal.getPriority();
    }

    @ZenMethod
    public void setPriority(int priority) {
        internal.setPriority(priority);
    }

    @ZenMethod
    public void interrupt() {
        internal.interrupt();
    }

    @ZenMethod
    public boolean isInterrrupted() {
        return internal.isInterrupted();
    }
}
