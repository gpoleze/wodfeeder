import {connect} from "react-redux";
import {getWorkoutFormAttributes, listWeekWorkouts} from '../store/workouts/workouts.thunk';
import Workouts from '../pages/workouts/workouts.page';
import {getEditWorkoutsForm, getViewWorkoutsForm, getWorkouts} from "../store/workouts/workouts.selector";

const mapStateToProps = state => ({
    workouts: getWorkouts(state),
    weekForm:{
        view: getViewWorkoutsForm(state),
        edit: getEditWorkoutsForm(state)
    }
});

const mapDispatchToProps = dispatch => ({
    listWeeksWorkouts: weekNumber => dispatch(listWeekWorkouts(weekNumber)),
    getWorkoutFormAttributes: () => dispatch(getWorkoutFormAttributes())
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
