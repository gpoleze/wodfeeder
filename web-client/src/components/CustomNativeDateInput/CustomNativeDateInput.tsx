import React, { ChangeEvent } from "react";

import TextField from "@material-ui/core/TextField";
import moment from "moment";

import useInputDebounce from "utils/hook/useInputDebounce";

export interface CustomNativeSelectProps {
    id: string;
    label: string;
    defaultalue?: string;
    onChange: (value: string) => void;
    defaultValue?: string;
    required?: boolean;
}

const CustomNativeDateInput: React.FC<CustomNativeSelectProps> = ({
    id,
    label,
    onChange,
    defaultValue = moment().format("yyyy-MM-DD"),
    required = false,
}) => {
    const changeHandler = (event: ChangeEvent<HTMLInputElement | HTMLInputElement>): void =>
        onChange(event.target.value);
    return (
        <TextField
            id={id}
            label={label}
            type="date"
            defaultValue={defaultValue}
            fullWidth
            variant="outlined"
            required={required}
            onChange={useInputDebounce(changeHandler)}
            InputLabelProps={{
                shrink: true,
            }}
        />
    );
};

export default CustomNativeDateInput;
