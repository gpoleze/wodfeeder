import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { State } from "store/globalStates/type";
import { loadWorkouts } from "views/Workouts/Workouts.thunk";
import Workouts from "views/Workouts/Workouts.view";

const mapStateToProps = (state: State) => ({
    workouts: state.workouts.workouts,
});

const mapDispatchToProps = (dispatch: ThunkDispatch<State, any, any>) => ({
    loadWorkouts: () => dispatch(loadWorkouts()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
