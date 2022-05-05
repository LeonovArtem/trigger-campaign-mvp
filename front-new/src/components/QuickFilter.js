import {useTranslate} from "react-admin";
import { Chip } from '@mui/material';

export const QuickFilter = ({ label }) => {
    const translate = useTranslate();
    return <Chip sx={{ marginBottom: 1 }} label={translate(label)} />;
};

export default QuickFilter;