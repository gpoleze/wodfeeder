import {connect} from "react-redux";
import {addFormChange, getWorkoutFormAttributes, listWeekWorkouts} from '../../store/workouts/workouts.thunk';
import {getEditWorkoutsForm, getViewWorkoutsForm, getWorkouts} from "../../store/workouts/workouts.selector";
import Workouts from './workouts.page';

const mapStateToProps = state => ({
    workouts: getWorkouts(state),
    weekForm: {
        view: getViewWorkoutsForm(state),
        edit: getEditWorkoutsForm(state)
    }
});

const mapDispatchToProps = dispatch => ({
    listWeeksWorkouts: (week,year) => dispatch(listWeekWorkouts(week,year)),
    getWorkoutFormAttributes: () => dispatch(getWorkoutFormAttributes()),
    addFormChange: (fieldName, FieldValue) => dispatch(addFormChange(fieldName, FieldValue))
});

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
