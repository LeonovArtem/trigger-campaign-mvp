INSERT INTO trigger_campaign
    (id, name, description, is_published, max_fulfillment_count, user_availability, start_at, end_at, created_at, updated_at)
VALUES (1, 'test_1', null, 1, 10, 'ALL', now(), now() + INTERVAL 90 DAY, now(), now());

INSERT INTO trigger_campaign_condition (id, name, type) VALUES (1, 'Coupon type', 'COUPON');
INSERT INTO condition_param (id, name, value) VALUES (1, 'COUPON_TYPE', '{"value": "ordinar", "paramName": "COUPON_TYPE"}');

INSERT INTO trigger_campaign_condition_params (condition_id, params_id) VALUES (1, 1);
INSERT INTO trigger_campaign_trigger_campaign_condition (trigger_campaign_id, trigger_campaign_condition_id) VALUES (1, 1);
