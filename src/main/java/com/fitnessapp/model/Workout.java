package com.fitnessapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    private LocalDate date;
    private List<WorkoutExercise> exercises;

    public Workout(LocalDate date) {
        this.date = date;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(WorkoutExercise exercise) {
        exercises.add(exercise);
    }

    public double getTotalVolume() {
        double total = 0;
        for (WorkoutExercise exercise : exercises) {
            total += exercise.getTotalVolume();
        }
        return total;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<WorkoutExercise> getExercises() {
        return exercises;
    }
}
