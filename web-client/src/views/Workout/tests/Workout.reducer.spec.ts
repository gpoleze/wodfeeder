import { PayloadAction } from "@reduxjs/toolkit";

import {
    descriptionChangedReducer,
    nameChangedReducer,
    observationsChangedReducer,
    WorkoutInitialState,
} from "views/Workout/Workout.reducer";
import { WorkoutState } from "views/Workout/Workout.types";

describe("Workout.reducer - nameChanged", () => {
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
describe("Workout.reducer - descriptionChanged", () => {
    it.each`
        initialValue        | newValue                         | expected
        ${""}               | ${"new"}                         | ${"new"}
        ${""}               | ${"\tnew"}                       | ${"new"}
        ${""}               | ${"\tnew\n"}                     | ${"new"}
        ${""}               | ${"  new   "}                    | ${"new"}
        ${""}               | ${"     "}                       | ${""}
        ${""}               | ${"\tline 1\nline 2"}            | ${"line 1\nline 2"}
        ${""}               | ${"\tline 1\nline 2\n"}          | ${"line 1\nline 2"}
        ${""}               | ${"   line 1\nline 2   "}        | ${"line 1\nline 2"}
        ${"line 1\nline 2"} | ${"   line 1\nline 2\nline3   "} | ${"line 1\nline 2\nline3"}
        ${"line 1\nline 2"} | ${"   line 1\n   "}              | ${"line 1"}
        ${"line 1\nline 2"} | ${"  "}                          | ${""}
        ${"old"}            | ${"new"}                         | ${"new"}
        ${"old"}            | ${"  new   "}                    | ${"new"}
        ${"old"}            | ${"     "}                       | ${""}
        ${"old"}            | ${""}                            | ${""}
    `(
        "should change the workout's name state from $initialValue to $expected",
        ({ initialValue, newValue, expected }: { initialValue: string; newValue: string; expected: string }) => {
            const initialState: WorkoutState = { ...WorkoutInitialState, description: initialValue };

            const action: PayloadAction<string> = { payload: newValue, type: "" };

            const newState = descriptionChangedReducer(initialState, action) as WorkoutState;

            expect(newState.description).toBe(expected);
        },
    );
});

describe("Workout.reducer - observationChanged", () => {
    it.each`
        initialValue        | newValue                         | expected
        ${""}               | ${"new"}                         | ${"new"}
        ${""}               | ${"\tnew"}                       | ${"new"}
        ${""}               | ${"\tnew\n"}                     | ${"new"}
        ${""}               | ${"  new   "}                    | ${"new"}
        ${""}               | ${"     "}                       | ${""}
        ${""}               | ${"\tline 1\nline 2"}            | ${"line 1\nline 2"}
        ${""}               | ${"\tline 1\nline 2\n"}          | ${"line 1\nline 2"}
        ${""}               | ${"   line 1\nline 2   "}        | ${"line 1\nline 2"}
        ${"line 1\nline 2"} | ${"   line 1\nline 2\nline3   "} | ${"line 1\nline 2\nline3"}
        ${"line 1\nline 2"} | ${"   line 1\n   "}              | ${"line 1"}
        ${"line 1\nline 2"} | ${"  "}                          | ${""}
        ${"old"}            | ${"new"}                         | ${"new"}
        ${"old"}            | ${"  new   "}                    | ${"new"}
        ${"old"}            | ${"     "}                       | ${""}
        ${"old"}            | ${""}                            | ${""}
    `(
        "should change the workout's name state from $initialValue to $expected",
        ({ initialValue, newValue, expected }: { initialValue: string; newValue: string; expected: string }) => {
            const initialState: WorkoutState = { ...WorkoutInitialState, observations: initialValue };

            const action: PayloadAction<string> = { payload: newValue, type: "" };

            const newState = observationsChangedReducer(initialState, action) as WorkoutState;

            expect(newState.observations).toBe(expected);
        },
    );
});
