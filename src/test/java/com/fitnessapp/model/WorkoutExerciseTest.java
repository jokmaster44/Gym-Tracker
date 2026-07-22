package com.fitnessapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for WorkoutExercise.
 *
 * These tests verify that:
 * - total exercise volume is calculated correctly
 */
public class WorkoutExerciseTest {

    /**
     * Testcase: Should calculate total volume for exercise.
     *
     * Steps:
     * 1. Create exercise.
     * 2. Create workout exercise.
     * 3. Add two sets.
     * 4. Call getTotalVolume().
     *
     * Result state:
     * - Returned volume is 1300.
     */
    @Test
    void testGetTotalVolume_should_return_total_volume_in_exercise() {

        // Arrange
        Exercise exercise = new Exercise("Bench Press");
        WorkoutExercise workoutExercise = new WorkoutExercise(exercise);
        workoutExercise.addSet(new SetEntry(70, 10));
        workoutExercise.addSet(new SetEntry(75, 8));

        // Act
        double totalVolume = workoutExercise.getTotalVolume();

        // Assert
        assertEquals(1300, totalVolume);
    }
}
