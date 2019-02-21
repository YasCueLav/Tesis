CREATE proc pa__AgregarFechaTP
@fecha date,
@idTp int
as
IF @fecha <> (select fecha_entrega from Trabajos_Practicos where id_tp = @idTp)  OR 
		NULL <> (select fecha_entrega from Trabajos_Practicos where id_tp = @idTp)  
BEGIN
      UPDATE Trabajos_Practicos SET fecha_entrega = @fecha WHERE id_tp = @idTp 
END

EXEC pa__AgregarFechaTP @fecha = ?, @idTp = ?

/*------------------------------------------------------------------------------------------------------------------------*/

GO
CREATE PROC pa_Parametros_Para_Condiciones
@idAlumno int
as
SELECT DISTINCT (SELECT id_alumno FROM Alumnos WHERE id_alumno = @idAlumno) 'Alumno',
		(SELECT count(*) FROM Asistencias WHERE id_alumno = @idAlumno  AND visible = 1) 'AsistenciasTomadas', 
		(SELECT count(*) FROM Asistencias WHERE id_alumno = @idAlumno AND esta_Precente = 'true' AND visible = 1) 'CantidadAsistio',
		(SELECT n.nota FROM Notas n JOIN  Examenes e ON (n.id_examen = e.id_examen) 
												JOIN Tipos_Examenes te ON (e.id_tipo_examen = te.id_tipo_examen)
			WHERE n.visible = 1 AND e.visible = 1 AND te.visible = 1 AND n.id_examen = 1 AND te.id_tipo_examen = 1 AND n.id_alumno = @idAlumno) 'NotaParcial',
		(SELECT count(*) FROM Trabajos_Practicos WHERE visible = 1) 'TpAEntregar',
		(SELECT count(*) FROM Tp_Alumnos ta JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) 
			WHERE  ta.visible = 1 AND  tp.visible = 1 AND tp.id_tp != 6 AND tp.fecha_entrega = ta.fecha_entregado AND ta.id_alumno = @idAlumno) 'TpEntregadoEnFecha',
		(SELECT DISTINCT n.nota FROM Tp_Alumnos ta JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) JOIN Notas n ON (n.id_tp = ta.id_tp) 
			WHERE ta.visible = 1 AND  tp.visible = 1 AND n.visible = 1 AND tp.id_tp = 6  AND tp.fecha_entrega = ta.fecha_entregado 
								AND ta.id_alumno = @idAlumno AND n.id_alumno = @idAlumno AND n.id_nota = (SELECT MAX(nota.id_nota) 
									FROM Trabajos_Practicos tp JOIN Notas nota ON (nota.id_tp = tp.id_tp)  where tp.id_tp = 6 and nota.id_alumno = @idAlumno)) 'NotaTFI'
FROM Asistencias asi JOIN Alumnos a ON (a.id_alumno = asi.id_alumno) 
							JOIN Notas n ON (n.id_alumno = a.id_alumno) 
							JOIN  Examenes e ON (n.id_examen = e.id_examen) 
							JOIN Tipos_Examenes te ON (e.id_tipo_examen = te.id_tipo_examen)
							JOIN Tp_Alumnos ta ON (a.id_alumno = ta.id_alumno )
							JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp)
WHERE asi.visible = 1 AND a.visible = 1 AND n.visible = 1 AND e.visible = 1 AND te.visible = 1 AND ta.visible = 1 AND tp.visible = 1

EXEC pa_Parametros_Para_Condiciones @idAlumno = 1
/*------------------------------------------------------------------------------------------------------------------------*/

go
CREATE PROC pa_Cantidad_Asistencias_Inasistencias
@idAlumno int
as
SELECT DISTINCT (SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND id_alumno = @idAlumno) 'AsistenciasTomadas', 
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND obligatoria = 'True' AND id_alumno = @idAlumno) 'AsistenciasTotalesObligatoria',
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND esta_Precente = 'False' AND id_alumno = @idAlumno) 'InasistenciasTotales',
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND obligatoria = 'True' AND esta_Precente = 'False' AND id_alumno = @idAlumno) 'InasistenciasTotalesObligatorias'
FROM Asistencias
WHERE visible = 1

EXEC pa_Cantidad_Asistencias_Inasistencias @idAlumno = 1

/*------------------------------------------------------------------------------------------------------------------------*/

go
CREATE PROC pa_Alumnos_Curso_Asistencias
@idAlumno int
as
SELECT DISTINCT a.id_alumno, a.legajo, a.nombre, a.apellido, c.nombre 'curso', c.seccion,
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND id_alumno = @idAlumno) 'AsistenciasTomadas', 
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND obligatoria = 'True' AND id_alumno = @idAlumno) 'AsistenciasTotalesObligatoria',
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND esta_Precente = 'False' AND id_alumno = @idAlumno) 'InasistenciasTotales',
		(SELECT COUNT(*) FROM Asistencias WHERE visible = 1 AND obligatoria = 'True' AND esta_Precente = 'False' AND id_alumno = @idAlumno) 'InasistenciasTotalesObligatorias'
FROM Asistencias asi JOIN Alumnos a ON (a.id_alumno = asi.id_alumno) JOIN Cursos c ON (c.id_curso = a.id_curso)
WHERE asi.visible = 1 AND a.visible = 1 AND c.visible = 1 AND asi.id_alumno = @idAlumno

EXEC pa_Alumnos_Curso_Asistencias @idAlumno = 2

/*------------------------------------------------------------------------------------------------------------------------*/
go
CREATE PROC pa_Alumnos_Curso_TP_Todos
as
SELECT DISTINCT ta.id_tp_alumno, a.id_alumno, a.legajo, a.nombre, a.apellido, c.nombre 'curso', c.seccion, tp.nombre 'tp',ta.presentado ,tp.fecha_entrega, ta.fecha_entregado, e.estado, ta.visible
FROM Tp_Alumnos ta JOIN Alumnos a ON (ta.id_alumno = a.id_alumno) 
					JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) 
					JOIN Estados e ON (ta.id_estado = e.id_estado) 
					JOIN Cursos c ON (a.id_curso = c.id_curso)
WHERE ta.visible = 1 AND a.visible = 1 AND tp.visible = 1 AND e.visible = 1 AND c.visible = 1 --AND  a.id_alumno = 1
ORDER BY a.apellido, a.nombre, tp.nombre 

EXEC pa_Alumnos_Curso_TP_Todos

/*------------------------------------------------------------------------------------------------------------------------*/
go
CREATE PROC pa_Alumnos_Curso_TP_Uno
@id int
as
SELECT DISTINCT ta.id_tp_alumno, a.id_alumno, a.legajo, a.nombre, a.apellido, c.nombre 'curso', c.seccion, tp.nombre 'tp', ta.presentado ,tp.fecha_entrega, ta.fecha_entregado,e.id_estado ,e.estado
FROM Tp_Alumnos ta JOIN Alumnos a ON (ta.id_alumno = a.id_alumno) 
					JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) 
					JOIN Estados e ON (ta.id_estado = e.id_estado) 
					JOIN Cursos c ON (a.id_curso = c.id_curso)
WHERE ta.visible = 1 AND a.visible = 1 AND tp.visible = 1 AND e.visible = 1 AND c.visible = 1 AND  ta.id_tp_alumno = @id
ORDER BY a.apellido, a.nombre, tp.nombre 

EXEC pa_Alumnos_Curso_TP_Uno @id = 1

/*------------------------------------------------------------------------------------------------------------------------*/

go
alter PROC pa_Alumnos_Curso_TFI_Todo
as
SELECT ta.id_tp_alumno, ta.id_alumno, a.legajo, a.nombre, a.apellido, c.nombre 'curso', c.seccion, tp.nombre 'tp', tp.fecha_entrega, ta.fecha_entregado ,n.nota
FROM Tp_Alumnos ta JOIN Alumnos a ON (ta.id_alumno = a.id_alumno) 
					JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp)
					JOIN Cursos c ON (a.id_curso = c.id_curso)
					JOIN Notas n ON (a.id_alumno = n.id_alumno)
WHERE ta.visible = 1 AND a.visible = 1 AND tp.visible = 1 AND c.visible = 1 AND n.visible = 1 AND n.id_tp = 6 AND tp.id_tp = 6
ORDER BY a.apellido, a.nombre, tp.nombre

go
EXEC pa_Alumnos_Curso_TFI_Todo
/*------------------------------------------------------------------------------------------------------------------------*/

go
CREATE PROC pa_Alumnos_Curso_TFI_Uno
@idAlumno int
as
SELECT DISTINCT ta.id_tp_alumno, a.id_alumno, a.legajo, a.nombre, a.apellido, c.nombre 'curso', c.seccion, tp.id_tp, tp.nombre 'tp',  ta.presentado , 
	tp.fecha_entrega, ta.fecha_entregado, (SELECT n.nota FROM Alumnos al JOIN Notas n ON (al.id_alumno = n.id_alumno) WHERE al.id_alumno = a.id_alumno AND n.id_tp = 6 
							AND n.id_nota =  (SELECT MAX(nota.id_nota) FROM Alumnos alum JOIN Notas nota ON (alum.id_alumno = nota.id_alumno) 
												WHERE alum.id_alumno = a.id_alumno AND nota.id_tp = 6)) 'nota'
FROM Tp_Alumnos ta JOIN Alumnos a ON (ta.id_alumno = a.id_alumno) 
					JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp)
					JOIN Cursos c ON (a.id_curso = c.id_curso) 
WHERE ta.visible = 1 AND a.visible = 1 AND tp.visible = 1 AND c.visible = 1 AND ta.id_tp = 6 AND ta.id_alumno = @idAlumno AND ta.id_tp_alumno = 
			(SELECT MAX(tpa.id_tp_alumno) FROM Tp_Alumnos tpa WHERE tpa.id_alumno = a.id_alumno AND tpa.id_tp = 6)
ORDER BY a.apellido, a.nombre, tp.nombre

EXEC pa_Alumnos_Curso_TFI_uno @idAlumno = 1

/*------------------------------------------------------------------------------------------------------------------------*/

CREATE proc pa__Editar_TP
@fecha date,
@id int,
@estado int,
@presentado bit
as
UPDATE Tp_Alumnos SET fecha_entregado = @fecha, id_estado = @estado, presentado = @presentado
WHERE id_tp_alumno = @id 

EXEC pa__Editar_TP @fecha = ?, @id = ?, @estado = ?, @presentado = ?

/*------------------------------------------------------------------------------------------------------------------------*/

CREATE proc pa__Editar_TP_Sin_Fecha
@id int,
@estado int,
@presentado bit
as
UPDATE Tp_Alumnos SET id_estado = @estado, presentado = @presentado
WHERE id_tp_alumno = @id 

EXEC pa__Editar_TP_Sin_Fecha @estado = 1, @presentado = ?, @id = ?

/*------------------------------------------------------------------------------------------------------------------------*/
CREATE proc pa__Editar_TFI_Fecha
@fecha date,
@id int,
@nota int,
@presentado bit
as
UPDATE Tp_Alumnos SET fecha_entregado = @fecha, presentado = @presentado
WHERE id_tp = 6 AND id_alumno = @id AND id_tp_alumno = (select MAX(tpa.id_tp_alumno) from Tp_Alumnos tpa where tpa.id_alumno = @id and tpa.id_tp = 6)
UPDATE Notas SET nota = @nota
WHERE id_tp = 6 AND id_alumno = @id AND id_nota = (select MAX(n.id_nota) from Notas n where n.id_alumno = @id and n.id_tp = 6)

EXEC pa__Editar_TFI_Fecha @fecha = ?, @presentado = ?, @nota = ?, @id = ?

/*------------------------------------------------------------------------------------------------------------------------*/
CREATE proc pa__Editar_TFI_Sin_Fecha
@id int,
@nota int,
@presentado bit
as
UPDATE Tp_Alumnos SET presentado = @presentado
WHERE id_tp = 6 AND id_alumno = @id AND id_tp_alumno = (select MAX(tpa.id_tp_alumno) from Tp_Alumnos tpa where tpa.id_alumno = @id and tpa.id_tp = 6)
UPDATE Notas SET nota = @nota
WHERE id_tp = 6 AND id_alumno = @id AND id_nota = (select MAX(n.id_nota) from Notas n where n.id_alumno = @id and n.id_tp = 6)

EXEC pa__Editar_TFI_Sin_Fecha @presentado = ?, @nota = ?, @id = ?

------------------------------------------------------------------------
CREATE proc pa_Eliminar_TP_TFI
@idAlumno int
as
UPDATE Tp_Alumnos SET visible = 0
WHERE id_tp = 6 AND id_alumno = @idAlumno 
UPDATE Notas SET visible = 0
WHERE id_tp = 6 AND id_alumno = @idAlumno 

EXEC pa_Eliminar_TP_TFI  @idAlumno = ?
--------------------------------------------------------------
CREATE proc pa_Eliminar_TP
@idAlumno int,
@tp int
as
UPDATE Tp_Alumnos SET visible = 0
WHERE id_tp = @tp AND id_alumno = @idAlumno 

EXEC pa_Eliminar_TP @tp = 1,  @idAlumno = 3
/*------------------------------------------------------------------------------------------------------------------------*/
go
CREATE PROC pa_Alumnos_Datos
@idAlumno int
as
SELECT DISTINCT (SELECT id_alumno FROM Alumnos WHERE id_alumno = @idAlumno) 'Alumno',
				(SELECT legajo FROM Alumnos WHERE id_alumno = @idAlumno) 'legajo',
				(SELECT nombre FROM Alumnos WHERE id_alumno = @idAlumno)'nombre',
				(SELECT apellido FROM Alumnos WHERE id_alumno = @idAlumno)'apellido',
				(SELECT cur.id_curso FROM Alumnos alum JOIN Cursos cur ON (alum.id_curso = cur.id_curso) WHERE alum.id_alumno = @idAlumno) 'Curso',
				(SELECT cur.nombre FROM Alumnos alum JOIN Cursos cur ON (alum.id_curso = cur.id_curso) WHERE alum.id_alumno = @idAlumno) 'nombreCurso',
				(SELECT cur.seccion FROM Alumnos alum JOIN Cursos cur ON (alum.id_curso = cur.id_curso) WHERE alum.id_alumno = @idAlumno) 'divicion',
				(SELECT count(*) FROM Asistencias WHERE id_alumno = @idAlumno  AND visible = 1) 'AsistenciasTomadas', 
				(SELECT count(*) FROM Asistencias WHERE id_alumno = @idAlumno AND esta_Precente = 'true' AND visible = 1) 'CantidadAsistio',
				(SELECT n.nota FROM Notas n JOIN  Examenes e ON (n.id_examen = e.id_examen) JOIN Tipos_Examenes te ON (e.id_tipo_examen = te.id_tipo_examen)
					WHERE n.visible = 1 AND e.visible = 1 AND te.visible = 1 AND n.id_examen = 1 AND te.id_tipo_examen = 1 AND n.id_alumno = @idAlumno) 'NotaParcial',
				(SELECT DISTINCT n.nota FROM Tp_Alumnos ta JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) JOIN Notas n ON (n.id_tp = ta.id_tp) 
					WHERE ta.visible = 1 AND  tp.visible = 1 AND n.visible = 1 AND tp.id_tp = 6  AND tp.fecha_entrega = ta.fecha_entregado 
										AND ta.id_alumno = @idAlumno AND n.id_alumno = @idAlumno AND n.id_nota = (SELECT MAX(nota.id_nota) 
											FROM Trabajos_Practicos tp JOIN Notas nota ON (nota.id_tp = tp.id_tp)  where tp.id_tp = 6 and nota.id_alumno = @idAlumno)) 'NotaTFI'
FROM Asistencias asi JOIN Alumnos a ON (a.id_alumno = asi.id_alumno) 
							JOIN Notas n ON (n.id_alumno = a.id_alumno) 
							JOIN  Examenes e ON (n.id_examen = e.id_examen) 
							JOIN Tipos_Examenes te ON (e.id_tipo_examen = te.id_tipo_examen)
							JOIN Tp_Alumnos ta ON (a.id_alumno = ta.id_alumno )
							JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp)
WHERE asi.visible = 1 AND a.visible = 1 AND n.visible = 1 AND e.visible = 1 AND te.visible = 1 AND ta.visible = 1 AND tp.visible = 1


EXEC pa_Alumnos_Datos @idAlumno = 1
/*------------------------------------------------------------------------------------------------------------------------*/
go
CREATE PROC pa_Alumnos_Datos_TP
@idAlumno int
as
SELECT DISTINCT ta.id_tp_alumno, a.id_alumno, a.legajo, a.nombre, a.apellido, c.id_curso 'Curso' ,c.nombre 'nombreCurso', c.seccion, tp.nombre 'tp',
			ta.presentado ,tp.fecha_entrega, ta.fecha_entregado, e.estado
FROM Tp_Alumnos ta JOIN Alumnos a ON (ta.id_alumno = a.id_alumno) 
					JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) 
					JOIN Estados e ON (ta.id_estado = e.id_estado) 
					JOIN Cursos c ON (a.id_curso = c.id_curso)
WHERE ta.visible = 1 AND a.visible = 1 AND tp.visible = 1 AND e.visible = 1 AND c.visible = 1 AND  a.id_alumno = @idAlumno
ORDER BY tp.nombre 

EXEC pa_Alumnos_Datos_TP  @idAlumno = 1

/*------------------------------------------------------------------------------------------------------------------------*/


