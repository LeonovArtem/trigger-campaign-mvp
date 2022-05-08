import React from 'react';
import {Card, CardContent} from '@mui/material';
import {useShowController} from 'react-admin';
import ConditionCouponShowForm from "./ConditionCouponShowForm";


const ConditionCouponShowForList = (props: any) => {
    const {record} = useShowController(props);

    return (
        <Card className={'showCard'}>
            <CardContent>
                <ConditionCouponShowForm condition={record}/>
            </CardContent>
        </Card>
    )
}

export default ConditionCouponShowForList;
