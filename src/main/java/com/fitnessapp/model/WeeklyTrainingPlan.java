package com.fitnessapp.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user's weekly training schedule.
 *
 * The first version supports one primary muscle group per training day.
 */
public class WeeklyTrainingPlan {
    private List<TrainingDay> trainingDays;

    /**
     * Creates an empty weekly training plan.
     */
    public WeeklyTrainingPlan() {
        this.trainingDays = new ArrayList<>();
    }

    /**
     * Adds a training day to the weekly plan.
     *
     * @param trainingDay training day to add
     * @throws IllegalArgumentException if the plan already contains a training day
     *                                  for the same day of week
     */
    public void addTrainingDay(TrainingDay trainingDay) {
        if (hasTrainingOnDay(trainingDay.getDayOfWeek())){
            throw new IllegalArgumentException("Training day already exists");
        }
        trainingDays.add(trainingDay);
    }

    /**
     * Returns a copy of planned training days.
     *
     * @return copied list of training days
     */
    public List<TrainingDay> getTrainingDays() {
        return new ArrayList<>(trainingDays);
    }

    /**
     * Checks whether the plan already contains a training day for the selected
     * day of week.
     *
     * @param dayOfWeek day of week to check
     * @return true if training is planned on the selected day, otherwise false
     */
    public boolean hasTrainingOnDay(DayOfWeek dayOfWeek) {
        for (TrainingDay trainingDay : trainingDays){
            if (trainingDay.getDayOfWeek().equals(dayOfWeek)){
                return true;
            }
        }
        return false;
    }

}
