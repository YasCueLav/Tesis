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
        <a class="nav-link" href="/Tesis-Asistencias/AltaAsistenciaServlet">Asistencia <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Tesis-Asistencias/AltaEntregaTPServlet">Entrega TP <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Tesis-Asistencias/AltaCalificacionServlet">Notas Parciales <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
          Nuevo
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Tesis-Asistencias/AltaAlumnoServlet">Alumno</a>
          <a class="dropdown-item" href="">cc</a>
          <a class="dropdown-item" href="">bb</a>
        </div>
      </li>
      <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Listados
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="/Tesis-Asistencias/ListadoAsistenciasServlet">Asistencias</a>
            <a class="dropdown-item" href="/Tesis-Asistencias/ListadoAlumnosServlet">Alumnos</a>
            <a class="dropdown-item" href="/Tesis-Asistencias/ListadoJustificativosServlet">Justificativos</a>
            <a class="dropdown-item" href="/Tesis-Asistencias/ListadoCalificacionesServlet">Notas</a>
        </div>
        </li>
        <%--<li class="nav-item">
                <a class="nav-link" href="/Tesis-Asistencias/AltaJustificativo">Justificativo<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">xe <span class="sr-only">(current)</span></a>
            </li>--%>
      
        <li class="nav-item dropdown" >
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Sopotre
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                
              <a class="dropdown-item" href="/Tesis-Asistencias/CargaParcialServlet">Carga Parcial</a>
              <a class="dropdown-item" href="/Tesis-Asistencias/CargaTPServlet">Carga TP</a>
              <a class="dropdown-item" href="/Tesis-Asistencias/CargaCondicionesServlet">Carga Condiciones</a>
              <a class="dropdown-item" href="/Tesis-Asistencias/CargaCursoServlet">Carga Curso</a>
              <a class="dropdown-item" href="/Tesis-Asistencias/ListadoSoporteServlet">Listado</a>
            </div>
        </li>
    </ul>
      
    <ul class="nav justify-content-end">
      <li class="nav-item active">
        <c:if test="${inicio}">
            <a class="nav-link" href="/Tesis-Asistencias/RevicionInicial.jsp" onclick="alert('Desconectado');" id="secion">
                Cerrar Sesion<span class="sr-only">(current)</span></a>
        </c:if>
        <c:if test="${!inicio}">
            <a class="nav-link" href="/Tesis-Asistencias/Login" id="secion">Iniciar Sesion<span class="sr-only">(current)</span></a>
        </c:if>   
      </li>
    </ul>
  </div>
</nav>