import React from 'react';
import {
    ArrayInput,
    BooleanInput,
    Create,
    FormDataConsumer,
    FormTab,
    NumberInput,
    required,
    SelectInput,
    SimpleFormIterator,
    TabbedForm,
    TextInput,
} from 'react-admin';
import { CONDITION_TYPE_COUPON, limitsDefaultValues } from '../constants';
import { InputAdornment, Typography, Card, CardContent } from '@mui/material';
import {
    couponLineTypes,
    couponStatuses,
    couponTypes,
    COUPON_TYPE_EXPRESS,
} from './constants';

export const ConditionCouponCreate = props => {
    return (
        <Create title="Создание" {...props}>
            <TabbedForm
                initialValues={{ conditionType: CONDITION_TYPE_COUPON }}
            >
                <FormTab label="Параметры">
                    <TextInput
                        label="Наименование"
                        autoFocus
                        source="name"
                        fullWidth
                        validate={required()}
                    />
                    <SelectInput
                        label="Статус купона"
                        source="params.couponStatus"
                        choices={couponStatuses}
                        defaultValue={null}
                        emptyValue={null}
                        emptyText={'Любой'}
                        resettable
                    />

                    <SelectInput
                        label="Тип купона"
                        source="params.couponType"
                        choices={couponTypes}
                        defaultValue={null}
                        emptyValue={null}
                        emptyText={'Любой'}
                        resettable
                    />
                    <FormDataConsumer fullWidth>
                        {({ formData }) =>
                            formData.params &&
                            formData.params.couponType ===
                                COUPON_TYPE_EXPRESS ? (
                                <Card>
                                    <CardContent>
                                        <Typography
                                            variant="h6"
                                            gutterBottom
                                            align="left"
                                            // className={classes.mainColor}
                                        >
                                            Параметры купона с типом "Экспресс"
                                        </Typography>
                                        <hr />
                                        <div>
                                            <NumberInput
                                                label="Минимальное количество ставок"
                                                source="params.express.minCountBet"
                                                // className={classes.expressRow}
                                            />
                                            <NumberInput
                                                label="Количество проигрышных ставок"
                                                source="params.express.countLoseBet"
                                                // className={classes.expressRow}
                                            />
                                            <NumberInput
                                                label="Минимальное количество выигрышных ставок"
                                                source="params.express.countWinBet"
                                                // className={classes.expressRow}
                                            />
                                        </div>
                                        <NumberInput
                                            label="Минимальный коэффициент ставки"
                                            source="params.express.minCoefficientBet"
                                            // className={classes.expressRow}
                                        />
                                    </CardContent>
                                </Card>
                            ) : formData.params ? (
                                (formData.params.express = null)
                            ) : null
                        }
                    </FormDataConsumer>
                    <NumberInput
                        label="Минимальный коэффициент купона"
                        source="params.couponMinCoefficient"
                        min={1}
                        step={0.1}
                        fullWidth
                        validate={required()}
                    />
                    <SelectInput
                        label="Тип линии"
                        source="params.couponLineType"
                        choices={couponLineTypes}
                        defaultValue={null}
                        emptyValue={null}
                        emptyText={'Любой'}
                        resettable
                    />
                    <BooleanInput
                        label="Не более одного купона в день"
                        source="params.limitPerDay"
                    />
                    <BooleanInput
                        label="Первая ставка на спорт"
                        source="params.couponIsFirst"
                    />
                </FormTab>
                <FormTab label="Минимальные лимиты">
                    <ArrayInput
                        label="Лимиты по валютам"
                        source="params.limits"
                        defaultValue={limitsDefaultValues}
                    >
                        <SimpleFormIterator
                            disableRemove
                            disableAdd
                            disableReordering
                        >
                            <TextInput
                                label="Валюта"
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
                                label="Минимальная сумма"
                                source="minAmount"
                            />
                            <TextInput label="Оборот" source="minSumAmount" />
                        </SimpleFormIterator>
                    </ArrayInput>
                </FormTab>
            </TabbedForm>
        </Create>
    );
};

export default ConditionCouponCreate;
