create database Gestus
use Gestus
SET LANGUAGE 'Español'

create table Estados
(
	id_estado int identity(1,1),
	estado varchar(100) not null,
	visible bit not null 
	constraint pk_estado primary key(id_estado)
)
create table Cursos
(
	id_curso int identity(1,1),
	nombre varchar(100) not null,
	seccion varchar(5),
	visible bit not null 
	constraint pk_curso primary key(id_curso)
)
create table Trabajos_Practicos
(
	id_tp int identity(1,1),
	nombre varchar(50) not null,
	visible bit not null
	constraint pk_tp primary key (id_tp)
)
create table Condiciones
(
	id_condicion int identity(1,1),
	condicion varchar(50) not null,
	visible bit not null 
	constraint pk_condicion primary key (id_condicion)
)
create table Alumnos
(
	id_alumno int identity(1,1),
	legajo int unique not null,
	nombre varchar(50) not null,
	apellido varchar (50) not null,
	id_curso int not null,
	id_condicion int not null,
	grupo int,
	fecha_ingreso date,
	visible bit not null 
	constraint pk_alumno primary key(id_alumno),
	constraint fk_curso foreign key (id_curso)
	references Cursos (id_curso),
	constraint fk_condicion foreign key (id_condicion)
	references Condiciones (id_condicion)
)
create table Tipos_Examenes
(
	id_tipo_examen int identity(1,1),
	tipo_examen varchar(50) not null,
	visible bit not null
	constraint pk_tipo_examen primary key (id_tipo_examen)
)
create table Examenes
(
	id_examen int identity(1,1),
	id_tipo_examen int not null,
	examen varchar(50) not null,
	fecha_examen date,
	visible bit not null
	constraint pk_examen primary key (id_examen),
	constraint fk_tipo_examen foreign key (id_tipo_examen)
	references Tipos_Examenes (id_tipo_examen)
)
create table Notas
(
	id_nota int identity(1,1),
	nota decimal (7,2)not null,
	id_alumno int not null,
	id_examen int,
	id_tp int,
	visible bit not null 
	constraint pk_nota primary key (id_nota),
	constraint fk_alumno foreign key (id_alumno)
	references Alumnos (id_alumno),
	constraint fk_examen foreign key (id_examen)
	references Examenes (id_examen),
	constraint fk_tp_notas foreign key (id_tp)
	references Trabajos_Practicos (id_tp)
)
create table Tp_Alumnos
(
	id_tp_alumno int identity(1,1),
	id_tp int not null,
	id_alumno int not null,
	presentado bit not null,
	fecha_entregado date,
	id_estado int,
	visible bit not null 
	constraint pk_tp_alumno primary key (id_tp_alumno),
	constraint fk_tp foreign key (id_tp)
	references Trabajos_Practicos (id_tp),
	constraint fk_alumno_tp foreign key (id_alumno)
	references Alumnos (id_alumno),
	constraint fk_estado foreign key (id_estado)
	references Estados (id_estado)
)
create table Asistencias
(
	id_asistencia int identity(1,1),
	id_alumno int not null,
	fecha_registro date not null,
	esta_Precente bit not null,
	obligatoria bit,
	visible bit not null 
	constraint pk_asistencia primary key (id_asistencia),
	constraint fk_alumno_asistencias foreign key (id_alumno)
	references Alumnos (id_alumno)
)
