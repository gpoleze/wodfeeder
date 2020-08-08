import { IState } from "store/rootReducer";
import { loadWorkouts } from "views/Workouts/Workouts.thunk";
import { connect } from "react-redux";
import Workouts from "views/Workouts/Workouts.view";
import { ThunkDispatch } from "redux-thunk";

const mapStateToProps = (state: IState) => ({
    workouts: state.workouts.workouts,
});

const mapDispatchToProps = (dispatch: ThunkDispatch<IState, any, any>) => ({
    loadWorkouts: () => dispatch(loadWorkouts()),
});

export default connect(mapStateToProps,mapDispatchToProps)(Workouts);