# Gym Tracker

## Goal

Create a backend application for tracking gym workouts.

## Architecture

Entities:
- User
- Workout
- Exercise
- WorkoutExercise
- SetEntry

Relationships:

```text
User -> Workout -> WorkoutExercise -> Exercise
                              -> SetEntry
```

## Development Rules

- Never overengineer.
- Keep code clean.
- Follow SOLID where appropriate.
- Every feature should have a clear purpose.
- Every important service should be unit-tested.
- Do not introduce new libraries without a reason.
- Explain architectural decisions before implementing them.

## Workflow

Before writing code:

1. Define the goal.
2. Design the model.
3. Think about relationships.
4. Implement.
5. Test.
6. Commit.
