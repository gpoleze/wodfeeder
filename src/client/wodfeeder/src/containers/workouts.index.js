import {connect} from "react-redux";
import {listWeekWorkouts} from '../store/workouts/workouts.thunk';
import Workouts from '../pages/workouts/workouts.page';

const mapStateToProps = state => (
    {
        workouts: state.weeksWorkouts
    }
);

const mapDispatchToProps = dispatch => (
    {
        listWeeksWorkouts: weekNumber => dispatch(listWeekWorkouts(weekNumber))
    }
);

export default connect(mapStateToProps, mapDispatchToProps)(Workouts);
