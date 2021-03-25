create sequence hibernate_sequence start with 1 increment by 1
create table item_leilao (id bigint not null, count integer, name varchar(255), primary key (id))
create sequence "hibernate_sequence" start with 1 increment by 1
create table "item_leilao" ("id" bigint not null, "count" integer, "name" varchar(255), primary key ("id"))
