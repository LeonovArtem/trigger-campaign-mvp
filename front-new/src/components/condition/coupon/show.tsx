import React from 'react';
import { Card, CardContent, Grid, Typography } from '@mui/material';
import { useShowController } from 'react-admin';
import CouponLimitsShow from './limits';

export const ConditionCouponShow = (props: any) => {
    const { record } = useShowController(props);
    // const classes = useStyles();

    if (!record) return null;
    return (
        <Card className={'showCard'}>
            <CardContent>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <Typography variant="h6" gutterBottom align="left">
                            {record.name}
                        </Typography>
                    </Grid>
                    <Grid item xs={5}>
                        <Typography variant="h6" gutterBottom align="right">
                            ID: {record.id}
                        </Typography>
                    </Grid>
                </Grid>
                <hr />
                {record.params.couponMinCoefficient && (
                    <div>
                        <b>Минимальный коэффициент купона:</b>{' '}
                        {record.params.couponMinCoefficient}
                    </div>
                )}

                {record.params.couponStatus && (
                    <div>
                        <b>Статус купона:</b> {record.params.couponStatus}
                    </div>
                )}

                {record.params.couponType && (
                    <div>
                        <b>Тип купона:</b> {record.params.couponType}
                    </div>
                )}

                <CouponLimitsShow limits={record.params.limits} />
            </CardContent>
        </Card>
    );
};

export default ConditionCouponShow;

// const useStyles = makeStyles({
//     root: { width: 800, margin: 'auto' },
//     spacer: { height: 20 },
//     limits: { margin: '15px 0' },
//     container: { minWidth: '35em', marginLeft: '0em' },
//     mainColor: { color: '#283593' },
// });
