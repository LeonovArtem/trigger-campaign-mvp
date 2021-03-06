export const CONDITION_TYPE_COUPON = 'COUPON';
export const CONDITION_TYPE_REFILL = 'REFILL';
export const CONDITION_TYPE_USER = 'USER';
export const CONDITION_TYPE_EVENT = 'EVENT';
export const CONDITION_TYPE_FULFILLMENT = 'CONDITION_FULFILLMENT';

export const CONDITION_TYPES = [
    { id: CONDITION_TYPE_COUPON, name: 'COUPON' },
    { id: CONDITION_TYPE_REFILL, name: 'REFILL' },
    { id: CONDITION_TYPE_USER, name: 'USER' },
    { id: CONDITION_TYPE_FULFILLMENT, name: 'CONDITION_FULFILLMENT' },
    { id: CONDITION_TYPE_EVENT, name: 'EVENT' },
];

export const limitsDefaultValues = [
    { currency: 'RUB' },
    { currency: 'USD' },
    { currency: 'EUR' },
];
