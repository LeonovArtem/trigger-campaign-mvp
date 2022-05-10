import React from 'react';
import {
    ArrayInput,
    BooleanInput,
    FormDataConsumer,
    FormTab,
    NumberInput,
    required,
    SelectInput,
    SimpleFormIterator,
    TabbedForm,
    TextInput,
    useTranslate,
} from 'react-admin';
import { CONDITION_TYPE_COUPON, limitsDefaultValues } from '../../constants';
import {
    Card,
    CardContent,
    Divider,
    InputAdornment,
    Typography,
} from '@mui/material';
import {
    COUPON_TYPE_EXPRESS,
    couponLineTypes,
    couponStatuses,
    couponTypes,
} from '../constants';
import { ACTION_EDIT } from '../../../../constants/appConstants';

const ConditionCouponForm = ({ action }) => {
    const translate = useTranslate();
    return (
        <div>
            <TabbedForm
                defaultValues={{ conditionType: CONDITION_TYPE_COUPON }}
            >
                <FormTab label="resources.conditionCoupon.tabs.params">
                    {action === ACTION_EDIT && (
                        <TextInput source="id" disabled />
                    )}

                    <TextInput
                        label="resources.conditionCoupon.fields.name"
                        source="name"
                        autoFocus
                        fullWidth
                        validate={required()}
                    />
                    <SelectInput
                        label="resources.conditionCoupon.fields.couponStatus"
                        source="params.couponStatus"
                        choices={couponStatuses}
                        defaultValue={''}
                        emptyValue={null}
                        emptyText={'common.fields.emptyText'}
                        className="inputForm"
                        resettable
                    />

                    <SelectInput
                        label="resources.conditionCoupon.fields.couponType"
                        source="params.couponType"
                        choices={couponTypes}
                        defaultValue={''}
                        emptyValue={null}
                        emptyText={'common.fields.emptyText'}
                        className="inputForm"
                        resettable
                        disabled={action === ACTION_EDIT}
                    />
                    <FormDataConsumer fullWidth>
                        {({ formData }) =>
                            formData.params &&
                            formData.params.couponType ===
                                COUPON_TYPE_EXPRESS ? (
                                <Card
                                    sx={{
                                        marginBottom: '20px',
                                        borderRadius: 0,
                                    }}
                                >
                                    <CardContent>
                                        <Typography
                                            variant="h6"
                                            gutterBottom
                                            align="left"
                                        >
                                            {translate(
                                                'resources.conditionCoupon.fields.express.title'
                                            )}
                                        </Typography>
                                        <Divider
                                            sx={{
                                                marginBottom: '5px',
                                            }}
                                        />
                                        <div>
                                            <NumberInput
                                                label="resources.conditionCoupon.fields.express.minCountBet"
                                                source="params.express.minCountBet"
                                                sx={{
                                                    minWidth: '32em',
                                                    marginRight: '1em',
                                                }}
                                            />
                                            <NumberInput
                                                label="resources.conditionCoupon.fields.express.countLoseBet"
                                                source="params.express.countLoseBet"
                                                sx={{
                                                    minWidth: '32em',
                                                    marginRight: '1em',
                                                }}
                                            />
                                            <NumberInput
                                                label="resources.conditionCoupon.fields.express.countWinBet"
                                                source="params.express.countWinBet"
                                                sx={{
                                                    minWidth: '32em',
                                                }}
                                            />
                                        </div>
                                        <NumberInput
                                            label="resources.conditionCoupon.fields.express.minCoefficientBet"
                                            source="params.express.minCoefficientBet"
                                            sx={{
                                                minWidth: '32em',
                                            }}
                                        />
                                    </CardContent>
                                </Card>
                            ) : formData.params ? (
                                (formData.params.express = null)
                            ) : null
                        }
                    </FormDataConsumer>
                    <NumberInput
                        label="resources.conditionCoupon.fields.couponMinCoefficient"
                        source="params.couponMinCoefficient"
                        min={1}
                        step={0.1}
                        className="inputForm"
                        validate={required()}
                    />
                    <SelectInput
                        label="resources.conditionCoupon.fields.couponLineType"
                        source="params.couponLineType"
                        choices={couponLineTypes}
                        defaultValue={''}
                        emptyValue={null}
                        emptyText={'Любой'}
                        className="inputForm"
                        resettable
                    />
                    <BooleanInput
                        label="resources.conditionCoupon.fields.limitPerDay"
                        source="params.limitPerDay"
                    />
                    <BooleanInput
                        label="resources.conditionCoupon.fields.couponIsFirst"
                        source="params.couponIsFirst"
                    />
                </FormTab>
                <FormTab label="resources.conditionCoupon.tabs.limits">
                    <ArrayInput
                        label="resources.conditionCoupon.fields.limits.title"
                        source="params.limits"
                        defaultValue={limitsDefaultValues}
                    >
                        <SimpleFormIterator
                            disableRemove
                            disableAdd
                            disableReordering
                        >
                            <TextInput
                                label="resources.conditionCoupon.fields.limits.currency"
                                source="currency"
                                disabled
                                fullWidth
                                InputProps={{
                                    startAdornment: (
                                        <InputAdornment position="start">
                                            $
                                        </InputAdornment>
                                    ),
                                }}
                            />
                            <TextInput
                                label="resources.conditionCoupon.fields.limits.minAmount"
                                source="minAmount"
                                className="inputForm"
                            />
                            <TextInput
                                label="resources.conditionCoupon.fields.limits.minSumAmount"
                                source="minSumAmount"
                                className="inputForm"
                            />
                        </SimpleFormIterator>
                    </ArrayInput>
                </FormTab>
            </TabbedForm>
        </div>
    );
};

export default ConditionCouponForm;
