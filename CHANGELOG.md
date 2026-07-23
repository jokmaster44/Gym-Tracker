# Changelog

All notable changes to this project will be documented in this file.

This project does not have released versions yet.

## Unreleased

### Added

- Created initial Java domain model.
- Added `User` model.
- Added `Exercise` model.
- Added `SetEntry` model.
- Added `WorkoutExercise` model.
- Added `Workout` model.
- Added `WorkoutHistory` model.
- Added `ProgressService`.
- Added console demo in `Main`.
- Added `README.md`.
- Added `PROJECT_GUIDE.md`.
- Added `AI_PROJECT_GUIDE.md`.
- Added `ROADMAP.md`.
- Added `ARCHITECTURE.md`.
- Added `CONTRIBUTING.md`.
- Added JUnit 5 dependency.
- Added unit tests for `Exercise`.
- Added unit tests for `User`.
- Added unit tests for `SetEntry`.
- Added unit tests for `WorkoutExercise`.
- Added unit tests for `Workout`.
- Added unit tests for `WorkoutService`.
- Added unit tests for `ProgressService`.
- Added `TrainingGoal`, `TrainingLevel`, and `TrainingSessionType` enums.
- Added `TrainingPrescription` model.
- Added `TrainingLoadRecommendation` model.
- Added `TrainingCycleService`.
- Added monthly training plan generation.
- Added input validation for training cycle generation.
- Added unit tests for `TrainingCycleService`.

### Changed

- Reorganized Java packages under `com.fitnessapp`.
- Updated Maven `groupId` to `com.fitnessapp`.
- Moved `WorkoutServiceTest` to the `service` test package.
- Removed custom month and day-of-week enums in favor of Java standard date/time types when needed.

### Not Added Yet

- Spring Boot.
- REST API.
- Database.
- Authentication.
- Docker.
- Deployment.
