import {CLIENT_PLATFORMS, USER_AVAILABILITY} from './constants';
import {
    BooleanInput,
    Create,
    DateTimeInput,
    FileField,
    FileInput,
    FormTab,
    NumberInput,
    ReferenceInput,
    required,
    SelectInput,
    TabbedForm,
    TextInput,
    useTranslate
} from 'react-admin';

const conditionRenderer = condition => {
    if (!condition) return;
    return '[id:' + condition.id + '] ' + condition.name;
};

export const TriggerCampaignCreate = props => {
    const translate = useTranslate();
    return (
        <Create {...props}>
            <TabbedForm
                defaultValues={{
                    conditionsIds: {
                        refills: [],
                        users: [],
                        coupons: [],
                    }
                }}
            >
                <FormTab label='resources.campaign.tabs.params'>
                    <TextInput
                        source='name'
                        autoFocus
                        validate={required()}
                        fullWidth
                    />
                    <TextInput
                        multiline
                        source='description'
                        fullWidth
                    />
                    <NumberInput
                        source='maxFulfillmentCount'
                        className='inputForm'
                    />
                    <SelectInput
                        source='clientPlatforms'
                        choices={CLIENT_PLATFORMS}
                        className='inputForm'
                        resettable
                    />
                    <div>
                        <DateTimeInput
                            source='startAt'
                            validate={required()}
                            sx={{
                                display: 'inline-block',
                                width: '19em',
                            }}

                        />
                        <DateTimeInput
                            source='endAt'
                            validate={required()}
                            sx={{
                                display: 'inline-block',
                                marginLeft: '32px',
                                width: '19em',
                            }}
                        />
                    </div>
                    <BooleanInput source='isPublished' />
                </FormTab>

                <FormTab label='resources.campaign.tabs.userParams'>
                    <SelectInput
                        validate={required()}
                        source='userAvailability'
                        choices={USER_AVAILABILITY}
                        className='inputForm'
                        resettable
                    />
                    <FileInput
                        source='usersFile'
                        accept='application/csv'
                        placeholder={
                            <p>{translate('resources.campaign.hints.fileInput')}</p>
                        }>
                        <FileField source="src" title="title"/>
                    </FileInput>
                    <BooleanInput
                        source='isConfirmationParticipation'
                    />
                </FormTab>
                <FormTab label='resources.campaign.tabs.conditions'>
                    <ReferenceInput
                        source='conditionsIds.coupons'
                        reference="condition-coupon"
                        perPage={5}
                    >
                        <SelectInput
                            label='resources.campaign.fields.conditions.coupon'
                            optionText={conditionRenderer}
                            fullWidth
                        />
                    </ReferenceInput>

                    <ReferenceInput
                        source='conditionsIds.refills'
                        reference='condition-refill'
                        perPage={5}
                    >
                        <SelectInput
                            label='resources.campaign.fields.conditions.refill'
                            optionText={conditionRenderer}
                            fullWidth
                        />
                    </ReferenceInput>

                    <ReferenceInput
                        source='conditionsIds.users'
                        reference='condition-user'
                        perPage={5}
                    >
                        <SelectInput
                            label='resources.campaign.fields.conditions.user'
                            optionText={conditionRenderer}
                            fullWidth
                        />
                    </ReferenceInput>
                </FormTab>
                <FormTab label='resources.campaign.tabs.abTest'></FormTab>
                <FormTab label='resources.campaign.tabs.emailSegments'></FormTab>
                <FormTab label='resources.campaign.tabs.landings'></FormTab>
            </TabbedForm>
        </Create>
    );
};

export default TriggerCampaignCreate;
