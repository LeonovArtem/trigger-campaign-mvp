import {USER_AVAILABILITY} from './constants';
import {SelectField, useShowController, useTranslate, BooleanField, ReferenceField, TextField } from 'react-admin';
import {Box, Card, CardContent, Divider, Grid, Typography} from '@mui/material';
import React from 'react';
import ShowRow from '../ShowRow';
import ShowCampaignConditions from "./conditions/ShowCampaignConditions";

export const CampaignShow = (props: any) => {
    const {record} = useShowController(props);
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
                {record.description && <ShowRow label={'resources.campaign.fields.description'} row={record.description}/>}
                <ShowRow
                    label={'resources.campaign.fields.createdAt'}
                    row={new Date(record.createdAt).toLocaleDateString()}
                />
                <div>
                    <span className='showRowTitle'>{translate('resources.campaign.show.isPublished')}</span>
                    <BooleanField source='isPublished' />
                </div>
                <Box height={20}>&nbsp;</Box>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <Typography variant="h6" gutterBottom align="center">
                            {translate('resources.campaign.fields.startAt')}
                        </Typography>
                        <Typography gutterBottom align="center">
                            {new Date(record.startAt).toLocaleDateString()}
                        </Typography>
                    </Grid>

                    <Grid item xs={5}>
                        <Typography variant="h6" gutterBottom align="center">
                            {translate('resources.campaign.fields.endAt')}
                        </Typography>
                        <Typography gutterBottom align="center">
                            {new Date(record.endAt).toLocaleDateString()}
                        </Typography>
                    </Grid>
                </Grid>

                <Divider
                    sx={{
                        marginBottom: '5px'
                    }}
                />
                {record.maxFulfillmentCount && <ShowRow label={'resources.campaign.fields.maxFulfillmentCount'} row={record.maxFulfillmentCount}/>}
                {record.userAvailability && (
                    <div>
                        <span className='showRowTitle'>{translate('resources.campaign.fields.userAvailability')}</span>
                        <SelectField
                            source='userAvailability'
                            choices={USER_AVAILABILITY}
                        />
                    </div>
                )}
                <ShowCampaignConditions record={record.conditions} />
            </CardContent>
        </Card>
    );
};

export default CampaignShow;
