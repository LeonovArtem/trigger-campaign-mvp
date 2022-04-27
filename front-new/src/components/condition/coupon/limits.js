import React from 'react';
import {
    Paper,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    Typography,
} from '@mui/material';

const CouponLimitsShow = ({ limits }) => {
    if (!limits) return null;
    return (
        <div>
            <Typography variant="h6" gutterBottom align="left">
                Лимиты по валютам:
            </Typography>
            <Paper elevation={2}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Валюта</TableCell>
                            <TableCell>Минимальная сумма</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {limits.map(limit => (
                            <TableRow key={limit.currency}>
                                <TableCell>{limit.currency}</TableCell>
                                <TableCell>{limit.minAmount}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </Paper>
        </div>
    );
};

export default CouponLimitsShow;
