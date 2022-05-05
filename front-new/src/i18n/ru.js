import ruMessages from 'ra-language-russian';

export default {
    ...ruMessages,
    pos: {
        search: 'Поиск',
        configuration: 'Конфигурация',
        language: 'Язык',
        theme: {
            name: 'Тема',
            light: 'Светлая',
            dark: 'Темная',
        },
        menu: {
            campaign: 'Кампании',
            conditions: 'Условия',
        },
    },
    resources: {
        conditionCoupon: {
            name: 'На купон',
        },
        conditionRefill: {
            name: 'На депозит',
        },
        conditionUser: {
            name: 'На регистрацию',
        },
        categories: {
            name: 'Category |||| Categories',
            fields: {
                products: 'Products',
            },
        },
        campaign: {
            name: 'Кампании |||| Кампании',
            tabs: {
                params: 'Параметры',
                userParams: 'Параметры пользователя',
                conditions: 'Условия',
                abTest: 'AB-тест',
                emailSegments: 'Emarsys',
                landings: 'Лендинги',
            },
            fields: {
                name: 'Наименование',
                description: 'Описание',
                maxFulfillmentCount: 'Количество отработок по триггеру',
                clientPlatforms: 'Платформы для срабатывания триггера',
                startAt: 'Дата начала публикации',
                endAt: 'Дата окончания публикации',
                createdAt: 'Дата создания',
                isPublished: 'Опубликовать',
                userAvailability: 'Доступность пользователям',
                usersFile: 'Список пользователей',
                isConfirmationParticipation: 'Подтверждение участия',
                conditions: {
                    coupon: 'На купон',
                    refill: 'На депозит',
                    user: 'На регистрацию',
                }
            },
            filters: {
                id: 'ID',
                isPublished: 'Опубликована',
            },
            hints: {
                fileInput: 'Перетащите файл для загрузки или щелкните, чтобы выбрать его.',
            },
            action: {
                accept: 'Accept',
                reject: 'Reject',
            },
            notification: {
                approved_success: 'Review approved',
                approved_error: 'Error: Review not approved',
                rejected_success: 'Review rejected',
                rejected_error: 'Error: Review not rejected',
            },
        },
    },
}
