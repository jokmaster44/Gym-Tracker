package com.fitnessapp.model;

import com.fitnessapp.model.enums.TrainingSessionType;

public class TrainingLoadRecommendation {
    private int weekNumber;
    private int sessionNumber;
    private TrainingSessionType sessionType;
    private double targetPercent;
    private double targetWeight;
    private int sets;
    private int reps;

    public TrainingLoadRecommendation(
            int weekNumber,
            int sessionNumber,
            TrainingSessionType sessionType,
            double targetPercent,
            double targetWeight,
            int sets,
            int reps) {

        this.weekNumber = weekNumber;
        this.sessionNumber = sessionNumber;
        this.sessionType = sessionType;
        this.targetPercent = targetPercent;
        this.targetWeight = targetWeight;
        this.sets = sets;
        this.reps = reps;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public TrainingSessionType getSessionType() {
        return sessionType;
    }

    public double getTargetPercent() {
        return targetPercent;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }
}
