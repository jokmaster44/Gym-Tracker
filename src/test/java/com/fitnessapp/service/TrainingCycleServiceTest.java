package com.fitnessapp.service;

import com.fitnessapp.model.TrainingLoadRecommendation;
import com.fitnessapp.model.enums.TrainingGoal;
import com.fitnessapp.model.enums.TrainingSessionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for TrainingCycleService.
 *
 * These tests verify that:
 * - target weight can be calculated from one rep max and percentage
 * - one training load recommendation can be generated
 * - a monthly training plan can be generated
 * - invalid input values are rejected
 */
public class TrainingCycleServiceTest {

    /**
     * Testcase: Should calculate target weight from one rep max and percent.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Calculate target weight for 100 kg and 75%.
     *
     * Result state:
     * - Target weight is 75 kg.
     */
    @Test
    void testCalculateTargetWeight_should_return_percent_of_one_rep_max() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act
        double targetWeight = trainingCycleService.calculateTargetWeight(100, 75);

        // Assert
        assertEquals(75, targetWeight);
    }

    /**
     * Testcase: Should generate training load recommendation.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Generate recommendation for STRENGTH goal.
     * 3. Check generated recommendation values.
     *
     * Result state:
     * - Week number is 2.
     * - Session number is 1.
     * - Session type is HEAVY.
     * - Target percent is 85.
     * - Target weight is 85.
     * - Sets are 4.
     * - Reps are 4.
     */
    @Test
    void testGenerateRecommendation_should_return_recommendation() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act
        TrainingLoadRecommendation recommendation = trainingCycleService.generateRecommendation(
                TrainingGoal.STRENGTH,
                100,
                2,
                2,
                1
        );

        // Assert
        assertEquals(2, recommendation.getWeekNumber());
        assertEquals(1, recommendation.getSessionNumber());
        assertEquals(TrainingSessionType.HEAVY, recommendation.getSessionType());
        assertEquals(85, recommendation.getTargetPercent());
        assertEquals(85, recommendation.getTargetWeight());
        assertEquals(4, recommendation.getSets());
        assertEquals(4, recommendation.getReps());
    }

    /**
     * Testcase: Should generate monthly training plan.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Generate monthly plan for STRENGTH goal with 2 sessions per week.
     * 3. Check plan size and first recommendation.
     *
     * Result state:
     * - Plan has 8 recommendations.
     * - First recommendation is week 1, session 1, HEAVY.
     * - First recommendation target percent is 80.
     * - First recommendation target weight is 80.
     * - First recommendation prescription is 4 sets and 4 reps.
     */
    @Test
    void testGenerateMonthlyPlan_should_return_monthly_plan() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act
        List<TrainingLoadRecommendation> recommendations = trainingCycleService.generateMonthlyPlan(
                TrainingGoal.STRENGTH,
                100,
                2
        );
        TrainingLoadRecommendation firstRecommendation = recommendations.get(0);

        // Assert
        assertEquals(8, recommendations.size());
        assertEquals(1, firstRecommendation.getWeekNumber());
        assertEquals(1, firstRecommendation.getSessionNumber());
        assertEquals(TrainingSessionType.HEAVY, firstRecommendation.getSessionType());
        assertEquals(80, firstRecommendation.getTargetPercent());
        assertEquals(80, firstRecommendation.getTargetWeight());
        assertEquals(4, firstRecommendation.getSets());
        assertEquals(4, firstRecommendation.getReps());
    }

    /**
     * Testcase: Should reject invalid one rep max.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Try to calculate target weight with zero one rep max.
     *
     * Result state:
     * - IllegalArgumentException is thrown.
     */
    @Test
    void testCalculateTargetWeight_should_throw_exception_when_one_rep_max_is_invalid() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> trainingCycleService.calculateTargetWeight(0, 75)
        );
    }

    /**
     * Testcase: Should reject invalid week number.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Try to generate recommendation for week 5.
     *
     * Result state:
     * - IllegalArgumentException is thrown.
     */
    @Test
    void testGenerateRecommendation_should_throw_exception_when_week_number_is_invalid() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> trainingCycleService.generateRecommendation(
                        TrainingGoal.STRENGTH,
                        100,
                        5,
                        2,
                        1
                )
        );
    }

    /**
     * Testcase: Should reject invalid frequency per week.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Try to generate monthly plan with 4 sessions per week.
     *
     * Result state:
     * - IllegalArgumentException is thrown.
     */
    @Test
    void testGenerateMonthlyPlan_should_throw_exception_when_frequency_is_invalid() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> trainingCycleService.generateMonthlyPlan(
                        TrainingGoal.STRENGTH,
                        100,
                        4
                )
        );
    }

    /**
     * Testcase: Should reject invalid session number.
     *
     * Steps:
     * 1. Create TrainingCycleService.
     * 2. Try to generate recommendation for session 3 when frequency is 2.
     *
     * Result state:
     * - IllegalArgumentException is thrown.
     */
    @Test
    void testGenerateRecommendation_should_throw_exception_when_session_number_is_invalid() {

        // Arrange
        TrainingCycleService trainingCycleService = new TrainingCycleService();

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> trainingCycleService.generateRecommendation(
                        TrainingGoal.STRENGTH,
                        100,
                        2,
                        2,
                        3
                )
        );
    }
}
