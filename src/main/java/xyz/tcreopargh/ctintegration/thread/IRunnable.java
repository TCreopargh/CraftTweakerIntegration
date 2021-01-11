package xyz.tcreopargh.ctintegration.thread;


import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "thread.IRunnable")
@ZenRegister
public interface IRunnable {
    void run() throws InterruptedException;
}
