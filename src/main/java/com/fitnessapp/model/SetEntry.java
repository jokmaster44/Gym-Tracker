package com.fitnessapp.model;

public class SetEntry {
    private double weight;
    private int reps;

    public SetEntry(double weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public double getVolume() {
        return weight * reps;
    }

    @Override
    public String toString() {
        return weight + " kg x " + reps;
    }
}
