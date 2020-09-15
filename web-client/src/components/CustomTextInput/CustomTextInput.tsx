import React from "react";

import TextField from "@material-ui/core/TextField";

export interface CustomTextInputProps {
    id: string;
    label: string;
    value?: string;
    onChange: (value: string) => void;
    required?: boolean;
    placeholder?: string;
}

const CustomTextInput: React.FC<CustomTextInputProps> = ({
    id,
    label,
    value,
    onChange,
    required = false,
    placeholder = "",
}) => (
    <TextField
        id={id}
        label={label}
        value={value}
        fullWidth
        variant="outlined"
        required={required}
        placeholder={placeholder}
        onChange={(e): void => onChange(e.target.value)}
    />
);

export default CustomTextInput;
