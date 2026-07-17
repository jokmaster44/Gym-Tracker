package com.fitnessapp.service;

import com.fitnessapp.model.Exercise;
import com.fitnessapp.model.SetEntry;
import com.fitnessapp.model.User;
import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutExercise;

import java.time.LocalDate;


public class WorkoutService {

    public Workout createWorkoutForUser(User user, LocalDate date){
        Workout workout = new Workout(date);
        user.addWorkout(workout);
        return workout;
    }

    public WorkoutExercise addExerciseToWorkout(Workout workout, Exercise exercise) {
        WorkoutExercise workoutExercise = new WorkoutExercise(exercise);
        workout.addExercise(workoutExercise);
        return workoutExercise;
    }

    public SetEntry addSetToExercise(WorkoutExercise workoutExercise, double weight, int reps){
        SetEntry set = new SetEntry(weight, reps);
        workoutExercise.addSet(set);
        return set;
    }

    public Workout findWorkoutByDate(User user, LocalDate date) {
        for (Workout workout : user.getWorkouts()) {
            if (workout.getDate().equals(date)) {
                return workout;
            }
        }

        return null;
    }
}
