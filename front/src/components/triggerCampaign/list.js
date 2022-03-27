import {
    List,
    Datagrid,
    DateField,
    TextField,
    BooleanField,
    EditButton,
    ShowButton,
    Filter,
    TextInput
} from 'react-admin';

const PostFilter = (props) => (
    <Filter {...props}>
        <TextInput label='Поиск' source='q' alwaysOn/>
    </Filter>
);

export const TriggerCampaignList = (props) => (
    <List filters={<PostFilter/>} {...props}>
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