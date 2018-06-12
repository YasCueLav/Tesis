create proc pa__AgregarFechaTP
@fecha date,
@idTp int
as
IF ((select fecha_entrega from Trabajos_Practicos where id_tp = @idTp) !=   @fecha) 
      UPDATE Trabajos_Practicos SET fecha_entrega = @fecha WHERE id_tp = @idTp 

EXEC pa__AgregarFechaTP @fecha = ?, @idTp = ?

/*------------------------------------------------------------------------------------------------------------------------*/

GO
CREATE PROC pa_Parametros_Para_Condiciones
@idAlumno int = 0
as
SELECT (SELECT count(*) FROM Asistencias WHERE id_alumno = @idAlumno  AND visible = 1) 'AsistenciasTomadas', 
		(SELECT count(*) FROM Asistencias WHERE id_alumno = @idAlumno AND esta_Precente = 'true' AND visible = 1) 'CantidadAsistio',
		(SELECT n.nota FROM Notas n JOIN  Examenes e ON (n.id_examen = e.id_examen) 
												JOIN Tipos_Examenes te ON (e.id_tipo_examen = te.id_tipo_examen)
			WHERE n.visible = 1 AND e.visible = 1 AND te.visible = 1 AND n.id_examen = 3 AND te.id_tipo_examen = 1 AND n.id_alumno = @idAlumno) ' NotaParcial',
		(SELECT count(*) FROM Trabajos_Practicos WHERE visible = 1 AND id_tp != 6) 'TpAEntregar',
		(SELECT count(*) FROM Tp_Alumnos ta JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) 
			WHERE  ta.visible = 1 AND  tp.visible = 1 AND tp.id_tp != 6 AND tp.fecha_entrega = ta.fecha_entregado AND ta.id_alumno = @idAlumno) 'TpEntregadoEnFecha',
		(SELECT n.nota FROM Tp_Alumnos ta JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp) JOIN Notas n ON (n.id_tp = ta.id_tp) 
			WHERE ta.visible = 1 AND  tp.visible = 1 AND n.visible = 1 AND tp.id_tp = 6  AND ta.id_alumno = @idAlumno) 'NotaTFI'
FROM Asistencias asi JOIN Alumnos a ON (a.id_alumno = asi.id_alumno) 
							JOIN Notas n ON (n.id_alumno = a.id_alumno) 
							JOIN  Examenes e ON (n.id_examen = e.id_examen) 
							JOIN Tipos_Examenes te ON (e.id_tipo_examen = te.id_tipo_examen)
							JOIN Tp_Alumnos ta ON (a.id_alumno = ta.id_alumno AND n.id_tp = ta.id_tp)
							JOIN Trabajos_Practicos tp ON (ta.id_tp = tp.id_tp)
WHERE asi.visible = 1 AND a.visible = 1 AND n.visible = 1 AND e.visible = 1 AND te.visible = 1 AND ta.visible = 1 AND tp.visible = 1

EXEC pa_Parametros_Para_Condiciones @idAlumno = ?

/*------------------------------------------------------------------------------------------------------------------------*/
