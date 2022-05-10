import green from '@mui/material/colors/green';
import red from '@mui/material/colors/red';
import { Campaign } from '../../types';

const rowStyle = (record: Campaign) => {
    let style = {};
    if (!record) {
        return style;
    }

    if (record.isPublished)
        return {
            ...style,
            borderLeftColor: green[500],
            borderLeftWidth: 5,
            borderLeftStyle: 'solid',
        };

    return {
        ...style,
        borderLeftColor: red[500],
        borderLeftWidth: 5,
        borderLeftStyle: 'solid',
    };
};

export default rowStyle;
