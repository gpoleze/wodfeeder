import React from "react";

import TextField from "@material-ui/core/TextField";
import moment from "moment";

export interface CustomNativeSelectProps {
    id: string;
    label: string;
    defaultalue?: string;
    onChange: (value: string) => void;
    value?: string;
    required?: boolean;
}

const CustomNativeDateInput: React.FC<CustomNativeSelectProps> = ({
    id,
    label,
    onChange,
    value = moment().format("yyyy-MM-DD"),
    required = false,
}) => (
    <TextField
        id={id}
        label={label}
        type="date"
        value={value}
        fullWidth
        variant="outlined"
        required={required}
        onChange={(event) => onChange(event.target.value)}
        InputLabelProps={{
            shrink: true,
        }}
    />
);

export default CustomNativeDateInput;
