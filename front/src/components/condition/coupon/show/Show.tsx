import React from 'react';
import {Show, SimpleShowLayout, useShowController} from 'react-admin';
import ConditionCouponShowForm from "./ConditionCouponShowForm";

const ConditionCouponShow = (props: any) => {
    const {record} = useShowController(props);
    if (!record) return null;

    return (
        <Show sx={{lineHeight: 1.5}}>
            <SimpleShowLayout>
                <ConditionCouponShowForm condition={record}/>
            </SimpleShowLayout>
        </Show>
    )
}

export default ConditionCouponShow;
