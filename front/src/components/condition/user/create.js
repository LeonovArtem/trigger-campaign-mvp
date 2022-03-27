import {
    Create,
    SimpleForm,
    TextInput,
} from 'react-admin'

export const styles = {
    price: { width: '7em' },
    width: { width: '7em' },
    height: { width: '7em' },
    stock: { width: '7em' },
    widthFormGroup: { display: 'inline-block' },
    heightFormGroup: { display: 'inline-block', marginLeft: 32 },
};

export const limitsDefaultValueValues = [
    { currency: 'RUB', amount: '' },
    { currency: 'USD', amount: '' },
];


export const ConditionUserCreate = (props) => {
    return (
        <Create title="Создание" {...props}>
            <SimpleForm>
                    <TextInput
                        autoFocus
                        source="name"
                        label="Наименование"
                        fullWidth
                    />
                    <TextInput
                        label="Валюта "
                        multiline source="currencies"
                        fullWidth
                    />
                </SimpleForm>
        </Create>
    );

}

export default ConditionUserCreate