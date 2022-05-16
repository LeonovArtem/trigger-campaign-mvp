import * as React from 'react';
import {
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    Typography,
} from '@mui/material';
import { styled } from '@mui/material/styles';
import { Link, useTranslate } from 'react-admin';
import ConditionParamPreview from './ConditionParamPreview';

const TableCellRight = styled(TableCell)({ textAlign: 'right' });

const ShowCampaignConditions = ({ record }) => {
    const translate = useTranslate();
    const resolveLink = item => {
        return '/condition-' + item.conditionType.toLowerCase() + '/' + item.id;
    };

    if (Array.isArray(record) && record.length !== 0) {
        return (
            <div>
                <Typography variant="h6" gutterBottom align="center">
                    {translate('resources.campaign.conditions')}
                </Typography>

                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>
                                {translate('resources.condition.id')}
                            </TableCell>
                            <TableCell>
                                {translate('resources.condition.name')}
                            </TableCell>
                            <TableCellRight>
                                {translate('resources.condition.type')}
                            </TableCellRight>
                            <TableCellRight></TableCellRight>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {record.map(item => (
                            <TableRow key={item.id}>
                                <TableCell>{item.id}</TableCell>
                                <TableCell>
                                    <Link to={resolveLink(item)}>
                                        {item.name}
                                    </Link>
                                </TableCell>
                                <TableCellRight>
                                    {item.conditionType}
                                </TableCellRight>
                                <TableCellRight>
                                    <ConditionParamPreview
                                        conditionId={item.id}
                                    />
                                </TableCellRight>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </div>
        );
    }

    return <></>;
};

export default ShowCampaignConditions;
