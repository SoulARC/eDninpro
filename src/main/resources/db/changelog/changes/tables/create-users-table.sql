--liquibase formatted sql
--changeset <bespalkoanatoliy>:<create-users-table>
create table users
(
    id       bigint auto_increment
        primary key,
    password varchar(255) null,
    email varchar(255) not null,
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (email),
        role varchar(255) not null
);

--rollback DROP TABLE users;

