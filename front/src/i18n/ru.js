import ruMessages from 'ra-language-russian';

export default {
    ...ruMessages,
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
            campaign: 'Кампании',
            conditions: 'Условия',
            couponConditions: 'На купон',
            refillConditions: 'На депозит',
            userConditions: 'На регистрацию',
        },
    },
    resources: {
        campaign: {
            name: "Кампании",
            fields: {
                name: 'Имя',
                description: 'Описание',
                createdAt: 'Дата создания',
                startAt: 'Дата начала публикации',
                endAt: 'Дата окончания публикации',
                isPublished: 'Опубликована'
            }
        },
        conditions: {
            name: 'Условия',
        },
        conditionCoupon: {
            fields: {
                name: 'Имя'
            }
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
