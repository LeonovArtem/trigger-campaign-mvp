import englishMessages from 'ra-language-english';

export default {
    ...englishMessages,
    app: {
        search: 'Search',
        configuration: 'Configuration',
        language: 'Language',
        theme: {
            name: 'Theme',
            light: 'Light',
            dark: 'Dark',
        },
        menu: {
            campaign: 'Campaign',
            couponConditions: 'On coupon',
            refillConditions: 'On refill',
            userConditions: 'On registration',
        },
    },
    resources: {
        campaign: {
            name: "Campaign"
        },
        conditions: {
            name: "Conditions"
        },
        customers: {
            name: 'Customer |||| Customers',
            fields: {
                commands: 'Orders',
                first_seen: 'First seen',
                groups: 'Segments',
                last_seen: 'Last seen',
                last_seen_gte: 'Visited Since',
                name: 'Name',
                total_spent: 'Total spent',
                password: 'Password',
                confirm_password: 'Confirm password',
            },
            fieldGroups: {
                identity: 'Identity',
                address: 'Address',
                stats: 'Stats',
                history: 'History',
                password: 'Password',
                change_password: 'Change Password',
            },
            page: {
                delete: 'Delete Customer',
            },
            errors: {
                password_mismatch:
                    'The password confirmation is not the same as the password.',
            },
        },
    },
};
