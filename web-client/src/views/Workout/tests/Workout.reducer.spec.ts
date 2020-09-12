import { PayloadAction } from "@reduxjs/toolkit";

import { nameChangedReducer, WorkoutInitialState } from "views/Workout/Workout.reducer";
import { WorkoutState } from "views/Workout/Workout.types";

describe("Workout.reducer", () => {
    describe("nameChanged", () => {
        it("should change the workout's name state", () => {
            const newValue = "new value";

            const initialState: WorkoutState = WorkoutInitialState;

            const action: PayloadAction<string> = { payload: newValue, type: "" };

            const newState = nameChangedReducer(initialState, action);

            expect(newState).toEqual({ ...initialState, name: newValue });
        });
    });
});
