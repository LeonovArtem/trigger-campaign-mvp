import {
    FormTab,
    TextInput
} from 'react-admin';

const CurrencyLimitsFormTab = () => {
    return (
        <FormTab label="Лимиты" source="limits">
            <TextInput
                autoFocus
                source="limits.RUB"
                label="RUB"
                fullWidth
            />
            <TextInput
                source="limits.USD"
                label="USD"
                fullWidth
            />
        </FormTab>
    );
};

export default CurrencyLimitsFormTab;