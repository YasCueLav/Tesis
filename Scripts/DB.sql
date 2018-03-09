create database Reguistro_Alumnos_para_Profesores
use Reguistro_Alumnos_para_Profesores

create table Cursos
(
	id_curso int identity(1,1),
	nombre varchar(100) not null,
	seccion varchar(5)
	constraint pk_curso primary key(id_curso)
)
create table Trabajos_Practicos
(
	id_tp int identity(1,1),
	nombre varchar(50) not null
	constraint pk_tp primary key (id_tp)
)
create table Condiciones
(
	id_condicion int identity(1,1),
	condicion varchar(50) not null
	constraint pk_condicion primary key (id_condicion)
)
create table Alumnos
(
	id_alumno int identity(1,1),
	legajo int not null,
	nombre varchar(50) not null,
	apellido varchar (50) not null,
	id_curso int not null,
	id_condicion int not null,
	grupo int
	constraint pk_alumno primary key(id_alumno),
	constraint fk_curso foreign key (id_curso)
	references Cursos (id_curso),
	constraint fk_condicion foreign key (id_condicion)
	references Condiciones (id_condicion)
)
create table Notas
(
	id_nota int identity(1,1),
	nota decimal (7,2)not null,
	id_alumno int not null
	constraint pk_nota primary key (id_nota),
	constraint fk_alumno foreign key (id_alumno)
	references Alumnos (id_alumno)
)
create table Tp_Alumnos
(
	id_tp_alumno int identity(1,1),
	id_tp int not null,
	id_alumno int not null,
	presentado char not null
	constraint pk_tp_alumno primary key (id_tp_alumno),
	constraint fk_tp foreign key (id_tp)
	references Trabajos_Practicos (id_tp),
	constraint fk_alumno_tp foreign key (id_alumno)
	references Alumnos (id_alumno)
)
create table Asistencias
(
	id_asistencia int identity(1,1),
	id_alumno int not null,
	fecha_registro date not null,
	esta_Precente char not null,
	obligatoria char
	constraint pk_asistencia primary key (id_asistencia),
	constraint fk_alumno_asistencias foreign key (id_alumno)
	references Alumnos (id_alumno)
)