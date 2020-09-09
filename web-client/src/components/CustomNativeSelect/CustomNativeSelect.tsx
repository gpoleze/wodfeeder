import React from "react";

import TextField from "@material-ui/core/TextField";

export interface CustomNativeSelectProps<T = any> {
    id: string;
    label: string;
    firstOptionText?: string;
    value: T;
    onChange: (value: T) => void;
    defaultValue?: string;
    options: { key: string; name: string; value: T }[];
    required?: boolean;
}

const CustomNativeSelect: React.FC<CustomNativeSelectProps> = ({
    id,
    label,
    value,
    onChange,
    options,
    defaultValue = "",
    firstOptionText = "",
    required = false,
}) => (
    <TextField
        id={id}
        label={label}
        SelectProps={{
            native: true,
        }}
        select
        value={value}
        fullWidth
        onChange={(event): void => onChange(event.target.value)}
        variant="outlined"
        required={required}
        defaultValue={defaultValue}
    >
        <option disabled>{firstOptionText}</option>
        {options.map((item) => (
            <option key={item.key} value={item.value}>
                {item.name}
            </option>
        ))}
    </TextField>
);

export default CustomNativeSelect;
