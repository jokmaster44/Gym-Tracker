package com.fitnessapp.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutExercise {
    private Exercise exercise;
    private List<SetEntry> sets;

    public WorkoutExercise(Exercise exercise) {
        this.exercise = exercise;
        this.sets = new ArrayList<>();
    }

    public void addSet(SetEntry set) {
        sets.add(set);
    }

    public double getTotalVolume() {
        double total = 0;
        for (SetEntry set : sets) {
            total += set.getVolume();
        }
        return total;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public List<SetEntry> getSets() {
        return sets;
    }
}
