package com.fitnessapp.model;

import com.fitnessapp.model.enums.MuscleGroup;

import java.time.DayOfWeek;

/**
 * Represents one planned training day in a weekly training plan.
 *
 * A training day connects a day of week with one primary muscle group.
 */
public class TrainingDay {
    private DayOfWeek dayOfWeek;
    private MuscleGroup muscleGroup;

    /**
     * Creates a training day for a selected day of week and muscle group.
     *
     * @param dayOfWeek selected day of week
     * @param muscleGroup primary muscle group trained on this day
     */
    public TrainingDay(DayOfWeek dayOfWeek, MuscleGroup muscleGroup){
        this.dayOfWeek = dayOfWeek;
        this.muscleGroup = muscleGroup;
    }

    /**
     * Returns the day of week for this training day.
     *
     * @return selected day of week
     */
    public DayOfWeek getDayOfWeek(){
        return dayOfWeek;
    }

    /**
     * Returns the primary muscle group for this training day.
     *
     * @return selected muscle group
     */
    public MuscleGroup getMuscleGroup(){
        return muscleGroup;
    }
}
