import React from 'react';
import { Edit } from 'react-admin';
import ConditionCouponForm from './ConditionCouponForm';
import { ACTION_EDIT } from '../../../constants/appConstants';

export const ConditionCouponEdit = props => (
    <Edit title="common.edit" {...props}>
        <ConditionCouponForm action={ACTION_EDIT} />
    </Edit>
);

export default ConditionCouponEdit;
