package com.fitnessapp.app;

import com.fitnessapp.model.TrainingLoadRecommendation;
import com.fitnessapp.model.enums.TrainingGoal;
import com.fitnessapp.service.TrainingCycleService;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private final Scanner scanner;
    private final TrainingCycleService trainingCycleService;

    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
        this.trainingCycleService = new TrainingCycleService();
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose option: ");

            switch (choice) {
                case 1:
                    generateMonthlyPlan();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option");
            }
        }

        System.out.println("Goodbye");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== Gym Tracker ===");
        System.out.println("1. Generate monthly training plan");
        System.out.println("0. Exit");
    }

    private void generateMonthlyPlan() {
        TrainingGoal goal = readTrainingGoal();
        double oneRepMax = readDouble("Enter one rep max: ");
        int frequencyPerWeek = readInt("Enter sessions per week for this exercise or muscle group (1-3): ");

        try {
            List<TrainingLoadRecommendation> recommendations = trainingCycleService.generateMonthlyPlan(
                    goal,
                    oneRepMax,
                    frequencyPerWeek
            );

            printRecommendations(recommendations);
        } catch (IllegalArgumentException exception) {
            System.out.println("Cannot generate plan: " + exception.getMessage());
        }
    }

    private TrainingGoal readTrainingGoal() {
        while (true) {
            System.out.println();
            System.out.println("Choose training goal:");
            System.out.println("1. Strength");
            System.out.println("2. Hypertrophy");
            System.out.println("3. Endurance");

            int choice = readInt("Goal: ");

            switch (choice) {
                case 1:
                    return TrainingGoal.STRENGTH;
                case 2:
                    return TrainingGoal.HYPERTROPHY;
                case 3:
                    return TrainingGoal.ENDURANCE;
                default:
                    System.out.println("Unknown goal");
            }
        }
    }

    private void printRecommendations(List<TrainingLoadRecommendation> recommendations) {
        System.out.println();
        System.out.println("Monthly training plan:");

        for (TrainingLoadRecommendation recommendation : recommendations) {
            System.out.println(
                    "Week " + recommendation.getWeekNumber()
                            + ", session " + recommendation.getSessionNumber()
                            + " [" + recommendation.getSessionType() + "]"
                            + ": " + recommendation.getTargetPercent() + "%"
                            + ", " + recommendation.getTargetWeight() + " kg"
                            + ", " + recommendation.getSets() + " sets"
                            + " x " + recommendation.getReps() + " reps"
            );
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            scanner.nextLine();
            System.out.println("Please enter a valid integer");
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }

            scanner.nextLine();
            System.out.println("Please enter a valid number");
        }
    }
}
