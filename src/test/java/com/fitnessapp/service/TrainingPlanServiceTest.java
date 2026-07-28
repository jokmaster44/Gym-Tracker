package com.fitnessapp.service;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.TrainingDay;
import com.fitnessapp.model.enums.MuscleGroup;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainingPlanServiceTest {

    @Test
    void testGetExercisesForTrainingDay_should_return_exercises_for_training_day() {
        // Arrange
        TrainingPlanService trainingPlanService = new TrainingPlanService();
        ExerciseCatalogService exerciseCatalogService = new ExerciseCatalogService();
        TrainingDay trainingDay = new TrainingDay(DayOfWeek.MONDAY, MuscleGroup.CHEST);

        // Act
        List<Exercise> exercises = trainingPlanService.getExercisesForTrainingDay(
                trainingDay,
                exerciseCatalogService
        );

        // Assert
        assertEquals(4, exercises.size());
    }
}