import {
    BooleanField,
    Datagrid,
    DateField,
    EditButton,
    Filter,
    List,
    NumberInput,
    ShowButton,
    TextField,
} from 'react-admin';
import { QuickFilter } from '../QuickFilter';

const CampaignFilters = (props) => (
    <Filter {...props}>
        <NumberInput label='Id' source="id"/>
        <QuickFilter source='isPublished' label='resources.campaign.filters.isPublished' defaultValue={true}/>
    </Filter>
);

export const TriggerCampaignList = props => (
    <List filters={<CampaignFilters/>} {...props}>
        <Datagrid>
            <TextField source='id' />
            <TextField source='name' />
            <TextField source='description' />
            <DateField source='createdAt' />
            <DateField source='startAt' />
            <DateField source='endAt' />
            <BooleanField source='isPublished' />
            <EditButton/>
            <ShowButton/>
        </Datagrid>
    </List>
);

export default TriggerCampaignList;
