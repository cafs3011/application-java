-- changeset cintia.afs:4.0 dbms:mysql

CREATE TABLE codenation.role
(
    id bigint auto_increment,
    name varchar(255) not null,
    constraint role_pk
        primary key (id)
);

-- changeset cintia.afs:5.0 dbms:mysql

INSERT INTO role (name)
    values('ADMIN');
INSERT INTO role (name)
    values('CLIENT');

-- changeset cintia.afs:6.0 dbms:mysql

CREATE TABLE user_role
(
    id bigint not null auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk
		primary key (id),
    constraint user_role_user_fk
		foreign key (user_id) references codenation.user (id),
    constraint user_role_role_fk
		foreign key (role_id) references codenation.role (id)
);

-- changeset cintia.afs:7.0 dbms:mysql
ALTER TABLE user
    CHANGE login username VARCHAR(255) NOT NULL;