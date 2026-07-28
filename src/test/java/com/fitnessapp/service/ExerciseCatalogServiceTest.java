package com.fitnessapp.service;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.enums.MuscleGroup;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExerciseCatalogServiceTest {

    @Test
    void testFindByMuscleGroup_should_return_chest_exercises() {
        // Arrange
        ExerciseCatalogService exerciseCatalogService = new ExerciseCatalogService();

        // Act
        List<Exercise> chestExercises = exerciseCatalogService.findByMuscleGroup(MuscleGroup.CHEST);

        // Assert
        assertEquals(4, chestExercises.size());
        assertTrue(containsExerciseByName(chestExercises, "Bench Press"));
    }

    @Test
    void testFindByMuscleGroup_should_return_back_exercises() {
        // Arrange
        ExerciseCatalogService exerciseCatalogService = new ExerciseCatalogService();

        // Act
        List<Exercise> backExercises = exerciseCatalogService.findByMuscleGroup(MuscleGroup.BACK);

        // Assert
        assertEquals(1, backExercises.size());
        assertTrue(containsExerciseByName(backExercises, "Pull Up"));
    }

    private boolean containsExerciseByName(List<Exercise> exercises, String exerciseName) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(exerciseName)) {
                return true;
            }
        }

        return false;
    }
}
