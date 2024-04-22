create table "CLAIMS"
(
    id        bigint NOT NULL auto_increment,
    car_id       INTEGER not null,
    driver_id INTEGER not null,
    event_date DATETIME2 not null
);