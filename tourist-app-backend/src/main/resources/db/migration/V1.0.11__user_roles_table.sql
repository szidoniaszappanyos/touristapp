create table roles
(
  id   bigserial not null
    constraint roles_pkey
    primary key,
  name varchar(60)
    constraint unique_role
    unique
);

INSERT INTO roles(name) VALUES('ROLE_USER');

create table user_roles
(
  user_id bigint not null
    constraint user_id_constraint
    references users,
  role_id bigint not null
    constraint role_id_constraint
    references roles,
  constraint user_roles_pkey
  primary key (user_id, role_id)
);
