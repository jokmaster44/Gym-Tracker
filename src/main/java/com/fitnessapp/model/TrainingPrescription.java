package com.fitnessapp.model;

public class TrainingPrescription {
    private int sets;
    private int reps;

    public TrainingPrescription(int sets, int reps) {
        this.sets = sets;
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }
}