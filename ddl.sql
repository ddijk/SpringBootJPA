create table user (
     id integer not null primary key,
     name varchar(20)
);

create table phone (
                      id integer not null primary key,
                      nummer varchar(20),
                          merk varchar(20),
                          user_id integer
);

alter table phone add constraint fk_phone_user foreign key (user_id) references user(id) on delete cascade ;

select * from user;

show tables;

drop table user;
drop table phone;
drop table hibernate_sequence;

