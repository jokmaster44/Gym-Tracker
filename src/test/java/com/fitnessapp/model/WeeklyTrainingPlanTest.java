package com.fitnessapp.model;

import com.fitnessapp.model.enums.MuscleGroup;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for WeeklyTrainingPlan.
 *
 * These tests verify that:
 * - training days can be added to a weekly plan
 * - duplicate training days for the same day of week are rejected
 */
public class WeeklyTrainingPlanTest {

    /**
     * Testcase: Should add training day to weekly plan.
     *
     * Steps:
     * 1. Create weekly training plan.
     * 2. Create training day for Monday and chest.
     * 3. Add training day to the plan.
     *
     * Result state:
     * - Plan contains one training day.
     * - Monday is marked as a training day.
     */
    @Test
    void testAddTrainingDay_should_add_training_day(){
        // Arrange
        WeeklyTrainingPlan plan = new WeeklyTrainingPlan();
        TrainingDay trainingDay = new TrainingDay(DayOfWeek.MONDAY, MuscleGroup.CHEST);

        // Act
        plan.addTrainingDay(trainingDay);

        // Assert
        assertEquals(1, plan.getTrainingDays().size());
        assertTrue(plan.hasTrainingOnDay(DayOfWeek.MONDAY));

    }

    /**
     * Testcase: Should reject duplicate training day.
     *
     * Steps:
     * 1. Create weekly training plan.
     * 2. Add training day for Monday.
     * 3. Try to add another training day for Monday.
     *
     * Result state:
     * - IllegalArgumentException is thrown.
     */
    @Test
    void testAddTrainingDay_should_throw_exception_when_day_already_exists(){
        // Arrange
        WeeklyTrainingPlan plan = new WeeklyTrainingPlan();
        plan.addTrainingDay(new TrainingDay(DayOfWeek.MONDAY, MuscleGroup.CHEST));

        // Act + Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> plan.addTrainingDay(new TrainingDay(DayOfWeek.MONDAY, MuscleGroup.BACK))
        );
    }
}
