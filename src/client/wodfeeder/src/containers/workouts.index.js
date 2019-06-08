import {connect} from "react-redux";
import {getWorkoutFormAttributes, listWeekWorkouts} from '../store/workouts/workouts.thunk';
import Workouts from '../pages/workouts/workouts.page';

const mapStateToProps = state => ({
    workouts: state.weeksWorkouts,
    weekForm: state.weekFormValues
});

const mapDispatchToProps = dispatch => ({
    listWeeksWorkouts: weekNumber => dispatch(listWeekWorkouts(weekNumber)),
    getWorkoutFormAttributes: () => dispatch(getWorkoutFormAttributes())
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
