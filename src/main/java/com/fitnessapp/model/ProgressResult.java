package com.fitnessapp.model;

public class ProgressResult {

    private double oldVolume;
    private double newVolume;
    private double volumeDifference;
    private double progressPercent;

    public ProgressResult(double oldVolume, double newVolume, double volumeDifference, double progressPercent) {

        this.oldVolume = oldVolume;
        this.newVolume = newVolume;
        this.volumeDifference = volumeDifference;
        this.progressPercent = progressPercent;
    }

    public double getOldVolume() {
        return oldVolume;
    }

    public double getNewVolume() {
        return newVolume;
    }

    public double getVolumeDifference() {
        return volumeDifference;
    }

    public double getProgressPercent() {
        return progressPercent;
    }
}
