import React from 'react';
import {shallow} from 'enzyme';

import WorkoutTable from './workout-table.index'
import {findByTestAttrib} from "../../utils/test-functions";

const setUp = (props={}) => shallow(<WorkoutTable {...props}/>);

describe("WorkoutTable Component", () => {
    describe('Have Props', () => {

        let wrapper;
        beforeEach(() => {
            const props = {
                workouts: [
                    {
                        id: '1',
                        date: '2018-01-01',
                        exercises: 'Test Text 1'
                    },
                    {
                        id: '2',
                        date: '2018-01-02',
                        exercises: 'Test Text 2'
                    }
                ]
            };
            wrapper = setUp(props);
        });

        it('Should render with no error', () => {
            const component = findByTestAttrib(wrapper, 'table');
            expect(component.length).toBe(1);
        });

        it('Should render two rows', () => {
            const rows = findByTestAttrib(wrapper, 'row');
            expect(rows.length).toBe(2);
        });

        it('Should render two date.js cells', () => {
            const dataCells = findByTestAttrib(wrapper, 'date');
            expect(dataCells.length).toBe(2);
            expect(dataCells.map(cell => cell.text())).toEqual(['2018-01-01', '2018-01-02']);

        });

        it('Should render two exercise cells', () => {
            const exerciseCells = findByTestAttrib(wrapper, 'exercise');
            expect(exerciseCells.length).toBe(2);
            expect(exerciseCells.map(cell => cell.text())).toEqual(['Test Text 1', 'Test Text 2']);
        });


    });
    describe('Have NO Props', () => {
        let wrapper;
        beforeEach(() => {
            wrapper = setUp();
        });

        it('Should not render', () => {
            const component = findByTestAttrib(wrapper, 'table');
            expect(component.length).toBe(0);
        });

    });
});