package com.fitnessapp.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutHistory {
    private List<Workout> workouts;

    public WorkoutHistory() {
        this.workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public List<WorkoutExercise> findExercisesByName(String exerciseName) {
        List<WorkoutExercise> foundExercises = new ArrayList<>();

        for (Workout workout : workouts) {
            for (WorkoutExercise workoutExercise : workout.getExercises()) {
                if (workoutExercise.getExercise().getName().equalsIgnoreCase(exerciseName)) {
                    foundExercises.add(workoutExercise);
                }
            }
        }

        return foundExercises;
    }
}
