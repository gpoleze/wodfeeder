import { State } from "store/globalStates/type";

export const selectWorkoutName = (state: State): string => state.workout.name;
