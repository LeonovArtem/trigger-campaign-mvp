drop table if exists condition_param;
drop table if exists trigger_campaign;
drop table if exists trigger_campaign_condition;
drop table if exists trigger_campaign_condition_fulfillment;
drop table if exists trigger_campaign_condition_params;
drop table if exists trigger_campaign_fulfillment;
drop table if exists trigger_campaign_trigger_campaign_condition;
drop table if exists trigger_campaign_user;
drop table if exists trigger_campaign_user_blacklist;

create table condition_param
(
    id    integer      not null auto_increment,
    name  varchar(255) not null,
    value json,
    primary key (id)
) engine = InnoDB;

create table trigger_campaign
(
    id                    integer      not null auto_increment,
    name                  varchar(255) not null,
    description           varchar(255),
    is_published          BOOLEAN      not null,
    max_fulfillment_count integer,
    user_availability     varchar(255) not null,
    start_at              datetime(6)  not null,
    end_at                datetime(6)  not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    primary key (id)
) engine = InnoDB;

create table trigger_campaign_condition
(
    id   integer      not null auto_increment,
    name varchar(255) not null,
    type varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table trigger_campaign_condition_fulfillment
(
    id                  integer     not null auto_increment,
    user_id             integer,
    condition_id        integer,
    fulfillment_id      integer,
    trigger_campaign_id integer,
    created_at timestamp default current_timestamp,
    primary key (id)
) engine = InnoDB;

create table trigger_campaign_condition_params
(
    condition_id integer not null,
    params_id    integer not null,
    primary key (condition_id, params_id)
) engine = InnoDB;

create table trigger_campaign_fulfillment
(
    id                  integer     not null auto_increment,
    user_id             integer,
    trigger_campaign_id integer,
    created_at timestamp default current_timestamp,
    primary key (id)
) engine = InnoDB;

create table trigger_campaign_trigger_campaign_condition
(
    trigger_campaign_id           integer not null,
    trigger_campaign_condition_id integer not null,
    primary key (trigger_campaign_id, trigger_campaign_condition_id)
) engine = InnoDB;

create table trigger_campaign_user
(
    trigger_campaign_id integer not null,
    user_id             integer
) engine = InnoDB;

create table trigger_campaign_user_blacklist
(
    trigger_campaign_id integer not null,
    user_id             integer
) engine = InnoDB;

alter table trigger_campaign_condition_fulfillment
    add constraint fk__condition_fulfillment__condition foreign key (condition_id) references trigger_campaign_condition (id);

alter table trigger_campaign_condition_fulfillment
    add constraint fk__condition_fulfillment__fulfillment foreign key (fulfillment_id) references trigger_campaign_fulfillment (id);

alter table trigger_campaign_condition_fulfillment
    add constraint fk__condition_fulfillment__trigger_campaign foreign key (trigger_campaign_id) references trigger_campaign (id);

alter table trigger_campaign_condition_params
    add constraint fk__condition_params__condition_param foreign key (params_id) references condition_param (id);

alter table trigger_campaign_condition_params
    add constraint fk__condition_params__condition foreign key (condition_id) references trigger_campaign_condition (id);

alter table trigger_campaign_fulfillment
    add constraint fk__fulfillment__trigger_campaign foreign key (trigger_campaign_id) references trigger_campaign (id);

alter table trigger_campaign_trigger_campaign_condition
    add constraint fk__trigger_campaign_condition__condition foreign key (trigger_campaign_condition_id) references trigger_campaign_condition (id);

alter table trigger_campaign_trigger_campaign_condition
    add constraint fk__trigger_campaign_condition__trigger_campaign foreign key (trigger_campaign_id) references trigger_campaign (id);

alter table trigger_campaign_user
    add constraint fk__trigger_campaign_user__trigger_campaign foreign key (trigger_campaign_id) references trigger_campaign (id);

alter table trigger_campaign_user_blacklist
    add constraint fk__trigger_campaign_user_blacklist__trigger_campaign foreign key (trigger_campaign_id) references trigger_campaign (id);