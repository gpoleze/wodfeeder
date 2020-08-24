import _debounce from 'lodash/debounce';

const useInputDebounce = (fn, time = 300) => {
    const debouncer = _debounce((argument) => fn(argument), time);

    return (event) => {
        event.persist();
        debouncer(event);
    };
};

export default useInputDebounce;
