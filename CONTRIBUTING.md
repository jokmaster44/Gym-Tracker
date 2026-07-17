# Contributing

This project is primarily a learning project.

The goal is to build engineering skill while developing a portfolio-quality Java backend application.

## Development Workflow

Before writing code:

1. Define the goal.
2. Design the model.
3. Think about relationships.
4. Implement the smallest useful change.
5. Test the change.
6. Commit one logical change.

## Code Style

Prefer:

- small classes
- small methods
- meaningful names
- clear responsibilities
- readable code
- simple solutions
- tests for important business logic

Avoid:

- unnecessary abstraction
- large classes
- large methods
- unclear names
- duplicated logic
- new libraries without a clear reason

## Naming

Classes should use `PascalCase`.

Examples:
- `WorkoutService`
- `ExerciseController`
- `WorkoutRepository`

Variables should use `camelCase`.

Examples:
- `workoutHistory`
- `totalVolume`
- `exerciseName`

Constants should use `UPPER_CASE`.

Examples:
- `MAX_SETS`
- `DEFAULT_WEIGHT`

## Testing

Important business logic should be covered by unit tests.

Use the AAA pattern:

```text
Arrange
Act
Assert
```

Test names should describe behavior.

Bad:

```java
test1()
```

Good:

```java
shouldCalculateWorkoutVolume()
```

## Git

Commit often.

Every commit should represent one logical change.

Good commit examples:

- Create Workout entity
- Add Exercise repository
- Implement workout volume calculation
- Refactor WorkoutService

## Code Review

When reviewing code, check:

- naming
- readability
- duplication
- architecture
- testability
- possible bugs

Every suggestion should include an explanation.

The goal is not just to fix code. The goal is to understand why the change improves the project.
