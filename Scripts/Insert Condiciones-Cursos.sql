----INSERT CONDICIONES----
INSERT INTO Condiciones
VALUES ('Aprobación Directa', 0)

INSERT INTO Condiciones
VALUES ('Promoción de Sistema de Unidades', 0)

INSERT INTO Condiciones
VALUES ('Regular', 0)

INSERT INTO Condiciones
VALUES ('Libre por no Cumplimiento', 0)

INSERT INTO Condiciones
VALUES ('Libre por Ausencias', 0)

----INSERT CURSOS----
INSERT INTO Cursos
VALUES ('Integración','1v1',0)

INSERT INTO Cursos
VALUES ('Integración','1v2',0)

----INSERT TPs----
INSERT INTO Trabajos_Practicos
VALUES ('Trabajo Practico 1',0)

INSERT INTO Trabajos_Practicos
VALUES ('Trabajo Practico 2',0)

INSERT INTO Trabajos_Practicos
VALUES ('Trabajo Practico 3',0)

INSERT INTO Trabajos_Practicos
VALUES ('Trabajo Practico 4',0)

INSERT INTO Trabajos_Practicos
VALUES ('Trabajo Practico 5',0)

INSERT INTO Trabajos_Practicos
VALUES ('Trabajo Practico Final Integrador',0)

----INSERT Tipo Examen----
INSERT INTO Tipos_Examenes
VALUES ('Parcial',0)

INSERT INTO Tipos_Examenes
VALUES ('Recuperatorio',0)

----INSERT Tipo Examen----
INSERT INTO Examenes
VALUES (1,'Siestemas de Unidades',0)

INSERT INTO Examenes
VALUES (2,'Siestemas de Unidades',0)

select * from Examenes

select e.id_examen , t.tipo_examen , e.examen 
from Examenes e join Tipos_Examenes t on e.id_tipo_examen = t.id_tipo_examen