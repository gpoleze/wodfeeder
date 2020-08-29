import { SyntheticEvent } from "react";

import _debounce from "lodash/debounce";

const useInputDebounce = <T = Element, E = Event>(
    // eslint-disable-next-line @typescript-eslint/ban-types
    fn: Function,
    time = 300,
): ((event: SyntheticEvent<T, E>) => void) => {
    const debouncer = _debounce((argument) => fn(argument), time);

    return (event: SyntheticEvent<T, E>): void => {
        event.persist();
        debouncer(event);
    };
};

export default useInputDebounce;
