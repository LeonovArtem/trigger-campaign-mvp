import React from 'react';
import {
    BooleanField,
    SelectField,
    useShowController,
    useTranslate,
} from 'react-admin';
import {
    Box,
    Card,
    CardContent,
    Divider,
    Grid,
    Typography,
} from '@mui/material';
import CustomRow from '../../CustomRow';
import ShowCampaignConditions from '../conditions/ShowCampaignConditions';
import { USER_AVAILABILITY } from '../constants';
import ClientPlatformsShow from './ClientPlatformsShow';
import CustomDateField from './CustomDateField';

const CampaignShow = (props: any) => {
    const { record } = useShowController(props);
    const translate = useTranslate();

    if (!record) return null;
    return (
        <Card className={'showCard'}>
            <CardContent>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <Typography variant="h6" gutterBottom align="left">
                            {record.name}
                        </Typography>
                    </Grid>
                    <Grid item xs={5}>
                        <Typography variant="h6" gutterBottom align="right">
                            ID: {record.id}
                        </Typography>
                    </Grid>
                </Grid>
                {record.description && (
                    <CustomRow
                        label={'resources.campaign.fields.description'}
                        row={record.description}
                    />
                )}
                <CustomRow
                    label={'resources.campaign.fields.createdAt'}
                    row={new Date(record.createdAt).toLocaleDateString()}
                />
                <div>
                    <span className="showRowTitle">
                        {translate('resources.campaign.show.isPublished')}
                    </span>
                    <BooleanField source="isPublished" />
                </div>
                <Box height={20}>&nbsp;</Box>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <Typography variant="h6" gutterBottom align="center">
                            {translate('resources.campaign.fields.startAt')}
                        </Typography>
                        <Typography gutterBottom align="center">
                            <CustomDateField record={record} source="startAt" />
                        </Typography>
                    </Grid>

                    <Grid item xs={5}>
                        <Typography variant="h6" gutterBottom align="center">
                            {translate('resources.campaign.fields.endAt')}
                        </Typography>
                        <Typography gutterBottom align="center">
                            <CustomDateField record={record} source="endAt" />
                        </Typography>
                    </Grid>
                </Grid>

                <Divider
                    sx={{
                        marginBottom: '5px',
                    }}
                />
                {record.maxFulfillmentCount && (
                    <CustomRow
                        label={'resources.campaign.fields.maxFulfillmentCount'}
                        row={record.maxFulfillmentCount}
                    />
                )}
                {record.userAvailability && (
                    <div>
                        <span className="showRowTitle">
                            {translate(
                                'resources.campaign.fields.userAvailability'
                            )}
                        </span>
                        <SelectField
                            source="userAvailability"
                            choices={USER_AVAILABILITY}
                        />
                    </div>
                )}
                {record.isConfirmationParticipation && (
                    <div>
                        <span className="showRowTitle">
                            {translate(
                                'resources.campaign.fields.isConfirmationParticipation'
                            )}
                        </span>
                        <BooleanField source="isConfirmationParticipation" />
                    </div>
                )}
                {record.clientPlatforms && (
                    <ClientPlatformsShow
                        source="clientPlatforms"
                        label={translate(
                            'resources.campaign.fields.clientPlatforms'
                        )}
                    />
                )}
                <ShowCampaignConditions record={record.conditions} />
            </CardContent>
        </Card>
    );
};

export default CampaignShow;
