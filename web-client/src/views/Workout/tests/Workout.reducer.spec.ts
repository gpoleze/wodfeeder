import { PayloadAction } from "@reduxjs/toolkit";

import { nameChangedReducer, WorkoutInitialState } from "views/Workout/Workout.reducer";
import { WorkoutState } from "views/Workout/Workout.types";

describe("Workout.reducer", () => {
    describe("nameChanged", () => {
        it.each`
            initialValue | newValue      | expected
            ${""}        | ${"new"}      | ${"new"}
            ${""}        | ${"\tnew"}    | ${"new"}
            ${""}        | ${"  new   "} | ${"new"}
            ${""}        | ${"     "}    | ${""}
            ${"old"}     | ${"new"}      | ${"new"}
            ${"old"}     | ${"  new   "} | ${"new"}
            ${"old"}     | ${"     "}    | ${""}
            ${"old"}     | ${""}         | ${""}
        `(
            "should change the workout's name state from $initialValue to $expected",
            ({ initialValue, newValue, expected }: { initialValue: string; newValue: string; expected: string }) => {
                const initialState: WorkoutState = { ...WorkoutInitialState, name: initialValue };

                const action: PayloadAction<string> = { payload: newValue, type: "" };

                const newState = nameChangedReducer(initialState, action) as WorkoutState;

                expect(newState.name).toBe(expected);
            },
        );
    });
});
