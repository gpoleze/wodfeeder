import { AxiosResponse } from "axios";
import { Dispatch } from "redux";

import { WorkoutTypeControllerApiFactory, WorkoutTypeVO } from "apiSpecs";
import config from "Constants";

import { typesLoaded } from ".";

const basePath = config.url.API_URL;

export const loadWorkoutsThunk = (): ((dispatch: Dispatch) => void) => {
    const api = WorkoutTypeControllerApiFactory({ basePath });
    const axiosResponse = api.workouts();

    return (dispatch: Dispatch): void => {
        const onSucess = (success: AxiosResponse<WorkoutTypeVO[]>): void => {
            const workoutTypeVOS = success.data;
            dispatch(typesLoaded(workoutTypeVOS));
        };
        const onError = (error: any): void => {
            console.error(error);
            dispatch(typesLoaded([]));
        };

        axiosResponse.then(onSucess, onError);
    };
};
