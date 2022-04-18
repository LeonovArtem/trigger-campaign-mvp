import {
    BooleanField,
    BooleanInput,
    Datagrid,
    DateField,
    EditButton,
    Filter,
    List,
    NumberInput,
    ShowButton,
    TextField
} from 'react-admin'

const TriggerCampaignFilter = (props) => (
    <Filter {...props}>
        <NumberInput label='Id' source='id'/>
        <BooleanInput label='Опубликована' source='isPublished'/>
    </Filter>
)

export const TriggerCampaignList = (props) => (
    <List filters={<TriggerCampaignFilter/>} {...props}>
        <Datagrid>
            <TextField source='id'/>
            <TextField label='resources.campaign.fields.name' source='name'/>
            <TextField label='resources.campaign.fields.description' source='description'/>
            <DateField label='resources.campaign.fields.createdAt' source='createdAt'/>
            <DateField label='resources.campaign.fields.startAt' source='startAt'/>
            <DateField label='resources.campaign.fields.endAt' source='endAt'/>
            <BooleanField label='resources.campaign.fields.isPublished' source='isPublished'/>
            <EditButton basePath='/trigger-campaign'/>
            <ShowButton basePath='/trigger-campaign'/>
        </Datagrid>
    </List>
)

export default TriggerCampaignList