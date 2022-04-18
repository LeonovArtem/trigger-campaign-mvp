import React from 'react';
import {Admin, Resource} from 'react-admin';
import CustomLayout from "./layout/CustomLayout";
import jsonServerProvider from 'ra-data-json-server';
import campaigns from './components/triggerCampaign/'
import conditionsCoupon from './components/condition/coupon'
import conditionsRefill from './components/condition/refill'
import conditionsUser from './components/condition/user'
import polyglotI18nProvider from 'ra-i18n-polyglot';
import ruMessages from './i18n/ru';

const i18nProvider = polyglotI18nProvider(locale => {
    if (locale === 'en') {
        return import('./i18n/en').then(messages => messages.default);
    }

    return ruMessages;
}, 'ru');

function App() {
    return (
        <Admin
            dataProvider={jsonServerProvider(process.env.REACT_APP_DATA_PROVIDER)}
            title="Trigger campaign"
            layout={CustomLayout}
            i18nProvider={i18nProvider}
            disableTelemetry
        >
            <Resource name="campaign" {...campaigns} />
            <Resource name="conditions"
                      options={{label: 'app.menu.conditions', isMenuParent: true}}
            />
            <Resource name="condition-coupon" {...conditionsCoupon}
                      options={{label: 'На купон', menuParent: "conditions"}}
            />
            <Resource name="condition-refill" {...conditionsRefill}
                      options={{label: 'На депозит', menuParent: "conditions"}}
            />
            <Resource name="condition-user" {...conditionsUser}
                      options={{label: 'На регистрацию', menuParent: "conditions"}}
            />
        </Admin>
    );
}

export default App;
