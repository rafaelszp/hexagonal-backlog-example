CREATE SEQUENCE staff_seq increment by 1 minvalue 1 start with 1;
create table STAFF (
    STAFF_ID int8 not null default nextval('staff_seq'),
    STAFF_NAME varchar(255) not null,
    STAFF_NUM_MEMBERS int4 not null,
    STAFF_DESCRIPTION TEXT,
    STAFF_GRAVATAR_ID varchar(255),
    primary key (STAFF_ID)
);

alter sequence staff_seq owned by STAFF.STAFF_ID;
alter table if exists STAFF drop constraint if exists staff_name_uniq_constraint;
alter table if exists STAFF add constraint staff_name_uniq_constraint unique (STAFF_NAME);
