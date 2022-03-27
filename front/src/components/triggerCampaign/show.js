import {USER_AVAILABILITY} from "./constants";
import {
    Show,
    SimpleShowLayout,
    TextField,
    DateField,
    RichTextField,
    BooleanField,
    SelectField,
    NumberField
} from 'react-admin';

export const TriggerCampaignCreateShow = (props) => (
    <Show {...props}>
        <SimpleShowLayout>
            <TextField source="id"/>
            <DateField label="Дата создания" source="createdAt"/>
            <DateField label="Дата изменения" source="updatedAt"/>
            <TextField label="Наименование" source="name"/>
            <RichTextField label="Описание" multiline source="description"/>
            <DateField label="Дата начала публикации" source="startAt"/>
            <DateField label="Дата окончания публикации" source="endAt"/>
            <DateField label="Дата окончания публикации" source="endAt"/>
            <SelectField label="Доступность пользователям" source="userAvailability" choices={USER_AVAILABILITY}/>
            <NumberField label="Количество отработок по триггеру" source="maxFulfillmentCount"/>
            <BooleanField label="Опубликована" source="isPublished" />
        </SimpleShowLayout>
    </Show>
)

export default TriggerCampaignCreateShow