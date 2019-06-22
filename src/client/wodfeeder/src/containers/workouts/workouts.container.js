import {connect} from "react-redux";
import {getWorkoutFormAttributes, listWeekWorkouts} from '../../store/workouts/workouts.thunk';
import {
    getTransitionState,
    getWorkoutsForm,
    getWorkouts
} from "../../store/workouts/workouts.selector";
import Workouts from './workouts.page';
import {addFormChange} from "../../store/forms/forms.thunk";

const mapStateToProps = state => ({
    workouts: getWorkouts(state),
    workoutsFormValues: getWorkoutsForm(state),
    transition: getTransitionState(state)
});

const mapDispatchToProps = dispatch => ({
    listWeeksWorkouts: (week, year) => dispatch(listWeekWorkouts(week, year)),
    getWorkoutFormAttributes: () => dispatch(getWorkoutFormAttributes()),
    addFormChange: (fieldName, FieldValue) => dispatch(addFormChange('workoutsForm', fieldName, FieldValue))
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
