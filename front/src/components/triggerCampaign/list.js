import {
    BooleanField,
    Datagrid,
    DateField,
    EditButton,
    Filter,
    List,
    NumberInput,
    ShowButton,
    TextField
} from 'react-admin';

const TriggerCampaignFilter = (props) => (
    <Filter {...props}>
        <NumberInput label="Id" source="id" />
    </Filter>
);

export const TriggerCampaignList = (props) => (
    <List filters={<TriggerCampaignFilter/>} {...props}>
        <Datagrid>
            <TextField source="id"/>
            <TextField label="Наименование" source="name"/>
            <TextField label="Описание" source="description"/>
            <DateField label="Дата создания" source="createdAt" />
            <DateField label="Дата начала публикации" source="startAt" />
            <DateField label="Дата окончания публикации" source="endAt"/>
            <BooleanField label="Опубликована" source="isPublished"/>
            <EditButton basePath="/trigger-campaign"/>
            <ShowButton basePath="/trigger-campaign"/>

        </Datagrid>
    </List>
)

export default TriggerCampaignList