export class InputVO {
    _id;
    _label;
    _ariaHelperText;
    _name;
    _value;
    _type;
    _changeHandler;

    constructor(
        id,
        label,
        name,
        changeHandler,
        type = 'text',
        value = '',
        ariaHelperText = this._label,
    ) {
        this._id = id;
        this._label = label;
        this._ariaHelperText = ariaHelperText;
        this._name = name;
        this._value = value;
        this._type = type;
        this._changeHandler = changeHandler;
    }


    get id() {
        return this._id;
    }

    get label() {
        return this._label;
    }

    get ariaHelperText() {
        return this._ariaHelperText;
    }

    get name() {
        return this._name;
    }

    get value() {
        return this._value;
    }

    get type() {
        return this._type;
    }

    get changeHandler() {
        return this._changeHandler;
    }

    static copy(other, changes = {}) {
        return new InputVO(
            typeof changes.id !== 'undefined' ? changes.id : other.id,
            typeof changes.label !== 'undefined' ? changes.label : other.label,
            typeof changes.name !== 'undefined' ? changes.name : other.name,
            typeof changes.changeHandler !== 'undefined' ? changes.changeHandler : other.changeHandler,
            typeof changes.type !== 'undefined' ? changes.type : other.type,
            typeof changes.value !== 'undefined' ? changes.value : other.value,
            typeof changes.ariaHelperText !== 'undefined' ? changes.ariaHelperText : other.ariaHelperText
        );
    }
}