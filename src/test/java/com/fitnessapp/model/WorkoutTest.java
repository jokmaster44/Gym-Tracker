package com.fitnessapp.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for Workout.
 *
 * These tests verify that:
 * - workout total volume is calculated correctly
 */
public class WorkoutTest {

    /**
     * Testcase: Should calculate total workout volume.
     *
     * Steps:
     * 1. Create workout.
     * 2. Create two exercises.
     * 3. Add one set to each exercise.
     * 4. Add exercises to workout.
     * 5. Call getTotalVolume().
     *
     * Result state:
     * - Returned volume is 2550.
     */
    @Test
    void testGetTotalVolume_should_return_total_workout_volume() {
        // Arrange
        Workout workout = new Workout(LocalDate.of(2026, 7, 20));

        Exercise benchPress = new Exercise("Bench Press");
        WorkoutExercise benchPressInWorkout = new WorkoutExercise(benchPress);
        benchPressInWorkout.addSet(new SetEntry(70, 10));

        Exercise squat = new Exercise("Squat");
        WorkoutExercise squatInWorkout = new WorkoutExercise(squat);
        squatInWorkout.addSet(new SetEntry(90, 10));

        Exercise chestPress = new Exercise("Chest Press");
        WorkoutExercise chestPressInWorkout = new WorkoutExercise(chestPress);
        chestPressInWorkout.addSet(new SetEntry(95, 10));

        workout.addExercise(benchPressInWorkout);
        workout.addExercise(squatInWorkout);
        workout.addExercise(chestPressInWorkout);

        // Act
        double totalVolume = workout.getTotalVolume();

        // Assert
        assertEquals(2550, totalVolume);
    }
}
