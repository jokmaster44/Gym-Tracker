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
+-- model
|   +-- Exercise.java
|   +-- SetEntry.java
|   +-- User.java
|   +-- Workout.java
|   +-- WorkoutExercise.java
|   +-- WorkoutHistory.java
+-- service
    +-- ProgressService.java
```

## Packages

- `app` contains application entry points.
- `model` contains core objects from the fitness domain.
- `service` contains business logic and calculations.

## Run Current Console Demo

```powershell
javac -d target\classes src\main\java\com\fitnessapp\model\*.java src\main\java\com\fitnessapp\service\*.java src\main\java\com\fitnessapp\app\*.java
java -cp target\classes com.fitnessapp.app.Main
```
