export interface SelectOption<T = any> {
    key: string;
    name: string;
    value: T;
}

export interface CustomNativeSelectProps<T = any> {
    id: string;
    label: string;
    firstOptionText?: string;
    value?: T;
    onChange: (value: T) => void;
    options: SelectOption[];
    required?: boolean;
}
