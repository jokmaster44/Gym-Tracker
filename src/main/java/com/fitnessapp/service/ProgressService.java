package com.fitnessapp.service;

import com.fitnessapp.model.WorkoutExercise;

public class ProgressService {
    public double calculateVolumeDifference(WorkoutExercise oldExercise, WorkoutExercise newExercise) {
        return newExercise.getTotalVolume() - oldExercise.getTotalVolume();
    }

    public double calculateVolumeProgressPercent(WorkoutExercise oldExercise, WorkoutExercise newExercise) {
        double oldVolume = oldExercise.getTotalVolume();

        if (oldVolume == 0) {
            return 0;
        }

        double difference = calculateVolumeDifference(oldExercise, newExercise);
        return difference / oldVolume * 100;
    }

    public boolean hasProgress(WorkoutExercise oldExercise, WorkoutExercise newExercise) {
        return calculateVolumeDifference(oldExercise, newExercise) > 0;
    }

    public double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
