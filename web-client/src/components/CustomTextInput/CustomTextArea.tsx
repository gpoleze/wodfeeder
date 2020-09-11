import React from "react";

import TextField from "@material-ui/core/TextField";

export interface CustomTextAreaProps {
    id: string;
    label: string;
    value: string;
    onChange: (value: string) => void;
    required?: boolean;
    placeholder?: string;
    rows?: number;
}

const CustomTextArea: React.FC<CustomTextAreaProps> = ({ id, label, value, onChange, required = false, rows = 2 }) => (
    <TextField
        id={id}
        label={label}
        value={value}
        multiline
        rows={rows}
        fullWidth
        variant="outlined"
        required={required}
        onChange={(event): void => onChange(event.target.value)}
    />
);

export default CustomTextArea;
