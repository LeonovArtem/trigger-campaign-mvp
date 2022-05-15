import * as React from 'react';
import { Chip, Stack } from '@mui/material';
import { FieldProps, useRecordContext, useTranslate } from 'react-admin';
import { CLIENT_PLATFORMS } from '../constants';
import { Campaign } from '../../../types';

const platformsById = CLIENT_PLATFORMS.reduce((acc, platform) => {
    acc[platform.id] = platform;
    return acc;
}, {} as { [key: string]: any });

const ClientPlatformsShow = (props: FieldProps) => {
    const translate = useTranslate();
    const record = useRecordContext<Campaign>();
    if (!record || !record.clientPlatforms) {
        return null;
    }
    return (
        <div>
            <Stack direction="row" gap={1} flexWrap="wrap">
                <span className="showRowTitle">
                    {translate('resources.campaign.fields.clientPlatforms')}
                </span>
                {record.clientPlatforms.map((id: string | number) => (
                    <Chip
                        key={id}
                        size="small"
                        label={platformsById[id].name}
                    />
                ))}
            </Stack>
        </div>
    );
};

export default ClientPlatformsShow;
