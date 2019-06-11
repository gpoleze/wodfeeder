export const getWeek = (date) => {
    if (typeof date !== 'Date')
        throw Error('The parameter must be a Date');

    let janFirst = new Date(date.getFullYear(),0,1);
    return Math.ceil((((date - janFirst) / 86400000) + janFirst.getDay()+1)/7);
};