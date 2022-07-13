create database if not exists yarn;

use yarn;
 
drop table if exists skeins;


create table skeins (
	id int (10) NOT NULL auto_increment,
	brand varchar(50) NOT NULL,
	color varchar(50) NOT NULL,
	primary key (id)
);