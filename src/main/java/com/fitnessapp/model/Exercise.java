package com.fitnessapp.model;

import com.fitnessapp.model.enums.MuscleGroup;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String name;
    private List<MuscleGroup> muscleGroups;

    public Exercise(String name) {
        this.name = name;
        this.muscleGroups = new ArrayList<>();
    }

    public void addMuscleGroup(MuscleGroup muscleGroup) {
        muscleGroups.add(muscleGroup);
    }

    public String getName() {
        return name;
    }

    public List<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }
}
