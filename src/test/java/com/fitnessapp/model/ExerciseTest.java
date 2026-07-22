package com.fitnessapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for Exercise.
 *
 * These tests verify that:
 * - muscle groups can be added to exercise
 */
public class ExerciseTest {

    /**
     * Testcase: Should add muscle group to exercise.
     *
     * Steps:
     * 1. Create exercise.
     * 2. Add muscle group.
     * 3. Check muscle group list.
     *
     * Result state:
     * - Exercise has one muscle group.
     * - Added muscle group is stored correctly.
     */
    @Test
    void testAddMuscleGroup_should_add_muscle_group_to_exercise() {

        // Arrange
        Exercise exercise = new Exercise("Bench Press");

        // Act
        exercise.addMuscleGroup("Chest");

        // Assert
        assertEquals(1, exercise.getMuscleGroups().size());
        assertEquals("Chest", exercise.getMuscleGroups().get(0));
    }
}