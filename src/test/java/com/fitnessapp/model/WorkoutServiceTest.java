package com.fitnessapp.model;

import com.fitnessapp.service.WorkoutService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit tests for WorkoutService.
 *
 * These tests verify that:
 * - workouts can be created for users
 */
public class WorkoutServiceTest {
    /**
     * Testcase: Should create workout for user.
     *
     * Steps:
     * 1. Create User.
     * 2. Create workout using WorkoutService.
     * 3. Check user workout list.
     *
     * Result state:
     * - User has one workout.
     * - Returned Workout is the same object that was added to user.
     * - Workout date is stored currently.
     */
    @Test
    void testCreateWorkoutForUser_should_add_workout_to_user() {
        // Arrange
        WorkoutService workoutService = new WorkoutService();
        User user = new User(1, "Alex" , "alex@gmail.com");
        LocalDate date = LocalDate.of(2026,7, 10);

        // Act
        Workout workout = workoutService.createWorkoutForUser(user, date);

        // Assert
        assertEquals(1, user.getWorkouts().size());
        assertSame(workout, user.getWorkouts().get(0));
        assertEquals(date, workout.getDate());
    }

    /**
     * Testcase: Should add exercise to workout.
     *
     * Steps:
     * 1. Create workout.
     * 2. Create exercise.
     * 3. Add exercise to workout using WorkoutService
     * 4. Check workout exercise list.
     *
     * Result state:
     * - Workout has exercise.
     *
     */
    @Test
    void testAddExerciseToWorkout_should_add_exercise_to_workout() {
        // Arrange
        WorkoutService workoutService = new WorkoutService();
        Workout workout = new Workout(LocalDate.of(2026,10,7));
        Exercise exercise = new Exercise("Bench Press");

        // Act
        WorkoutExercise workoutExercise = workoutService.addExerciseToWorkout(workout, exercise);

        // Assert
        assertEquals(1, workout.getExercises().size());
        assertSame(workoutExercise, workout.getExercises().get(0));
        assertEquals("Bench Press", workout.getExercises().get(0).getExercise().getName());
    }

    /**
     * Testcase: Should add set to exercise
     *
     * Steps:
     * 1. Create exercise.
     * 2. Create workout exercise.
     * 3. Add set usind WorkoutService.
     * 4. Check workout exercise set list.
     *
     * Result state:
     * - Workout exercise has one set.
     * -
     */
    @Test
    void testAddSetToExercise_should_add_set_to_exercise() {
        // Arrange
        WorkoutService workoutService = new WorkoutService();
        Exercise exercise = new Exercise("Bench Press");
        WorkoutExercise workoutExercise = new WorkoutExercise(exercise);

        // Act
        SetEntry set = workoutService.addSetToExercise(workoutExercise, 70, 10);

        // Assert
        assertEquals(1, workoutExercise.getSets().size());
        assertSame(set, workoutExercise.getSets().get(0));
        assertEquals(70, workoutExercise.getSets().get(0).getWeight());
        assertEquals(10, workoutExercise.getSets().get(0).getReps());

    }
}
