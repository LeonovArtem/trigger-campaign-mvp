import React from 'react';
import {Edit,} from 'react-admin';
import ConditionCouponForm from './form';
import {ACTION_EDIT} from '../../../constants/appConstants';

export const TriggerCampaignCreateEdit = props => (
    <Edit title='common.edit' {...props}>
        <ConditionCouponForm action={ACTION_EDIT}/>
    </Edit>
);

export default TriggerCampaignCreateEdit;
