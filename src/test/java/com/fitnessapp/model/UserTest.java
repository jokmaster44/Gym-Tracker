package com.fitnessapp.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit tests for User.
 *
 * These tests verify that:
 * - workouts can be added to user
 */
public class UserTest {

    /**
     * Testcase: Should add workout to user.
     *
     * Steps:
     * 1. Create user.
     * 2. Create workout.
     * 3. Add workout to user.
     * 4. Check user workout list.
     *
     * Result state:
     * - User has one workout.
     * - Added workout is stored correctly.
     */
    @Test
    void testAddWorkout_should_add_workout_to_user() {

        // Arrange
        User user = new User(1, "Alex", "alex@example.com");
        Workout workout = new Workout(LocalDate.of(2026, 7, 22));

        // Act
        user.addWorkout(workout);

        // Assert
        assertEquals(1, user.getWorkouts().size());
        assertSame(workout, user.getWorkouts().get(0));
    }
}