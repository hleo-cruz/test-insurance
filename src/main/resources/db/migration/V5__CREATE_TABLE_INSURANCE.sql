create table "INSURANCE"
(
    id       bigint NOT NULL auto_increment,
    customer_id       INTEGER not null,
    creation_dt DATETIME2 not null,
    updated_at DATETIME2,
    car_id INTEGER not null,
    is_active BOOLEAN not null
);

