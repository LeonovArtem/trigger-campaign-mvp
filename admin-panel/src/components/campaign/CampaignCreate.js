import { Create } from 'react-admin';
import CampaignForm from './CampaignForm';
import { ACTION_CREATE } from '../../constants/appConstants';

export const CampaignCreate = props => {
    return (
        <Create title="common.create" {...props}>
            <CampaignForm action={ACTION_CREATE} />
        </Create>
    );
};

export default CampaignCreate;
