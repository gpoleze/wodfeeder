import React, { ChangeEvent, SyntheticEvent } from "react";

import TextField from "@material-ui/core/TextField";

import useInputDebounce from "utils/hook/useInputDebounce";

export interface CustomTextInputProps {
    id: string;
    label: string;
    defaultValue?: string;
    onChange: (value: string) => void;
    required?: boolean;
    placeholder?: string;
}

const CustomTextInput: React.FC<CustomTextInputProps> = ({
    id,
    label,
    defaultValue,
    onChange,
    required = false,
    placeholder = "",
}) => {
    const onChangeHandler = (event: ChangeEvent<HTMLInputElement>): void => onChange(event.target.value);
    return (
        <TextField
            id={id}
            label={label}
            defaultValue={defaultValue}
            fullWidth
            variant="outlined"
            required={required}
            placeholder={placeholder}
            onChange={useInputDebounce(onChangeHandler)}
        />
    );
};

export default CustomTextInput;
