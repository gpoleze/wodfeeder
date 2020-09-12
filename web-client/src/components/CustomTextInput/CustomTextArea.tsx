import React from "react";

import TextField from "@material-ui/core/TextField";

import useInputDebounce from "utils/hook/useInputDebounce";

export interface CustomTextAreaProps {
    id: string;
    label: string;
    defaultValue: string;
    onChange: (value: string) => void;
    required?: boolean;
    placeholder?: string;
    rows?: number;
}

const CustomTextArea: React.FC<CustomTextAreaProps> = ({
    id,
    label,
    defaultValue,
    onChange,
    required = false,
    rows = 2,
}) => {
    const handleChange = (event: React.ChangeEvent<HTMLTextAreaElement>): void => onChange(event.target.value);
    return (
        <TextField
            id={id}
            label={label}
            defaultValue={defaultValue}
            multiline
            rows={rows}
            fullWidth
            variant="outlined"
            required={required}
            onChange={useInputDebounce(handleChange)}
        />
    );
};

export default CustomTextArea;
