export interface WorkoutState {
    name: string;
    date: string;
    type: string;
    scoreType: string;
    workout: string;
    observations: string;
}

export interface WorkoutStateProps {
    // workoutType: string;
    // workoutScore: string;
    // workoutDate: string;
    // workoutDescription: string;
    workoutName: string;
    // workoutObservations: string;
}

export interface WorkoutDispatchProps {
    setWorkoutName: (name: string) => void;
}

export interface WorkoutProps extends WorkoutStateProps, WorkoutDispatchProps {}
