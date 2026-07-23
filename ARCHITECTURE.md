# Architecture

## Current Stage

The project is currently in Phase 1: Domain Model.

The current application is a console-based Java project. It does not use Spring Boot, REST API, database persistence, authentication, Docker, or deployment yet.

## Current Package Structure

```text
src/main/java/com/fitnessapp
+-- app
|   +-- Main.java
+-- model
|   +-- Exercise.java
|   +-- SetEntry.java
|   +-- TrainingLoadRecommendation.java
|   +-- TrainingPrescription.java
|   +-- User.java
|   +-- Workout.java
|   +-- WorkoutExercise.java
|   +-- WorkoutHistory.java
|   +-- enums
|       +-- TrainingGoal.java
|       +-- TrainingLevel.java
|       +-- TrainingSessionType.java
+-- service
    +-- ProgressService.java
    +-- TrainingCycleService.java
    +-- WorkoutService.java
```

## Package Responsibilities

### app

Contains application entry points.

Current class:
- `Main`

### model

Contains domain objects.

Current classes:
- `Exercise`
- `SetEntry`
- `TrainingLoadRecommendation`
- `TrainingPrescription`
- `User`
- `Workout`
- `WorkoutExercise`
- `WorkoutHistory`

### service

Contains business logic and calculations.

Current class:
- `ProgressService`
- `TrainingCycleService`
- `WorkoutService`

## Current Domain Model

```text
WorkoutHistory
  -> Workout
      -> WorkoutExercise
          -> Exercise
          -> SetEntry

User
  -> Workout
```

## Current Responsibilities

### Exercise

Represents an exercise.

Current data:
- exercise name
- muscle groups

### SetEntry

Represents one training set.

Current data:
- weight
- repetitions

Current behavior:
- calculates set volume: `weight * reps`

### User

Represents an application user.

Current data:
- id
- name
- email
- workouts

Current behavior:
- adds workouts

### WorkoutExercise

Represents one exercise inside a workout.

Current data:
- exercise
- sets

Current behavior:
- adds sets
- calculates total exercise volume

### Workout

Represents one workout on a specific date.

Current data:
- date
- workout exercises

Current behavior:
- adds exercises
- calculates total workout volume

### WorkoutHistory

Represents workout history.

Current data:
- workouts

Current behavior:
- adds workouts
- searches workout exercises by exercise name

### ProgressService

Calculates progress-related values.

Current behavior:
- calculates volume difference
- calculates volume progress percentage
- checks whether progress exists
- rounds numbers to two decimals

### TrainingPrescription

Represents recommended set and repetition prescription.

Current data:
- sets
- reps

### TrainingLoadRecommendation

Represents one generated training load recommendation.

Current data:
- week number
- session number
- session type
- target percent
- target weight
- sets
- reps

### TrainingCycleService

Generates training load recommendations.

Current behavior:
- calculates target weight from one rep max and percentage
- determines session type from weekly frequency and session number
- selects target percentage from goal, week number, and session type
- selects set and rep prescription from goal and session type
- generates one training load recommendation
- generates a 4-week monthly plan
- rejects invalid training cycle input values

## Future Architecture Direction

According to the roadmap, the project should later move toward:

- Spring Boot application structure
- REST controllers
- DTOs
- services
- repositories
- database persistence
- validation
- exception handling
- authentication and authorization

No advanced infrastructure should be introduced before it has a clear learning and project purpose.
