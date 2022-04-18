import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import {makeStyles} from '@material-ui/core/styles';
import React from "react";
import Typography from "@material-ui/core/Typography";

const useStyles = makeStyles({
    container: {minWidth: '35em'},
    rightAlignedCell: {textAlign: 'right'},
    boldCell: {fontWeight: 'bold'},
    mainColor: {color: '#283593'}
});

const CouponLimitsShow = ({ limits }) => {
    const classes = useStyles();

    if (!limits) return null;
    return (
        <div>
            <Typography className={classes.mainColor} variant="h6" gutterBottom align="left">
                Лимиты по валютам:
            </Typography>
            <Paper className={classes.container} elevation={2}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>
                                Валюта
                            </TableCell>
                            <TableCell className={classes.rightAlignedCell}>
                                Минимальная сумма
                            </TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {limits.map(
                            (limit) =>
                                (
                                    <TableRow key={limit.currency} >
                                        <TableCell className={classes.boldCell}>
                                            {limit.currency}
                                        </TableCell>
                                        <TableCell
                                            className={classes.rightAlignedCell}
                                        >
                                            {limit.minAmount}
                                        </TableCell>
                                    </TableRow>
                                )
                        )}
                    </TableBody>
                </Table>
            </Paper>
        </div>
    )
}

export default CouponLimitsShow