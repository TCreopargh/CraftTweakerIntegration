package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;
import xyz.tcreopargh.ctintegration.date.IDate;

import java.util.List;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "advancement.IAdvancementProgress")
public interface IAdvancementProgress {

    Object getInternal();

    @ZenMethod
    boolean isDone();

    @ZenMethod
    boolean hasProgress();

    @ZenMethod
    boolean grantCriterion(String criterion);

    @ZenMethod
    boolean revokeCriterion(String criterion);

    @ZenMethod
    List<String> getCompletedCriteria();

    @ZenMethod
    List<String> getRemainingCriteria();

    @ZenMethod
    float getPercent();

    @ZenMethod
    String getProgressText();

    @ZenMethod
    boolean isCriterionObtained(String criterion);

    @ZenMethod
    IDate getCriterionObtainedDate(String criterion);

    @ZenMethod
    IDate getFirstProgressDate(String criterion);

    @ZenMethod
    void obtainCriterion(String criterion);

    @ZenMethod
    void resetCriterion(String criterion);

    @ZenMethod
    boolean setCompleted();

    @ZenMethod
    void resetAll();

}
