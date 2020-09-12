export interface WorkoutState {
    name: string;
    date: string;
    type: string;
    scoreType: string;
    description: string;
    observations: string;
}

export interface WorkoutStateProps {
    // workoutType: string;
    // workoutScore: string;
    // workoutDate: string;
    workoutDescription: string;
    workoutName: string;
    // workoutObservations: string;
}

export interface WorkoutDispatchProps {
    // setWorkoutType: (name: string) => void;
    // setWorkoutScore: (name: string) => void;
    // setWorkoutDate: (name: string) => void;
    setWorkoutName: (name: string) => void;
    setWorkoutDescription: (description: string) => void;
    // setWorkoutObservations: (description: string) => void;
}

export interface WorkoutProps extends WorkoutStateProps, WorkoutDispatchProps {}
