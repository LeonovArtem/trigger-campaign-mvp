import {
    BooleanField,
    Datagrid,
    DateField,
    EditButton,
    Filter,
    List,
    NumberInput,
    TextField,
    TextInput,
} from 'react-admin';
import QuickFilter from '../QuickFilter';
import TriggerCampaignCreateShow from './show/CampaignShow';
import rowStyle from './rowStyle';

const CampaignFilters = props => (
    <Filter {...props}>
        <NumberInput label="Id" source="id" />
        <TextInput source="name" resettable />
        <QuickFilter
            source="isPublished"
            label="resources.campaign.filters.isPublished"
            defaultValue={true}
        />
    </Filter>
);

export const CampaignList = props => (
    <List
        sort={{ field: 'id', order: 'DESC' }}
        filters={<CampaignFilters />}
        {...props}
    >
        <Datagrid
            optimized
            expand={<TriggerCampaignCreateShow />}
            rowStyle={rowStyle}
        >
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="description" />
            <DateField source="createdAt" />
            <DateField source="startAt" />
            <DateField source="endAt" />
            <BooleanField
                source="isPublished"
                label="resources.campaign.filters.isPublished"
            />
            <EditButton />
        </Datagrid>
    </List>
);

export default CampaignList;
