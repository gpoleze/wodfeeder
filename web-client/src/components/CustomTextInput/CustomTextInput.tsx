import React from "react";

import TextField from "@material-ui/core/TextField";

export interface CustomTextInputProps {
    id: string;
    label: string;
    value: string;
    onChange: (value: string) => void;
    defaultValue?: string;
    required?: boolean;
}

const CustomTextInput: React.FC<CustomTextInputProps> = ({
    id,
    label,
    value,
    onChange,
    defaultValue = "",
    required = false,
}) => (
    <TextField
        id={id}
        label={label}
        value={value || defaultValue}
        fullWidth
        variant="outlined"
        required={required}
        defaultValue={defaultValue}
        onChange={(event): void => onChange(event.target.value)}
    />
);

export default CustomTextInput;
