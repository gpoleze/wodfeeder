import {connect} from "react-redux";
import {addFormChange, getWorkoutFormAttributes, listWeekWorkouts} from '../../store/workouts/workouts.thunk';
import {
    getTransitionState,
    getWorkoutsForm,
    getWorkouts
} from "../../store/workouts/workouts.selector";
import Workouts from './workouts.page';

const mapStateToProps = state => ({
    workouts: getWorkouts(state),
    weekForm: getWorkoutsForm(state),
    transition: getTransitionState(state)
});

const mapDispatchToProps = dispatch => ({
    listWeeksWorkouts: (week, year) => dispatch(listWeekWorkouts(week, year)),
    getWorkoutFormAttributes: () => dispatch(getWorkoutFormAttributes()),
    addFormChange: (fieldName, FieldValue) => dispatch(addFormChange(fieldName, FieldValue))
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
