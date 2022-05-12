import { Divider, Grid, Typography } from '@mui/material';
import ConditionCouponLimitsShow from './ConditionCouponLimitsShow';
import React from 'react';
import { BooleanField, useTranslate } from 'react-admin';

const ShowRow = ({ label, row }) => {
    const translate = useTranslate();
    return (
        <div>
            <span className="showRowTitle">{translate(label)}</span>
            <span className="showRowParam">{row}</span>
        </div>
    );
};

const ConditionCouponShowForm = ({ condition }) => {
    const translate = useTranslate();
    return (
        <div>
            <Grid container spacing={2}>
                <Grid item xs={6}>
                    <Typography variant="h6" gutterBottom align="left">
                        {condition.name}
                    </Typography>
                </Grid>
                <Grid item xs={5}>
                    <Typography variant="h6" gutterBottom align="right">
                        ID: {condition.id}
                    </Typography>
                </Grid>
            </Grid>
            <Divider
                sx={{
                    marginBottom: '5px',
                }}
            />

            {condition.params.couponMinCoefficient && (
                <ShowRow
                    label={
                        'resources.conditionCoupon.fields.couponMinCoefficient'
                    }
                    row={condition.params.couponMinCoefficient}
                />
            )}

            {condition.params.couponStatus && (
                <ShowRow
                    label={'resources.conditionCoupon.fields.couponStatus'}
                    row={condition.params.couponStatus}
                />
            )}

            {condition.params.couponType && (
                <ShowRow
                    label={'resources.conditionCoupon.fields.couponType'}
                    row={condition.params.couponType}
                />
            )}

            {condition.params.couponIsFirst && (
                <div>
                    <span className="showRowTitle">
                        {translate(
                            'resources.conditionCoupon.fields.couponIsFirst'
                        )}
                    </span>
                    <BooleanField source="params.couponIsFirst" />
                </div>
            )}

            {condition.params.limitPerDay && (
                <div>
                    <span className="showRowTitle">
                        {translate(
                            'resources.conditionCoupon.fields.limitPerDay'
                        )}
                    </span>
                    <BooleanField source="params.limitPerDay" />
                </div>
            )}

            <ConditionCouponLimitsShow limits={condition.params.limits} />
        </div>
    );
};

export default ConditionCouponShowForm;
