--GESTOR ALUMNOS

--obtenerAlumnos // 
	--Select * from Alumnos where visible = 1


--obtenerAlumnosXCurso // 
	--SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.seccion FROM Alumnos al join Cursos c on (al.id_curso = c.id_curso) 
	--WHERE c.id_curso = "+ curso +"and al.visible = 1 and c.visible = 1


--obtenerAlumno ConID // 
	--select * from Alumnos where id_alumno = ? and visible = 1


--modificarAlumno // 
	--UPDATE Alumnos SET legajo = ?, nombre = ?, apellido = ?, id_curso = ?, id_condicion = ?, grupo = ? WHERE id_alumno = ?


--elimniarAlumno // 
	--UPDATE Alumnos SET visible = 0 WHERE id_alumno = "+ id


--agregarAlumno // 
	--INSERT INTO Alumnos (legajo, nombre, apellido, id_curso, id_condicion, grupo, fecha_ingreso, visible) VALUES (?,?,?,?,?,?,?,1)


--obtenerAlumnoCurso // 
	--SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.seccion FROM Alumnos al join Cursos c on (al.id_curso = c.id_curso) 
	--WHERE al.visible = 1 and c.visible = 1


--obtenerAlumnoCursoCondiciones // 
	--SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  
	--FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) 
	--WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1

