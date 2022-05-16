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
    common: {
        fields: {
            emptyText: 'Любой',
        },
        edit: 'Редактирование',
        create: 'Создать',
    },
    resources: {
        condition: {
            id: 'ID',
            name: 'Название',
            type: 'Тип',
        },
        conditionCoupon: {
            name: 'На купон',
            create: 'Создать условие на купон',
            tabs: {
                params: 'Параметры',
                limits: 'Минимальные лимиты',
            },
            fields: {
                name: 'Наименование',
                couponStatus: 'Статус купона',
                couponType: 'Тип купона',
                express: {
                    title: 'Параметры купона с типом "Экспресс"',
                    minCountBet: 'Минимальное количество ставок',
                    countLoseBet: 'Количество проигрышных ставок',
                    countWinBet: 'Минимальное количество выигрышных ставок',
                    minCoefficientBet: 'Минимальный коэффициент ставки',
                },
                couponMinCoefficient: 'Минимальный коэффициент купона',
                couponLineType: 'Тип линии',
                limitPerDay: 'Не более одного купона в день',
                couponIsFirst: 'Первая ставка на спорт',
                limits: {
                    title: 'Лимиты по валютам',
                    currency: 'Валюта',
                    minAmount: 'Минимальная сумма',
                    minSumAmount: 'Оборот',
                },
            },
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
            conditions: 'Условия',
            showConditionParams: 'Параметры',
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
                },
            },
            show: {
                isPublished: 'Опубликована',
            },
            filters: {
                id: 'ID',
                isPublished: 'Опубликована',
            },
            hints: {
                fileInput:
                    'Перетащите файл для загрузки или щелкните, чтобы выбрать его.',
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
};
