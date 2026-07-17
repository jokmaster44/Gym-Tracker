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
|   +-- User.java
|   +-- Workout.java
|   +-- WorkoutExercise.java
|   +-- WorkoutHistory.java
+-- service
    +-- ProgressService.java
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
- `User`
- `Workout`
- `WorkoutExercise`
- `WorkoutHistory`

### service

Contains business logic and calculations.

Current class:
- `ProgressService`

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
