--liquibase formatted sql
--changeset <bespalkoanatoliy>:<create-roles-table>

CREATE TABLE roles
(
    id        BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    role_name VARCHAR(255) NULL
);

--rollback DROP TABLE roles;
