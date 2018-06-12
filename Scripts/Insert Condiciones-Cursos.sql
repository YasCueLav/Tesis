use Gestus
----INSERT CONDICIONES----
INSERT INTO Condiciones
VALUES ('Aprobación Directa', 1)

INSERT INTO Condiciones
VALUES ('Promoción de Sistema de Unidades', 1)

INSERT INTO Condiciones
VALUES ('Regular', 1)

INSERT INTO Condiciones
VALUES ('Libre por no Cumplimiento', 1)

INSERT INTO Condiciones
VALUES ('Libre por Ausencias', 1)

----INSERT CURSOS----
INSERT INTO Cursos
VALUES ('Integración','1v1',1)

INSERT INTO Cursos
VALUES ('Integración','1v2',1)

----INSERT TPs----
INSERT INTO Trabajos_Practicos (nombre, visible)
VALUES ('Trabajo Practico 1',1)

INSERT INTO Trabajos_Practicos (nombre, visible)
VALUES ('Trabajo Practico 2',1)

INSERT INTO Trabajos_Practicos (nombre, visible)
VALUES ('Trabajo Practico 3',1)

INSERT INTO Trabajos_Practicos (nombre, visible)
VALUES ('Trabajo Practico 4',1)

INSERT INTO Trabajos_Practicos (nombre, visible)
VALUES ('Trabajo Practico 5',1)

INSERT INTO Trabajos_Practicos (nombre, visible)
VALUES ('Trabajo Practico Final Integrador',1)

----INSERT Tipo Examen----
INSERT INTO Tipos_Examenes
VALUES ('Parcial',1)

INSERT INTO Tipos_Examenes
VALUES ('Recuperatorio',1)

----INSERT Tipo Examen----
SET LANGUAGE 'Español'
INSERT INTO Examenes (id_tipo_examen,examen,fecha_examen,visible)
VALUES (1,'Siestemas de Unidades','11/05/2018',1)

INSERT INTO Examenes (id_tipo_examen,examen,visible)
VALUES (2,'Siestemas de Unidades',1)

select * from Examenes

select e.id_examen , t.tipo_examen , e.examen 
from Examenes e join Tipos_Examenes t on e.id_tipo_examen = t.id_tipo_examen

----INSERT Estados----
INSERT INTO Estados (estado,visible)
VALUES ('Sin Estado',1)

INSERT INTO Estados (estado,visible)
VALUES ('Aprobado',1)

INSERT INTO Estados (estado,visible)
VALUES ('No Aprobado',1)