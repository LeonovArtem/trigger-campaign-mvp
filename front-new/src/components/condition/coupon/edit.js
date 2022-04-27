import React from 'react';
import {
    ArrayInput,
    BooleanInput,
    Edit,
    FormTab,
    NumberInput,
    required,
    SelectInput,
    SimpleFormIterator,
    TabbedForm,
    TextInput,
} from 'react-admin';
import { CONDITION_TYPE_COUPON, limitsDefaultValues } from '../constants';
import { couponLineTypes, couponStatuses, couponTypes } from './constants';
import { InputAdornment } from '@mui/material';

export const TriggerCampaignCreateEdit = props => (
    <Edit title="Редактирование" {...props}>
        <TabbedForm initialValues={{ conditionType: CONDITION_TYPE_COUPON }}>
            <FormTab label="Параметры">
                <TextInput source="id" disabled />
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
                    resettable
                />
                <SelectInput
                    label="Тип купона"
                    source="params.couponType"
                    choices={couponTypes}
                    disabled
                />
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
    </Edit>
);

export default TriggerCampaignCreateEdit;
