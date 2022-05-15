import * as React from 'react';
import { Admin, CustomRoutes, Resource } from 'react-admin';
import polyglotI18nProvider from 'ra-i18n-polyglot';
import { Route } from 'react-router';
import jsonServerProvider from 'ra-data-json-server';
import { QueryClient } from 'react-query';
import authProvider from './authProvider';
import { Login, Layout } from './layout';
import englishMessages from './i18n/en';
import { lightTheme } from './layout/themes';

import campaigns from './components/campaign/';
import conditionsCoupon from './components/condition/coupon';
import conditionsRefill from './components/condition/refill';
import conditionsUser from './components/condition/user';

import Configuration from './configuration/Configuration';

const i18nProvider = polyglotI18nProvider(locale => {
    if (locale === 'ru') {
        return import('./i18n/ru').then(messages => messages.default);
    }

    // Always fallback on english
    return englishMessages;
}, 'en');

const App = () => {
    const restProvider = jsonServerProvider(
        process.env.REACT_APP_DATA_PROVIDER
    );
    let appCacheInMinutes = 1;
    const queryClient = new QueryClient({
        defaultOptions: {
            queries: {
                staleTime: appCacheInMinutes * 60 * 1000, // Set Application Query Cache
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
