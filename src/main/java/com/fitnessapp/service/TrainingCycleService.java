package com.fitnessapp.service;

import com.fitnessapp.model.TrainingLoadRecommendation;
import com.fitnessapp.model.TrainingPrescription;
import com.fitnessapp.model.enums.TrainingGoal;
import com.fitnessapp.model.enums.TrainingSessionType;

import java.util.ArrayList;
import java.util.List;

public class TrainingCycleService {

    public double calculateTargetWeight(double oneRepMax, double percent) {
        validateOneRepMax(oneRepMax);
        validatePercent(percent);

        return oneRepMax * percent / 100;
    }

    public TrainingSessionType getSessionType(int frequencyPerWeek, int sessionNumber) {
        validateFrequencyPerWeek(frequencyPerWeek);
        validateSessionNumber(frequencyPerWeek, sessionNumber);

        if (frequencyPerWeek == 1) {
            return TrainingSessionType.HEAVY;
        }

        if (frequencyPerWeek == 2) {
            if (sessionNumber == 1) {
                return TrainingSessionType.HEAVY;
            }

            return TrainingSessionType.MEDIUM;
        }

        if (sessionNumber == 1) {
            return TrainingSessionType.HEAVY;
        }

        if (sessionNumber == 2) {
            return TrainingSessionType.MEDIUM;
        }

        return TrainingSessionType.LIGHT;
    }

    public double getTargetPercent(
            TrainingGoal goal,
            int weekNumber,
            TrainingSessionType sessionType) {

        validateGoal(goal);
        validateWeekNumber(weekNumber);
        validateSessionType(sessionType);

        switch (goal) {
            case STRENGTH:
                return getStrengthPercent(weekNumber, sessionType);
            case HYPERTROPHY:
                return getHypertrophyPercent(weekNumber, sessionType);
            case ENDURANCE:
                return getEndurancePercent(weekNumber, sessionType);
            default:
                throw new IllegalArgumentException("Unsupported training goal: " + goal);
        }
    }

    private double getStrengthPercent(int weekNumber, TrainingSessionType sessionType) {
        switch (weekNumber) {
            case 1:
                return getPercentBySessionType(sessionType, 80, 72.5, 65, 60);
            case 2:
                return getPercentBySessionType(sessionType, 85, 77.5, 67.5, 60);
            case 3:
                return getPercentBySessionType(sessionType, 90, 80, 70, 60);
            case 4:
                return getPercentBySessionType(sessionType, 70, 65, 60, 60);
            default:
                throw new IllegalArgumentException("Week number must be between 1 and 4");
        }
    }

    private double getHypertrophyPercent(int weekNumber, TrainingSessionType sessionType) {
        switch (weekNumber) {
            case 1:
                return getPercentBySessionType(sessionType, 70, 65, 60, 55);
            case 2:
                return getPercentBySessionType(sessionType, 72.5, 67.5, 62.5, 55);
            case 3:
                return getPercentBySessionType(sessionType, 75, 70, 65, 55);
            case 4:
                return getPercentBySessionType(sessionType, 60, 57.5, 55, 55);
            default:
                throw new IllegalArgumentException("Week number must be between 1 and 4");
        }
    }

    private double getEndurancePercent(int weekNumber, TrainingSessionType sessionType) {
        switch (weekNumber) {
            case 1:
                return getPercentBySessionType(sessionType, 55, 50, 45, 40);
            case 2:
                return getPercentBySessionType(sessionType, 60, 55, 50, 40);
            case 3:
                return getPercentBySessionType(sessionType, 65, 60, 55, 40);
            case 4:
                return getPercentBySessionType(sessionType, 50, 45, 40, 40);
            default:
                throw new IllegalArgumentException("Week number must be between 1 and 4");
        }
    }

    private double getPercentBySessionType(
            TrainingSessionType sessionType,
            double heavyPercent,
            double mediumPercent,
            double lightPercent,
            double deloadPercent) {

        switch (sessionType) {
            case HEAVY:
                return heavyPercent;
            case MEDIUM:
                return mediumPercent;
            case LIGHT:
                return lightPercent;
            case DELOAD:
                return deloadPercent;
            default:
                throw new IllegalArgumentException("Unsupported session type: " + sessionType);
        }
    }

    public TrainingPrescription getPrescription(
            TrainingGoal goal,
            TrainingSessionType sessionType) {

        validateGoal(goal);
        validateSessionType(sessionType);

        switch (goal) {
            case STRENGTH:
                return getStrengthPrescription(sessionType);
            case HYPERTROPHY:
                return getHypertrophyPrescription(sessionType);
            case ENDURANCE:
                return getEndurancePrescription(sessionType);
            default:
                throw new IllegalArgumentException("Unsupported training goal: " + goal);
        }
    }

    private TrainingPrescription getStrengthPrescription(TrainingSessionType sessionType) {
        switch (sessionType) {
            case HEAVY:
                return new TrainingPrescription(4, 4);
            case MEDIUM:
                return new TrainingPrescription(4, 5);
            case LIGHT:
                return new TrainingPrescription(3, 6);
            case DELOAD:
                return new TrainingPrescription(3, 5);
            default:
                throw new IllegalArgumentException("Unsupported session type: " + sessionType);
        }
    }

    private TrainingPrescription getHypertrophyPrescription(TrainingSessionType sessionType) {
        switch (sessionType) {
            case HEAVY:
                return new TrainingPrescription(4, 8);
            case MEDIUM:
                return new TrainingPrescription(4, 10);
            case LIGHT:
                return new TrainingPrescription(3, 12);
            case DELOAD:
                return new TrainingPrescription(3, 10);
            default:
                throw new IllegalArgumentException("Unsupported session type: " + sessionType);
        }
    }

    private TrainingPrescription getEndurancePrescription(TrainingSessionType sessionType) {
        switch (sessionType) {
            case HEAVY:
                return new TrainingPrescription(3, 12);
            case MEDIUM:
                return new TrainingPrescription(3, 15);
            case LIGHT:
                return new TrainingPrescription(2, 20);
            case DELOAD:
                return new TrainingPrescription(2, 15);
            default:
                throw new IllegalArgumentException("Unsupported session type: " + sessionType);
        }
    }

    public TrainingLoadRecommendation generateRecommendation(
            TrainingGoal goal,
            double oneRepMax,
            int weekNumber,
            int frequencyPerWeek,
            int sessionNumber) {

        validateGoal(goal);
        validateOneRepMax(oneRepMax);
        validateWeekNumber(weekNumber);
        validateFrequencyPerWeek(frequencyPerWeek);
        validateSessionNumber(frequencyPerWeek, sessionNumber);

        TrainingSessionType sessionType = getSessionType(frequencyPerWeek, sessionNumber);
        double targetPercent = getTargetPercent(goal, weekNumber, sessionType);
        double targetWeight = calculateTargetWeight(oneRepMax, targetPercent);
        TrainingPrescription prescription = getPrescription(goal, sessionType);

        return new TrainingLoadRecommendation(
                weekNumber,
                sessionNumber,
                sessionType,
                targetPercent,
                targetWeight,
                prescription.getSets(),
                prescription.getReps()
        );
    }

    public List<TrainingLoadRecommendation> generateMonthlyPlan(
            TrainingGoal goal,
            double oneRepMax,
            int frequencyPerWeek) {

        validateGoal(goal);
        validateOneRepMax(oneRepMax);
        validateFrequencyPerWeek(frequencyPerWeek);

        List<TrainingLoadRecommendation> recommendations = new ArrayList<>();

        for (int weekNumber = 1; weekNumber <= 4; weekNumber++) {
            for (int sessionNumber = 1; sessionNumber <= frequencyPerWeek; sessionNumber++) {
                TrainingLoadRecommendation recommendation = generateRecommendation(
                        goal,
                        oneRepMax,
                        weekNumber,
                        frequencyPerWeek,
                        sessionNumber
                );

                recommendations.add(recommendation);
            }
        }

        return recommendations;
    }

    private void validateGoal(TrainingGoal goal) {
        if (goal == null) {
            throw new IllegalArgumentException("Training goal is required");
        }
    }

    private void validateSessionType(TrainingSessionType sessionType) {
        if (sessionType == null) {
            throw new IllegalArgumentException("Training session type is required");
        }
    }

    private void validateOneRepMax(double oneRepMax) {
        if (oneRepMax <= 0) {
            throw new IllegalArgumentException("One rep max must be greater than 0");
        }
    }

    private void validatePercent(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be between 0 and 100");
        }
    }

    private void validateWeekNumber(int weekNumber) {
        if (weekNumber < 1 || weekNumber > 4) {
            throw new IllegalArgumentException("Week number must be between 1 and 4");
        }
    }

    private void validateFrequencyPerWeek(int frequencyPerWeek) {
        if (frequencyPerWeek < 1 || frequencyPerWeek > 3) {
            throw new IllegalArgumentException("Frequency per week must be between 1 and 3");
        }
    }

    private void validateSessionNumber(int frequencyPerWeek, int sessionNumber) {
        if (sessionNumber < 1 || sessionNumber > frequencyPerWeek) {
            throw new IllegalArgumentException("Session number must be between 1 and frequency per week");
        }
    }
}
