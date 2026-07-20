package com.fitnessapp.service;

import com.fitnessapp.model.ProgressResult;
import com.fitnessapp.model.User;
import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutExercise;

import java.time.LocalDate;

public class ProgressService {

    public ProgressResult compareExerciseByDate(
            User user,
            String exerciseName,
            LocalDate firstDate,
            LocalDate secondDate,
            WorkoutService workoutService) {

        Workout firstWorkout = workoutService.findWorkoutByDate(user, firstDate);
        Workout secondWorkout = workoutService.findWorkoutByDate(user, secondDate);

        if (firstWorkout == null || secondWorkout == null) {
            return null;
        }

        WorkoutExercise firstExercise = workoutService.findExerciseInWorkout(firstWorkout, exerciseName);
        WorkoutExercise secondExercise = workoutService.findExerciseInWorkout(secondWorkout, exerciseName);

        if (firstExercise == null || secondExercise == null) {
            return null;
        }

        double oldVolume = firstExercise.getTotalVolume();
        double newVolume = secondExercise.getTotalVolume();
        double volumeDifference = calculateVolumeDifference(firstExercise, secondExercise);
        double progressPercent = calculateVolumeProgressPercent(firstExercise, secondExercise);
        double roundedProgressPercent = roundToTwoDecimals(progressPercent);

        return new ProgressResult(oldVolume, newVolume, volumeDifference, roundedProgressPercent);
    }

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
