'Create table users (
id int auto_increment primary key,
name varchar(25),
surname varchar(15),
email varchar(15) not null,
password varchar(25) not null,
fee decimal(10,2),
paid decimal(10,2),
due decimal(10,2),
address varchar(30),
phone varchar(25),
rol enum(\'admin\',\'student\',\'accountant\'),
constraint fk_fee foreign key (fee) references fee(fee));

Create table fee (
id int auto_increment primary key,
fee decimal(10,2) not null,
date date
);'
create database agenda;

Create table usuario(
nick varchar(25) not null primary key,
password varchar(25) not null)ENGINE=InnoDB DEFAULT CHARSET=latin1;

SHOW ENGINE INNODB STATUS;

Create table contactos (
id int auto_increment primary key,
nombre varchar(25) not null,
apellidos varchar(100),
mail varchar(100),
tfijo varchar(100),
tmovil varchar(100),
direccion varchar(100),
usuario_nick varchar(25),
foreign key (usuario_nick) references usuario(nick)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE contactos ENGINE=InnoDB;

