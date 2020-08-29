export interface IFormInputChangedPayload {
    field: string;
    value: string;
}

export interface ILoginFormErrors {
    username: string[];
    password: string[];
}

export interface ILoginFormState {
    username: string;
    password: string;
    errors: ILoginFormErrors;
}
