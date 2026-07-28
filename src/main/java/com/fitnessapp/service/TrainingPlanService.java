package com.fitnessapp.service;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.TrainingDay;

import java.util.List;

public class TrainingPlanService {

    public List<Exercise> getExercisesForTrainingDay(
            TrainingDay trainingDay,
            ExerciseCatalogService exerciseCatalogService) {

        return exerciseCatalogService.findByMuscleGroup(trainingDay.getMuscleGroup());
    }
}
