# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table pessoa (
  cpf                       bigint not null,
  nome                      varchar(255),
  dia                       integer,
  mes                       integer,
  ano                       integer,
  peso                      decimal(38),
  uf                        varchar(255),
  constraint pk_pessoa primary key (cpf))
;

create sequence pessoa_seq;




# --- !Downs

drop table if exists pessoa cascade;

drop sequence if exists pessoa_seq;

