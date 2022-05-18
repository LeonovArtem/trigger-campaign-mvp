import { CLIENT_PLATFORMS, USER_AVAILABILITY } from './constants';
import {
    AutocompleteInput,
    BooleanInput,
    DateTimeInput,
    FileField,
    FileInput,
    FormTab,
    NumberInput,
    ReferenceInput,
    required,
    SelectArrayInput,
    SelectInput,
    TabbedForm,
    TextInput,
    useTranslate,
} from 'react-admin';
import { ACTION_CREATE, ACTION_EDIT } from '../../constants/appConstants';
import React from 'react';

const conditionRenderer = condition => {
    if (!condition) return;
    return '[id:' + condition.id + '] ' + condition.name;
};

export const CampaignForm = ({ action }) => {
    const translate = useTranslate();
    return (
        <>
            <TabbedForm>
                <FormTab label="resources.campaign.tabs.params">
                    {action === ACTION_EDIT && (
                        <TextInput source="id" disabled />
                    )}
                    <TextInput
                        source="name"
                        autoFocus
                        validate={required()}
                        disabled={action === ACTION_EDIT}
                        fullWidth
                    />
                    <TextInput
                        multiline
                        source="description"
                        disabled={action === ACTION_EDIT}
                        fullWidth
                    />
                    <NumberInput
                        source="maxFulfillmentCount"
                        className="inputForm"
                        disabled={action === ACTION_EDIT}
                    />
                    <div>
                        <DateTimeInput
                            source="startAt"
                            variant="outlined"
                            validate={required()}
                            sx={{
                                display: 'inline-block',
                                width: '19em',
                                marginTop: '5px',
                            }}
                        />
                        <DateTimeInput
                            source="endAt"
                            variant="outlined"
                            validate={required()}
                            sx={{
                                display: 'inline-block',
                                marginLeft: '22px',
                                marginTop: '5px',
                                width: '19em',
                            }}
                        />
                    </div>
                    <SelectArrayInput
                        source="clientPlatforms"
                        choices={CLIENT_PLATFORMS}
                        variant="standard"
                        className="inputForm"
                    />
                    <BooleanInput source="isPublished" />
                </FormTab>
                {action === ACTION_CREATE && (
                    <FormTab label="resources.campaign.tabs.userParams">
                        <SelectInput
                            validate={required()}
                            source="userAvailability"
                            choices={USER_AVAILABILITY}
                            className="inputForm"
                            resettable
                        />
                        <FileInput
                            source="usersFile"
                            accept="application/csv"
                            placeholder={
                                <p>
                                    {translate(
                                        'resources.campaign.hints.fileInput'
                                    )}
                                </p>
                            }
                        >
                            <FileField source="src" title="title" />
                        </FileInput>
                        <BooleanInput source="isConfirmationParticipation" />
                    </FormTab>
                )}

                {action === ACTION_CREATE && (
                    <FormTab label="resources.campaign.tabs.conditions">
                        <ReferenceInput
                            source="conditionIds.conditionCouponId"
                            reference="condition-coupon"
                            perPage={5}
                        >
                            <AutocompleteInput
                                label="resources.campaign.fields.conditions.coupon"
                                optionText={conditionRenderer}
                                defaultValue={''}
                                emptyValue={null}
                                className="inputForm"
                            />
                        </ReferenceInput>

                        <ReferenceInput
                            source="conditionIds.conditionRefillId"
                            reference="condition-refill"
                            perPage={5}
                        >
                            <AutocompleteInput
                                label="resources.campaign.fields.conditions.refill"
                                optionText={conditionRenderer}
                                defaultValue={''}
                                emptyValue={null}
                                className="inputForm"
                            />
                        </ReferenceInput>

                        <ReferenceInput
                            source="conditionIds.conditionUserId"
                            reference="condition-user"
                            perPage={5}
                        >
                            <AutocompleteInput
                                label="resources.campaign.fields.conditions.user"
                                optionText={conditionRenderer}
                                defaultValue={''}
                                emptyValue={null}
                                className="inputForm"
                            />
                        </ReferenceInput>
                    </FormTab>
                )}

                {action === ACTION_CREATE && (
                    <FormTab label="resources.campaign.tabs.abTest"></FormTab>
                )}

                {action === ACTION_CREATE && (
                    <FormTab label="resources.campaign.tabs.emailSegments"></FormTab>
                )}

                <FormTab label="resources.campaign.tabs.landings"></FormTab>
            </TabbedForm>
        </>
    );
};

export default CampaignForm;
