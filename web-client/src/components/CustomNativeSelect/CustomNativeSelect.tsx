import React from "react";

import TextField from "@material-ui/core/TextField";

import { CustomNativeSelectProps } from "components/CustomNativeSelect/CustomNativeSelect.types";

const CustomNativeSelect: React.FC<CustomNativeSelectProps> = ({
    id,
    label,
    defaultValue = "",
    onChange,
    options,
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
        defaultValue={defaultValue}
        fullWidth
        onChange={(event): void => onChange(event.target.value)}
        variant="outlined"
        required={required}
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
