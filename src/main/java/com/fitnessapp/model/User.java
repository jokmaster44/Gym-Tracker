package com.fitnessapp.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private String email;
    private List<Workout> workouts;

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}
