import {
    Edit,
    SimpleForm,
    TextInput,
} from 'react-admin';

export const TriggerCampaignCreateEdit = (props) => (
    <Edit title='Редактирование' {...props}>
        <SimpleForm>
            {/*<TextInput disabled source="id"/>*/}
            <TextInput label="Наименование" multiline source="name"/>
            <TextInput label="Описание" multiline source="description"/>
        </SimpleForm>
    </Edit>
);

export default TriggerCampaignCreateEdit