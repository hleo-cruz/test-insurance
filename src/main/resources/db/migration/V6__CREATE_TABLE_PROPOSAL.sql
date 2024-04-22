create table "PROPOSAL"
(
    id         bigint NOT NULL auto_increment,
    customer_Name       varchar2 not null,
    document VARCHAR2 not null,
    birthdate DATE,
    model_car VARCHAR2,
    manufacturer varchar2,
    model_year varchar2,
    fipe_value varchar2,
    create_date DATE
);

