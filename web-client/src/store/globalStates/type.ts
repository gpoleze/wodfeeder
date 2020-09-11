import { IGlobalState } from "store/globalStates/reducer";
import { IAppInitialState } from "views/App/App.reducer";
import { ILoginFormState } from "views/Login/Login.types";
import { WorkoutState } from "views/Workout";
import { IWorkoutsInitialState } from "views/Workouts/Workouts.reducer";

export interface State {
    themeAndSlider: IAppInitialState;
    workouts: IWorkoutsInitialState;
    workout: WorkoutState;
    login: ILoginFormState;
    global: IGlobalState;
}
