create database db_dept;
use db_dept;
create table emp(
eid  int primary key identity(1,1),
ename varchar(20) not null,
esex varchar(2) not null,
ebirthday varchar(20) not null,
dept int not null

)

create table dept(
did int primary key identity(1,1),
dname varchar(20) not null,
daddress varchar(20) not null
)

create table userinfo (
uid int primary key,
uname varchar(20) not null,
upwd varchar(20) not null,
)
insert into dept values('董事会','国贸大厦');
insert into dept values('办公室','五角大楼');