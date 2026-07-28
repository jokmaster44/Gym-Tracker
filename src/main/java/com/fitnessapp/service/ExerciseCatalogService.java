package com.fitnessapp.service;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.enums.MuscleGroup;

import java.util.ArrayList;
import java.util.List;

public class ExerciseCatalogService {
    private List<Exercise> exercises;

    public ExerciseCatalogService(){
        this.exercises = new ArrayList<>();
        addDefaultExercise("Bench Press" , MuscleGroup.CHEST);
        addDefaultExercise("Incline Bench Press", MuscleGroup.CHEST);
        addDefaultExercise("Dumbbell Bench Press", MuscleGroup.CHEST);
        addDefaultExercise("Cable Crossover", MuscleGroup.CHEST);
        addDefaultExercise("Pull Up", MuscleGroup.BACK);
    }

    private void addDefaultExercise(String name, MuscleGroup muscleGroup) {

        Exercise exercise = new Exercise(name);
        exercise.addMuscleGroup(muscleGroup);
        exercises.add(exercise);
    }

    public List<Exercise> findByMuscleGroup(MuscleGroup muscleGroup) {

        List<Exercise> foundExercises = new ArrayList<>();

        for (Exercise exercise : exercises){
            if (exercise.getMuscleGroups().contains(muscleGroup)){
                foundExercises.add(exercise);
            }
        }
        return foundExercises;
    }
}
