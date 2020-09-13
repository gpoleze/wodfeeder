import { Dispatch } from "redux";

import { WorkoutTypeVO } from "apiSpecs";

export interface WorkoutState {
    name: string;
    date: string;
    type: string;
    scoreType: string;
    description: string;
    notes: string;
    types: WorkoutTypeVO[];
}

export interface WorkoutStateProps {
    workoutType: string;
    // workoutScore: string;
    workoutDate: string;
    workoutDescription: string;
    workoutName: string;
    workoutNotes: string;
    types: WorkoutTypeVO[];
}

export interface WorkoutDispatchProps {
    setWorkoutType: (name: string) => void;
    // setWorkoutScore: (name: string) => void;
    setWorkoutDate: (name: string) => void;
    setWorkoutName: (name: string) => void;
    setWorkoutDescription: (description: string) => void;
    setWorkoutNotes: (description: string) => void;
    loadWorkoutTypes: () => (dispatch: Dispatch) => void;
}

export interface WorkoutProps extends WorkoutStateProps, WorkoutDispatchProps {}
