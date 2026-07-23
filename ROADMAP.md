# Roadmap

## Phase 1: Domain Model

Status: In progress

Build the core Java classes that describe the gym tracker domain.

Main focus:
- User
- Workout
- Exercise
- WorkoutExercise
- SetEntry
- relationships between entities

## Phase 2: Unit Tests

Status: In progress

Add tests for important domain logic and service calculations.

Main focus:
- volume calculation tests
- progress calculation tests
- workout history search tests

Current coverage:
- exercise muscle group behavior
- user workout behavior
- set volume and text formatting
- workout exercise total volume
- workout total volume
- workout service behavior
- progress service behavior
- training cycle target weight behavior
- training cycle recommendation behavior
- monthly training plan behavior
- training cycle validation behavior

## Phase 3: Spring Boot

Move the project toward a backend application structure.

Main focus:
- create Spring Boot application entry point
- organize packages for backend development
- keep existing domain model clean

## Phase 4: REST API

Expose backend functionality through HTTP endpoints.

Main focus:
- workouts endpoints
- exercises endpoints
- set entries endpoints
- progress endpoints

## Phase 5: Database

Persist application data instead of keeping it only in memory.

Main focus:
- choose database
- map entities to database tables
- add repositories
- test persistence logic

## Phase 6: Authentication

Add user accounts and protect user-specific data.

Main focus:
- registration
- login
- user ownership of workouts
- protected endpoints

## Phase 7: Docker

Prepare the application to run in containers.

Main focus:
- Dockerfile
- application configuration
- database container
- local development setup

## Phase 8: Deployment

Deploy the application so it can run outside the local computer.

Main focus:
- production configuration
- environment variables
- deployment target
- basic monitoring and logs
