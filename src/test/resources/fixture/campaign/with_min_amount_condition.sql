INSERT INTO trigger_campaign
(id, name, description, is_published, max_fulfillment_count, user_availability, start_at, end_at, created_at, updated_at)
VALUES (1, 'test_1', null, 1, 10, 'ALL', now(), now() + INTERVAL 90 DAY, now(), now());

INSERT INTO trigger_campaign_condition (id, name, type) VALUES (1, 'Coupon min amount', 'COUPON');
INSERT INTO condition_param (id, name, value) VALUES (1, 'COUPON_MIN_AMOUNT', '{"amount": 200, "paramName": "COUPON_MIN_AMOUNT", "currencyCode": "RUB"}');
INSERT INTO condition_param (id, name, value) VALUES (2, 'COUPON_MIN_AMOUNT', '{"amount": 10, "paramName": "COUPON_MIN_AMOUNT", "currencyCode": "USD"}');

INSERT INTO trigger_campaign_condition_params (condition_id, params_id) VALUES (1, 1);
INSERT INTO trigger_campaign_condition_params (condition_id, params_id) VALUES (1, 2);
INSERT INTO trigger_campaign_trigger_campaign_condition (trigger_campaign_id, trigger_campaign_condition_id) VALUES (1, 1);
