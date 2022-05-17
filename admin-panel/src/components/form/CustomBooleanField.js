import { useTranslate } from 'react-admin';
import React from 'react';
import { Chip } from '@mui/material';

const CustomBooleanField = ({ label, value }) => {
    const translate = useTranslate();
    const chipValue = value
        ? translate('common.valueLabelTrue')
        : translate('common.valueLabelFalse');
    return (
        <div>
            <span className="showRowTitle">{translate(label)}</span>
            <span className="showRowParam">
                <Chip
                    label={chipValue}
                    color={value ? 'primary' : 'default'}
                    size="small"
                />
            </span>
        </div>
    );
};

export default CustomBooleanField;
