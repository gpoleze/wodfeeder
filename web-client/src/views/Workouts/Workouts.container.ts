import { connect } from "react-redux";
import { ThunkDispatch } from "redux-thunk";

import { IState } from "store/rootReducer";
import { loadWorkouts } from "views/Workouts/Workouts.thunk";
import Workouts from "views/Workouts/Workouts.view";

const mapStateToProps = (state: IState) => ({
    workouts: state.workouts.workouts,
});

const mapDispatchToProps = (dispatch: ThunkDispatch<IState, any, any>) => ({
    loadWorkouts: () => dispatch(loadWorkouts()),
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
