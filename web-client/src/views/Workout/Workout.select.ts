import { WorkoutScoringVO, WorkoutTypeVO } from "apiSpecs";
import { State } from "store/globalStates/type";

export const selectWorkoutName = (state: State): string => state.workout.name;
export const selectWorkoutDescription = (state: State): string => state.workout.description;
export const selectWorkoutNotes = (state: State): string => state.workout.notes;
export const selectWorkoutDate = (state: State): string => state.workout.date;
export const selectWorkoutTypes = (state: State): WorkoutTypeVO[] => state.workout.types;
export const selectWorkoutScorings = (state: State): WorkoutScoringVO[] => state.workout.scorings;
export const selectWorkoutScoring = (state: State): string => state.workout.scoring;
export const selectWorkoutType = (state: State): string => state.workout.type;
