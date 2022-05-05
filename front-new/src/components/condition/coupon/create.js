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
import { InputAdornment, Typography, Card, CardContent, Divider } from '@mui/material';
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
                defaultValues={{ conditionType: CONDITION_TYPE_COUPON }}
            >
                <FormTab label="Параметры">
                    <TextInput
                        label="Наименование"
                        source="name"
                        autoFocus
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
                        className='inputForm'
                        resettable
                    />

                    <SelectInput
                        label="Тип купона"
                        source="params.couponType"
                        choices={couponTypes}
                        defaultValue={null}
                        emptyValue={null}
                        emptyText={'Любой'}
                        className='inputForm'
                        resettable
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
                                            Параметры купона с типом "Экспресс"
                                        </Typography>
                                        <Divider
                                            sx={{
                                                marginBottom: '5px'
                                            }}
                                        />
                                        <div>
                                            <NumberInput
                                                label="Минимальное количество ставок"
                                                source="params.express.minCountBet"
                                                sx={{
                                                    minWidth: '32em', marginRight: '1em'
                                                }}
                                            />
                                            <NumberInput
                                                label="Количество проигрышных ставок"
                                                source="params.express.countLoseBet"
                                                sx={{
                                                    minWidth: '32em', marginRight: '1em'
                                                }}
                                            />
                                            <NumberInput
                                                label="Минимальное количество выигрышных ставок"
                                                source="params.express.countWinBet"
                                                sx={{
                                                    minWidth: '32em'
                                                }}
                                            />
                                        </div>
                                        <NumberInput
                                            label="Минимальный коэффициент ставки"
                                            source="params.express.minCoefficientBet"
                                            sx={{
                                                minWidth: '32em'
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
                        label="Минимальный коэффициент купона"
                        source="params.couponMinCoefficient"
                        min={1}
                        step={0.1}
                        className='inputForm'
                        validate={required()}
                    />
                    <SelectInput
                        label="Тип линии"
                        source="params.couponLineType"
                        choices={couponLineTypes}
                        defaultValue={null}
                        emptyValue={null}
                        emptyText={'Любой'}
                        className='inputForm'
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
                                className='inputForm'
                            />
                            <TextInput
                                label="Оборот"
                                source="minSumAmount"
                                className='inputForm'
                            />
                        </SimpleFormIterator>
                    </ArrayInput>
                </FormTab>
            </TabbedForm>
        </Create>
    );
};

export default ConditionCouponCreate;
