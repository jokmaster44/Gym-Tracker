package com.fitnessapp.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String name;
    private List<String> muscleGroups;

    public Exercise(String name) {
        this.name = name;
        this.muscleGroups = new ArrayList<>();
    }

    public void addMuscleGroup(String muscleGroup) {
        muscleGroups.add(muscleGroup);
    }

    public String getName() {
        return name;
    }

    public List<String> getMuscleGroups() {
        return muscleGroups;
    }
}
