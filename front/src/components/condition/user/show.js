import {
    Show,
    SimpleShowLayout,
    TextField,
    RichTextField,
} from 'react-admin';

export const TriggerCampaignCreateShow = (props) => (
    <Show {...props}>
        <SimpleShowLayout>
            <TextField label="Наименование" source="name"/>
            <RichTextField label="Описание" multiline source="description"/>
        </SimpleShowLayout>
    </Show>
)

export default TriggerCampaignCreateShow