import * as React from 'react';
import { Admin, CustomRoutes, Resource } from 'react-admin';
import polyglotI18nProvider from 'ra-i18n-polyglot';
import { Route } from 'react-router';
import jsonServerProvider from 'ra-data-json-server';
import { QueryClient } from 'react-query';
import authProvider from './authProvider';
import { Login, Layout } from './layout';
import ruMessages from './i18n/ru';
import { lightTheme } from './layout/themes';

import campaigns from './components/campaign/';
import conditionsCoupon from './components/condition/coupon';
import conditionsRefill from './components/condition/refill';
import conditionsUser from './components/condition/user';

import Configuration from './configuration/Configuration';

const i18nProvider = polyglotI18nProvider(locale => {
    if (locale === 'en') {
        return import('./i18n/en').then(messages => messages.default);
    }

    // Always fallback on russian
    return ruMessages;
}, 'ru');

const App = () => {
    const restProvider = jsonServerProvider(
        process.env.REACT_APP_DATA_PROVIDER_HOST + '/admin'
    );
    let appCacheInSeconds = 10;
    const queryClient = new QueryClient({
        defaultOptions: {
            queries: {
                staleTime: appCacheInSeconds * 1000, // Set Application Query Cache in 10 sec
            },
        },
    });

    return (
        <Admin
            title=""
            dataProvider={restProvider}
            authProvider={authProvider}
            loginPage={Login}
            layout={Layout}
            i18nProvider={i18nProvider}
            disableTelemetry
            queryClient={queryClient}
            theme={lightTheme}
        >
            <Resource name="campaign" {...campaigns} />
            <Resource name="condition-coupon" {...conditionsCoupon} />
            <Resource name="condition-refill" {...conditionsRefill} />
            <Resource name="condition-user" {...conditionsUser} />
            <CustomRoutes>
                <Route path="/configuration" element={<Configuration />} />
            </CustomRoutes>
        </Admin>
    );
};

export default App;
