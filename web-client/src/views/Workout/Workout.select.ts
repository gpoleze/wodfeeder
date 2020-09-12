import { State } from "store/globalStates/type";

export const selectWorkoutName = (state: State): string => state.workout.name;
export const selectWorkoutDescription = (state: State): string => state.workout.description;
export const selectWorkoutNotes = (state: State): string => state.workout.notes;
export const selectWorkoutDate = (state: State): string => state.workout.date;
