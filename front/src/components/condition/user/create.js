import {Create, required, SelectInput, SimpleForm, TextInput,} from 'react-admin'
import {CONDITION_TYPE_USER} from "../constants";
import {BONUS_TYPE_CHOICE} from "./constants";

export const styles = {
    price: {width: '7em'},
    width: {width: '7em'},
    height: {width: '7em'},
    stock: {width: '7em'},
    widthFormGroup: {display: 'inline-block'},
    heightFormGroup: {display: 'inline-block', marginLeft: 32},
};


export const ConditionUserCreate = (props) => {
    return (
        <Create title="Создание" {...props}>
            <SimpleForm initialValues={{conditionType: CONDITION_TYPE_USER}}>
                <TextInput
                    autoFocus
                    source="name"
                    label="Наименование"
                    validate={required()}
                    fullWidth
                />
                <TextInput
                    label="Валюта "
                    multiline source="currencies"
                    fullWidth
                />
                <SelectInput
                    label="Тип выбранного бонуса"
                    source="userAvailableBonus"
                    choices={BONUS_TYPE_CHOICE}
                    resettable
                />
            </SimpleForm>
        </Create>
    );

}

export default ConditionUserCreate