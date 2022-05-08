import {Edit,} from 'react-admin';
import CampaignForm from './CampaignForm';
import {ACTION_EDIT} from '../../constants/appConstants';

export const CampaignEdit = props => (
    <Edit title='common.edit' {...props}>
        <CampaignForm action={ACTION_EDIT}/>
    </Edit>
);

export default CampaignEdit;
