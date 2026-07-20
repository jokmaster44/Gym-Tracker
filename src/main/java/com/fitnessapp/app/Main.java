package com.fitnessapp.app;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.ProgressResult;
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

        ProgressResult progressResult = progressService.compareExerciseByDate(
                user,
                "Bench Press",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 8),
                workoutService
        );

        Workout foundWorkout = workoutService.findWorkoutByDate(user, LocalDate.of(2026, 7, 1));

        if (foundWorkout != null) {
            WorkoutExercise foundExercise = workoutService.findExerciseInWorkout(foundWorkout, "Bench Press");

            if (foundExercise != null) {
                System.out.println("Found exercise: " + foundExercise.getExercise().getName());
                System.out.println("Found exercise volume: " + foundExercise.getTotalVolume());
            } else {
                System.out.println("Exercise not found in workout");
            }
        } else {
            System.out.println("Workout not found");
        }

        System.out.println("User: " + user.getName());
        System.out.println("User workouts: " + user.getWorkouts().size());
        System.out.println("First workout volume: " + firstWorkout.getTotalVolume());
        System.out.println("Second workout volume: " + secondWorkout.getTotalVolume());

        if (progressResult != null) {
            System.out.println("Old volume: " + progressResult.getOldVolume());
            System.out.println("New volume: " + progressResult.getNewVolume());
            System.out.println("Volume difference: " + progressResult.getVolumeDifference());
            System.out.println("Progress percent: " + progressResult.getProgressPercent() + "%");
        } else {
            System.out.println("Progress result not found");
        }
    }
}
