import {BooleanInput, DateTimeInput, Edit, NumberInput, SelectInput, SimpleForm, TextInput} from 'react-admin';
import {USER_AVAILABILITY} from "./constants";

export const TriggerCampaignCreateEdit = (props) => (
    <Edit title='Редактирование' {...props}>
        <SimpleForm>
            <TextInput disabled source="id"/>
            <TextInput label="Наименование" multiline source="name"/>
            <TextInput label="Описание" multiline source="description"/>
            <DateTimeInput label="Дата начала публикации" disabled source="startAt"/>
            <DateTimeInput label="Дата окончания публикации" source="endAt"/>
            <NumberInput label="Количество отработок по триггеру" disabled source="maxFulfillmentCount"/>
            <SelectInput label="Доступность пользователям" disabled source="userAvailability" choices={USER_AVAILABILITY}/>
            <BooleanInput label="Опубликовать" source="isPublished"/>
        </SimpleForm>
    </Edit>
);

export default TriggerCampaignCreateEdit