# FitnessApp

FitnessApp is a Java training tracker project.

Current goal:
- save workouts by date;
- save exercises and sets;
- calculate training volume;
- compare progress between workouts.

## Project Structure

```text
src/main/java/com/fitnessapp
+-- app
|   +-- Main.java
|   +-- ConsoleApp.java
+-- model
|   +-- Exercise.java
|   +-- SetEntry.java
|   +-- TrainingLoadRecommendation.java
|   +-- TrainingPrescription.java
|   +-- User.java
|   +-- Workout.java
|   +-- WorkoutExercise.java
|   +-- WorkoutHistory.java
+-- service
    +-- TrainingCycleService.java
    +-- ProgressService.java
```

## Packages

- `app` contains application entry points and the current console interface.
- `model` contains core objects from the fitness domain.
- `service` contains business logic and calculations.

## Current Console Features

- generate a 4-week training load plan;
- choose goal: strength, hypertrophy, or endurance;
- enter one rep max;
- enter weekly frequency for an exercise or muscle group.

## Run Current Console App

```powershell
javac -d target\classes src\main\java\com\fitnessapp\model\*.java src\main\java\com\fitnessapp\model\enums\*.java src\main\java\com\fitnessapp\service\*.java src\main\java\com\fitnessapp\app\*.java
java -cp target\classes com.fitnessapp.app.Main
```
