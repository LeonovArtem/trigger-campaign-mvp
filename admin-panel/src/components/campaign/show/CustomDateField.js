import React from 'react';
import { DateField } from 'react-admin';

const CustomDateField = ({ record, source }) => {
    return (
        <DateField
            label={false}
            source={source}
            record={record}
            variant="body2"
            showTime
            locales="ru"
            options={{
                dateStyle: 'full',
                timeStyle: 'short',
            }}
        />
    );
};

export default CustomDateField;
