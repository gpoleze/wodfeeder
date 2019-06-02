import React from 'react';
import {shallow} from 'enzyme';

import Header from './Header'
import {findByTestAttrib} from "../../../utils/test-functions";

const setUp = (props = {}) => shallow(<Header {...props}/>);

describe('Header Component', () => {

    let component;
    beforeEach(() => {
        component = setUp();
    });

    it('Should render without errors', function () {
        const wrapper = findByTestAttrib(component, 'headerText');
        expect(wrapper.length).toBe(1);
    });

    it('Should have the header text', () => {
        const wrapper = findByTestAttrib(component, 'headerText');
        expect(wrapper.text()).toMatch('Wod Feeder')
    });
});
