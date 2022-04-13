import {
    ArrayInput,
    BooleanInput,
    Create,
    FormTab,
    NumberInput,
    required,
    SelectInput,
    SimpleFormIterator,
    TabbedForm,
    TextInput
} from 'react-admin'
import {CONDITION_TYPE_COUPON} from "../constants";
import {InputAdornment} from '@material-ui/core';

export const limitsDefaultValueValues = [
    {currency: 'RUB'},
    {currency: 'USD'},
    {currency: 'EUR'},
];

export const couponStatuses = [
    {id: 'WIN', name: 'Купон выиграл'},
    {id: 'LOSE', name: 'Купон проиграл'},
];

export const couponTypes = [
    {id: 'ORDINAR', name: 'Ординар'},
    {id: 'EXPRESS', name: 'Экспресс'},
    {id: 'SYSTEM', name: 'Система'},
];

export const couponLineTypes = [
    {id: 'LIVE', name: 'LIVE'},
    {id: 'PREGAME', name: 'PREGAME'},
];


export const ConditionCouponCreate = (props) => {
    return (
        <Create title="Создание" {...props}>
            <TabbedForm initialValues={{conditionType: CONDITION_TYPE_COUPON}}>
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
                        resettable
                    />

                    <SelectInput
                        label="Тип купона"
                        source="params.couponType"
                        choices={couponTypes}
                        resettable
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
                        defaultValue={limitsDefaultValueValues}
                    >
                        <SimpleFormIterator disableRemove disableAdd disableReordering>
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
                            <TextInput
                                label="Оборот"
                                source="minSumAmount"
                            />
                        </SimpleFormIterator>
                    </ArrayInput>
                </FormTab>
            </TabbedForm>
        </Create>
    );

}

export default ConditionCouponCreate