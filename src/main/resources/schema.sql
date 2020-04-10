create table IF NOT EXISTS student
(
   id bigint  primary key AUTO_INCREMENT,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   modified TIMESTAMP AS CURRENT_TIMESTAMP,
   primary key(id)
);
