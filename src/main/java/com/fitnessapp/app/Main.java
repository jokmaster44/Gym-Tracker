package com.fitnessapp.app;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.User;
import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutExercise;
import com.fitnessapp.service.ProgressService;
import com.fitnessapp.service.WorkoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        WorkoutService workoutService = new WorkoutService();
        ProgressService progressService = new ProgressService();

        User user = new User(1, "Alex", "alex@example.com");

        Exercise benchPress = new Exercise("Bench Press");
        benchPress.addMuscleGroup("Chest");
        benchPress.addMuscleGroup("Triceps");

        Workout firstWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 1));
        WorkoutExercise firstBenchPress = workoutService.addExerciseToWorkout(firstWorkout, benchPress);
        workoutService.addSetToExercise(firstBenchPress, 70, 10);

        Workout secondWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 8));
        WorkoutExercise secondBenchPress = workoutService.addExerciseToWorkout(secondWorkout, benchPress);
        workoutService.addSetToExercise(secondBenchPress, 80, 10);

        double volumeDifference = progressService.calculateVolumeDifference(firstBenchPress, secondBenchPress);
        double progressPercent = progressService.calculateVolumeProgressPercent(firstBenchPress, secondBenchPress);
        double roundedProgressPercent = progressService.roundToTwoDecimals(progressPercent);

        Workout foundWorkout = workoutService.findWorkoutByDate(user, LocalDate.of(2026, 7, 1));

        if (foundWorkout != null) {
            System.out.println("Found workout volume: " + foundWorkout.getTotalVolume());
        } else {
            System.out.println("Workout not found");
        }


        System.out.println("User: " + user.getName());
        System.out.println("User workouts: " + user.getWorkouts().size());
        System.out.println("First workout volume: " + firstWorkout.getTotalVolume());
        System.out.println("Second workout volume: " + secondWorkout.getTotalVolume());
        System.out.println("Volume difference: " + volumeDifference);
        System.out.println("Progress percent: " + roundedProgressPercent + "%");
    }
}
