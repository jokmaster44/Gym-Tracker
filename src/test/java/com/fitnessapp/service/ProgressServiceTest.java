package com.fitnessapp.service;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.ProgressResult;
import com.fitnessapp.model.User;
import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutExercise;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for ProgressService.
 *
 * These tests verify that:
 * - exercise progress can be compared between two workout dates
 * - missing workout dates return no progress result
 */
public class ProgressServiceTest {

    /**
     * Testcase: Should compare exercise progress by date.
     * <p>
     * Steps:
     * 1. Create user.
     * 2. Create two workouts on different dates.
     * 3. Add the same exercise to both workouts.
     * 4. Add one set to each workout exercise.
     * 5. Compare exercise progress by date.
     * <p>
     * Result state:
     * - Old volume is 700.
     * - New volume is 800.
     * - Volume difference is 100.
     * - Progress percent is 14.29.
     */
    @Test
    void testCompareExerciseByDate_should_return_progress_result() {

        // Arrange
        WorkoutService workoutService = new WorkoutService();
        ProgressService progressService = new ProgressService();
        User user = new User(1, "Alex", "alex@example.com");

        Exercise benchPress = new Exercise("Bench Press");

        Workout firstWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 1));
        WorkoutExercise firstBenchPress = workoutService.addExerciseToWorkout(firstWorkout, benchPress);
        workoutService.addSetToExercise(firstBenchPress, 70, 10);

        Workout secondWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 8));
        WorkoutExercise secondBenchPress = workoutService.addExerciseToWorkout(secondWorkout, benchPress);
        workoutService.addSetToExercise(secondBenchPress, 80, 10);

        // Act
        ProgressResult result = progressService.compareExerciseByDate(
                user,
                "Bench Press",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 8),
                workoutService
        );

        // Assert
        assertNotNull(result);
        assertEquals(700, result.getOldVolume());
        assertEquals(800, result.getNewVolume());
        assertEquals(100, result.getVolumeDifference());
        assertEquals(14.29, result.getProgressPercent());
    }

    /**
     * Testcase: Should return null when workout date is not found.
     * <p>
     * Steps:
     * 1. Create user.
     * 2. Create only one workout.
     * 3. Try to compare exercise progress with a missing second date.
     * <p>
     * Result state:
     * - Progress result is null.
     */
    @Test
    void testCompareExerciseByDate_should_return_null_when_workout_date_not_found() {

        // Arrange
        WorkoutService workoutService = new WorkoutService();
        ProgressService progressService = new ProgressService();
        User user = new User(1, "Alex", "alex@example.com");

        Exercise benchPress = new Exercise("Bench Press");

        Workout firstWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 1));
        WorkoutExercise firstBenchPress = workoutService.addExerciseToWorkout(firstWorkout, benchPress);
        workoutService.addSetToExercise(firstBenchPress, 70, 10);

        // Act
        ProgressResult result = progressService.compareExerciseByDate(
                user,
                "Bench Press",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 10),
                workoutService
        );

        // Assert
        assertNull(result);
    }

    /**
     * Testcase: Should return null when exercise is not found in one workout.
     * <p>
     * Steps:
     * 1. Create user.
     * 2. Create two workouts on different dates.
     * 3. Add Bench Press to the first workout.
     * 4. Add Squat to the second workout.
     * 5. Try to compare Bench Press progress between both dates.
     * <p>
     * Result state:
     * - Progress result is null.
     */
    @Test
    void testCompareExerciseByDate_should_return_null_when_exercise_is_not_found() {

        // Arrange
        WorkoutService workoutService = new WorkoutService();
        ProgressService progressService = new ProgressService();
        User user = new User(1, "Alex", "alex@example.com");

        Exercise benchPress = new Exercise("Bench Press");
        Exercise squat = new Exercise("Squat");

        Workout firstWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 1));
        WorkoutExercise firstBenchPress = workoutService.addExerciseToWorkout(firstWorkout, benchPress);
        workoutService.addSetToExercise(firstBenchPress, 70, 10);

        Workout secondWorkout = workoutService.createWorkoutForUser(user, LocalDate.of(2026, 7, 8));
        WorkoutExercise secondSquat = workoutService.addExerciseToWorkout(secondWorkout, squat);
        workoutService.addSetToExercise(secondSquat, 100, 5);

        // Act
        ProgressResult result = progressService.compareExerciseByDate(
                user,
                "Bench Press",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 8),
                workoutService
        );

        // Assert
        assertNull(result);
    }
}