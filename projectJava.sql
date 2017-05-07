
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


