CREATE SEQUENCE task_seq increment by 1 minvalue 1 start with 1;
create table task (
                       TASK_ID int8 not null default nextval('staff_seq'),
                       TASK_TITLE varchar(255) not null,
                       TASK_DESC TEXT,
                       TASK_DATE_EXP date,
                       primary key (TASK_ID)
);

alter sequence task_seq owned by STAFF.STAFF_ID;
