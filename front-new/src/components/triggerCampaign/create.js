import {CLIENT_PLATFORMS, USER_AVAILABILITY} from './constants';
import {
    AutocompleteArrayInput,
    BooleanInput,
    Create,
    DateTimeInput,
    FileField,
    FileInput,
    FormTab,
    NumberInput,
    ReferenceArrayInput,
    required,
    SelectInput,
    TabbedForm,
    TextInput,
} from 'react-admin';

const conditionRenderer = condition => {
    if (!condition) return;
    return '[id:' + condition.id + '] ' + condition.name;
};

export const TriggerCampaignCreate = props => {
    return (
        <Create title="Создание" {...props}>
            <TabbedForm
                defaultValues={{
                    conditionsIds: {
                        refills: [],
                        users: [],
                        coupons: [],
                    }
            }}
            >
                <FormTab label="Параметры">
                    <TextInput
                        label="Наименование"
                        source="name"
                        autoFocus
                        validate={required()}
                        fullWidth
                    />
                    <TextInput
                        label="Описание"
                        multiline
                        source="description"
                        fullWidth
                    />
                    <NumberInput
                        label="Количество отработок по триггеру"
                        source="maxFulfillmentCount"
                        // className={classes.inputForm}
                    />
                    <SelectInput
                        label="Платформы для срабатывания триггера"
                        source="clientPlatforms"
                        choices={CLIENT_PLATFORMS}
                        // className={classes.inputForm}
                        resettable
                    />
                    <DateTimeInput
                        label="Дата начала публикации"
                        source="startAt"
                        validate={required()}
                        // className={classes.leftForm}
                        // formClassName={classes.leftFormGroup}
                    />
                    <DateTimeInput
                        label="Дата окончания публикации"
                        source="endAt"
                        validate={required()}
                        // className={classes.rightForm}
                        // formClassName={classes.rightFormGroup}
                    />
                    <BooleanInput label="Опубликовать" source="isPublished"/>
                </FormTab>

                <FormTab label="Параметры пользователя">
                    <SelectInput
                        label="Доступность пользователям"
                        validate={required()}
                        source="userAvailability"
                        choices={USER_AVAILABILITY}
                        // className={classes.inputForm}
                        resettable
                    />
                    <FileInput
                        label="Список пользователей"
                        source="usersFile"
                        accept="application/csv"
                        placeholder={
                            <p>
                                Перетащите файл для загрузки или щелкните, чтобы
                                выбрать его.
                            </p>
                        }>
                        <FileField source="src" title="title"/>
                    </FileInput>
                    <BooleanInput
                        label="Подтверждение участия"
                        source="isConfirmationParticipation"
                    />
                </FormTab>
                <FormTab label="Условия">
                    <ReferenceArrayInput
                        label="На купон"
                        source="conditionsIds.coupons"
                        reference="condition-coupon"
                        fullWidth
                    >
                        <AutocompleteArrayInput
                            optionText={conditionRenderer}
                            suggestionLimit={5}
                            fullWidth
                        />
                    </ReferenceArrayInput>

                    <ReferenceArrayInput
                        label="На депозит"
                        source="conditionsIds.refills"
                        reference="condition-refill"
                        fullWidth
                    >
                        <AutocompleteArrayInput
                            optionText={conditionRenderer}
                            suggestionLimit={5}
                            fullWidth
                            name={'test'}
                        />
                    </ReferenceArrayInput>

                    <ReferenceArrayInput
                        label="На регистрацию"
                        source="conditionsIds.users"
                        reference="condition-user"
                        fullWidth
                    >
                        <AutocompleteArrayInput
                            optionText={conditionRenderer}
                            suggestionLimit={5}
                            fullWidth
                        />
                    </ReferenceArrayInput>
                </FormTab>
                <FormTab label="AB-тест"></FormTab>
                <FormTab label="Emarsys"></FormTab>
                <FormTab label="Лендинги"></FormTab>
            </TabbedForm>
        </Create>
    );
};

export default TriggerCampaignCreate;
