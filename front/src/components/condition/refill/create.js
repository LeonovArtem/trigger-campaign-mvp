import {
    Create,
    TabbedForm,
    FormTab,
    TextInput,
    SimpleFormIterator,
    ArrayInput
} from 'react-admin'
import {CONDITION_TYPE_REFILL} from "../constants";

export const styles = {
    price: {width: '7em'},
    width: {width: '7em'},
    height: {width: '7em'},
    stock: {width: '7em'},
    widthFormGroup: {display: 'inline-block'},
    heightFormGroup: {display: 'inline-block', marginLeft: 32},
};

export const limitsDefaultValueValues = [
    {currency: 'RUB', amount: ''},
    {currency: 'USD', amount: ''},
];

export const ConditionRefillCreate = (props) => {
    return (
        <Create title="Создание" {...props}>
            <TabbedForm initialValues={{conditionType: CONDITION_TYPE_REFILL}}>
                <FormTab label="Параметры">
                    <TextInput
                        autoFocus
                        source="name"
                        label="Наименование"
                        fullWidth
                        // validate={required()}
                    />
                    <TextInput
                        multiline source="description"
                        label="Описание"
                        fullWidth
                    />
                </FormTab>
                <FormTab label="Лимиты">
                    <ArrayInput label="Добавить по одному" source="limits" defaultValue={limitsDefaultValueValues}>
                        <SimpleFormIterator disableRemove disableAdd disableReordering>
                            <TextInput source="currency" label="Валюта" disabled/>
                            <TextInput source="amount" label="Минимальная сумма"/>
                        </SimpleFormIterator>
                    </ArrayInput>
                </FormTab>
            </TabbedForm>
        </Create>
    );

}

export default ConditionRefillCreate