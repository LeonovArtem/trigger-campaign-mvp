import * as React from 'react';
import { useState } from 'react';
import IconImageEye from '@mui/icons-material/Visibility';
import IconKeyboardArrowRight from '@mui/icons-material/KeyboardArrowRight';
import { SimpleShowLayout, useGetOne, useTranslate } from 'react-admin';

import { Button, Drawer } from '@mui/material';
import ConditionCouponShowForm from '../../condition/coupon/show/ConditionCouponShowForm';

const ConditionParamPreview = ({ conditionId }) => {
    const translate = useTranslate();
    const { data, isLoading, error } = useGetOne('condition-coupon', {
        id: conditionId,
    });
    const [showPanel, setShowPanel] = useState(false);

    if (isLoading) {
        return <p>Loading</p>;
    }
    if (error) {
        return <p>ERROR</p>;
    }

    const handleClick = () => {
        setShowPanel(true);
    };

    const handleCloseClick = () => {
        setShowPanel(false);
    };

    return (
        <div>
            <Button onClick={handleClick} startIcon={<IconImageEye />}>
                {translate('resources.campaign.showConditionParams')}
            </Button>
            <Drawer anchor="right" open={showPanel} onClose={handleCloseClick}>
                <div>
                    <Button label="Close" onClick={handleCloseClick}>
                        <IconKeyboardArrowRight />
                        {translate('resources.campaign.showConditionParams')}
                    </Button>
                </div>
                <SimpleShowLayout sx={{ lineHeight: 1.5 }}>
                    <ConditionCouponShowForm condition={data} />
                </SimpleShowLayout>
            </Drawer>
        </div>
    );
};

export default ConditionParamPreview;
