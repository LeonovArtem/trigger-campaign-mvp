import { useTranslate } from 'react-admin';
import React from 'react';

const CustomRow = ({ label, row }) => {
    const translate = useTranslate();
    return (
        <div>
            <span className="showRowTitle">{translate(label)}</span>
            <span className="showRowParam">{row}</span>
        </div>
    );
};

export default CustomRow;
