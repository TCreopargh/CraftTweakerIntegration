package xyz.tcreopargh.ctintegration.vanilla.advancement;

import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.CriterionProgress;
import xyz.tcreopargh.ctintegration.date.IDate;
import xyz.tcreopargh.ctintegration.date.CalendarDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdvancementProgressImpl implements IAdvancementProgress {
    private final AdvancementProgress internal;

    public AdvancementProgressImpl(AdvancementProgress progress) {
        this.internal = progress;
    }

    @Override
    public AdvancementProgress getInternal() {
        return internal;
    }

    @Override
    public boolean isDone() {
        return internal.isDone();
    }

    @Override
    public boolean hasProgress() {
        return internal.hasProgress();
    }

    @Override
    public boolean grantCriterion(String criterion) {
        return internal.grantCriterion(criterion);
    }

    @Override
    public boolean revokeCriterion(String criterion) {
        return internal.revokeCriterion(criterion);
    }

    @Override
    public List<String> getCompletedCriteria() {
        List<String> criteria = new ArrayList<>();
        internal.getCompletedCriteria().forEach(criteria::add);
        return criteria;
    }

    @Override
    public List<String> getRemainingCriteria() {
        List<String> criteria = new ArrayList<>();
        internal.getRemaningCriteria().forEach(criteria::add);
        return criteria;
    }

    @Override
    public float getPercent() {
        return internal.getPercent();
    }

    @Override
    public String getProgressText() {
        return internal.getProgressText();
    }

    @Override
    public boolean isCriterionObtained(String criterion) {
        CriterionProgress criterionProgress = internal.getCriterionProgress(criterion);
        if (criterionProgress == null) {
            return false;
        } else {
            return criterionProgress.isObtained();
        }
    }

    @Override
    public IDate getCriterionObtainedDate(String criterion) {
        CriterionProgress criterionProgress = internal.getCriterionProgress(criterion);
        if (criterionProgress == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(criterionProgress.getObtained());
            return new CalendarDate(calendar);
        }
    }

    @Override
    public IDate getFirstProgressDate(String criterion) {
        Calendar calendar = Calendar.getInstance();
        if (internal.getFirstProgressDate() != null) {
            calendar.setTime(internal.getFirstProgressDate());
            return new CalendarDate(calendar);
        } else {
            return null;
        }
    }

    @Override
    public void obtainCriterion(String criterion) {
        CriterionProgress criterionProgress = internal.getCriterionProgress(criterion);
        if (criterionProgress != null) {
            criterionProgress.obtain();
        }
    }

    @Override
    public void resetCriterion(String criterion) {
        CriterionProgress criterionProgress = internal.getCriterionProgress(criterion);
        if (criterionProgress != null) {
            criterionProgress.reset();
        }
    }

    @Override
    public boolean setCompleted() {
        if(internal.isDone()) {
            return false;
        } else {
            for (String criterion : internal.getRemaningCriteria()) {
                internal.grantCriterion(criterion);
            }
            return true;
        }
    }

    @Override
    public void resetAll() {
        for (String criterion : internal.getCompletedCriteria()) {
            CriterionProgress criterionProgress = internal.getCriterionProgress(criterion);
            if(criterionProgress != null) {
                criterionProgress.reset();
            }
        }
    }
}
