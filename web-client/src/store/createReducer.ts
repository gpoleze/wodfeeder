import { Action } from "redux";

/**
 * S is for the State interface
 * A is for the Action interface
 * T is for Action Type string enum
 */
export type Handler<S, A extends Action = Action, T extends string = string> = {
    [key in T]?: (state: S, action: A) => S;
};

/**
 * S is for the State interface
 * A is for the Action interface
 * T is for Action Type string enum
 */
export const createReducer = <S, A extends Action = Action, T extends string = string>(
    initialState: S,
    handlers: Handler<S, A, T>,
) => {
    return (state: S = initialState, action: A): S => {
        // eslint-disable-next-line no-prototype-builtins
        if (handlers.hasOwnProperty(action.type)) {
            // eslint-disable-next-line @typescript-eslint/ban-ts-comment
            // @ts-ignore
            return handlers[action.type](state, action);
        }

        return state;
    };
};
