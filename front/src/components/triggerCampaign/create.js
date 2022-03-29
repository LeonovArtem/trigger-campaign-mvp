import {CLIENT_PLATFORMS, USER_AVAILABILITY} from "./constants";
import {
    Create,
    TabbedForm,
    FormTab,
    TextInput,
    DateTimeInput,
    BooleanInput,
    NumberInput,
    SelectInput,
    FileInput,
    FileField,
    ReferenceInput,
    SelectArrayInput,
    ReferenceArrayInput
} from 'react-admin'
import {makeStyles} from '@material-ui/core/styles';
import {Box} from '@material-ui/core';


export const useStyles = makeStyles(
    {
        leftForm: {
            width: '18em'
        },
        rightForm: {
            width: '18em'
        },
        inputForm: {
            width: '38em'
        },
        fileInputForm: {
            width: '38em',
            high: '38em',
        },
        leftFormGroup: {
            display: 'inline-block'
        },
        rightFormGroup: {
            display: 'inline-block',
            marginLeft: 32
        },
    }
);
export const Separator = () => <Box pt="1em"/>;


export const TriggerCampaignCreate = (props) => {
    const classes = useStyles();
    return (
        <Create title="Создание" {...props}>
            <TabbedForm>
                <FormTab label="Параметры">
                    <TextInput
                        label="Наименование"
                        source="name"
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
                        className={classes.inputForm}
                    />
                    <SelectInput
                        label="Платформы для срабатывания триггера"
                        source="clientPlatforms"
                        choices={CLIENT_PLATFORMS}
                        className={classes.inputForm}
                        resettable
                    />
                    <Separator/>
                    <DateTimeInput
                        label="Дата начала публикации"
                        source="startAt"
                        className={classes.leftForm}
                        formClassName={classes.leftFormGroup}
                    />
                    <DateTimeInput
                        label="Дата окончания публикации"
                        source="endAt"
                        className={classes.rightForm}
                        formClassName={classes.rightFormGroup}
                    />
                    <BooleanInput
                        label="Опубликовать"
                        source="isPublished"
                    />
                </FormTab>

                <FormTab label="Параметры пользователя">
                    <SelectInput
                        label="Доступность пользователям"
                        source="userAvailability"
                        choices={USER_AVAILABILITY}
                        className={classes.inputForm}
                        resettable
                    />
                    <FileInput
                        label="Список пользователей"
                        source="usersFile"
                        accept="application/csv"
                        placeholder={<p>Перетащите файл для загрузки или щелкните, чтобы выбрать его.</p>}
                    >
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
                        source="id" reference="condition-coupon">
                        <SelectInput optionText="name" />
                    </ReferenceArrayInput>
                </FormTab>
                <FormTab label="AB-тест">

                </FormTab>
                <FormTab label="Emarsys">

                </FormTab>
                <FormTab label="Лендинги">

                </FormTab>
            </TabbedForm>
        </Create>
    );

}

export default TriggerCampaignCreate