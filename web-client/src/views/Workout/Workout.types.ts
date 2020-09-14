import { AsyncThunkAction } from "@reduxjs/toolkit";

import { WorkoutScoringVO, WorkoutTypeVO } from "apiSpecs";

export interface WorkoutState {
    name: string;
    date: string;
    type: string;
    scoring: string;
    description: string;
    notes: string;
    types: WorkoutTypeVO[];
    scorings: WorkoutScoringVO[];
}

export interface WorkoutStateProps {
    workoutType: string;
    workoutScoring: string;
    workoutDate: string;
    workoutDescription: string;
    workoutName: string;
    workoutNotes: string;
    types: WorkoutTypeVO[];
    scorings: WorkoutScoringVO[];
}

export interface WorkoutDispatchProps {
    setWorkoutType: (name: string) => void;
    setWorkoutScoring: (name: string) => void;
    setWorkoutDate: (name: string) => void;
    setWorkoutName: (name: string) => void;
    setWorkoutDescription: (description: string) => void;
    setWorkoutNotes: (description: string) => void;
    loadWorkoutTypes: () => AsyncThunkAction<WorkoutTypeVO[], never, { rejectValue: string }>;
    loadWorkoutScorings: () => AsyncThunkAction<WorkoutScoringVO[], never, { rejectValue: string }>;
}

export interface WorkoutProps extends WorkoutStateProps, WorkoutDispatchProps {}
