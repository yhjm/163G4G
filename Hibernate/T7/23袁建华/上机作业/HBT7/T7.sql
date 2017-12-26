create database HBT7;
use HBT7;
create table emp(
eid  int primary key identity(1,1),
ename varchar(20) not null,
esex varchar(2) not null,
ebirthday varchar(20) not null,
did int 
)

create table userinfo (
uid int primary key,
uname varchar(20) not null,
upwd varchar(20) not null
)

create table dept(
did int primary key identity(1,1),
dname varchar(20) not null,
daddress varchar(20) not null
)
select * from emp;
select * from userinfo;
select * from dept;