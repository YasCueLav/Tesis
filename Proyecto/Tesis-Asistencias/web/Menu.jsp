<%-- 
    Document   : Menu
    Created on : 19/04/2018, 17:52:58
    Author     : Yasmin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav  class="navbar navbar-expand-lg navbar-dark bg-dark">
<a class="navbar-brand" href="/Tesis-Asistencias/Index">Inicio</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        
        <li class="nav-item">
            <a class="nav-link" href="/Tesis-Asistencias/AltaAsistenciaServlet">Asistencias<span class="sr-only">(current)</span></a>
        </li>
	  
        <li class="nav-item">
            <a class="nav-link" href="/Tesis-Asistencias/EntregaTpDecisionServlet">Entrega Trabajos<span class="sr-only">(current)</span></a>
        </li>
	  
        <li class="nav-item">
            <a class="nav-link" href="/Tesis-Asistencias/AltaCalificacionServlet">Notas Examenes<span class="sr-only">(current)</span></a>
        </li>
	  
	<li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
            Condiciones </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadosAlumnosCondicinesServlet">Actualizar</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ReporteAprobacionDirectaServlet">Aprobado Directo</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ReporteRegularidadServlet">Regular</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ReporteLibreAplazoServlet">Libre x Aplazo</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ReporteLibreInasistenciasServlet">Libre x Ausencias</a>
            </div>
        </li>
	  
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
            Consultas </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoAsistenciasServlet">Asistencias</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoAsistenciasEspecificoServlet">Cantidad Ausencias</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoJustificativosServlet">Justificativos</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoCalificacionesServlet">Notas Examenes</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoTPServlet">Entrega TP</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoTFIServlet">Entrega TFI</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoAlumnosServlet">Alumnos</a>
            </div>
        </li>
      
        <li class="nav-item dropdown" >
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Sopotre </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="/Tesis-Asistencias/AltaAlumnoServlet">Nuevo Alumno</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/ListadoSoporteServlet">Listado Soporte</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/CargaParcialServlet">Nuevo Examen</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/CargaTPServlet">Nuevo Tabajo Practico</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/CargaCondicionesServlet">Nuevo Condiciones</a>
                <a class="dropdown-item" href="/Tesis-Asistencias/CargaCursoServlet">Nuevo Curso</a>
            </div>
        </li>
    </ul>
      
    <ul class="nav justify-content-end">
        <li class="nav-item active">
            <c:if test="${inicio}">
                <a class="nav-link" href="/Tesis-Asistencias/RevicionInicial.jsp" onclick="alert('Desconectado');" id="secion">
                    <img src="Login-out-white.png" id="" class="img-fluid" >
                    Cerrar Sesion<span class="sr-only">(current)</span></a>
            </c:if>
            <c:if test="${!inicio}">
                <a class="nav-link" href="/Tesis-Asistencias/Login" id="secion">
                    <img src="Login-in-white.png" id="" class="img-fluid" >
                    Iniciar Sesion<span class="sr-only">(current)</span></a>
            </c:if>   
        </li>
    </ul>
      
  </div>
</nav>