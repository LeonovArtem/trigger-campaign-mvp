import React from 'react';
import { Create } from 'react-admin';
import ConditionCouponForm from './show/ConditionCouponForm';
import { ACTION_CREATE } from '../../../constants/appConstants';

export const ConditionCouponCreate = props => {
    return (
        <Create title="resources.conditionCoupon.create" {...props}>
            <ConditionCouponForm action={ACTION_CREATE} />
        </Create>
    );
};

export default ConditionCouponCreate;
