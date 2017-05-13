<%-- 
    Document   : contact
    Created on : 11-may-2017, 20:34:39
    Author     : Brian
--%>

<%@page import="entities.Contactos"%>
<%@page import="entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Agenda</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            Usuario current = (Usuario) session.getAttribute("usuario");
            Contactos contacto = (Contactos) session.getAttribute("contacto");
        %>
        <div class="notification">USUARIO ACTUALIZADO!</div>
        <div class="menu-btn" onclick="changeClass()">☰</div>
        <nav class="pushy" id="pushy-left">
            <div class="profile">
                <div class="avatar">
                    <img src="img/no-profile.jpg" alt=""/>
                    <span>5</span>
                </div>
                <h3>
                    <a href="#"><%=current.getNick()%></a>
                </h3>
                <a class="log_btn" href="logout">Log Out</a>
            </div>
        </nav>
        <div class="container contant">
            <form id="updateForm" action="updateContact" method="POST"></form>
            <form id="deleteForm" action="deleteContact" method="POST"></form>
            <div class="row">
                <!--Left column-->
                <div class="col-md-3 mobile_none">
                    <!--avatar-->
                    <div class="user_avatar">
                        <img src="img/no-profile.jpg" alt=""/>
                        <span><%=contacto.getNombre()%> <%=contacto.getApellidos()%></span>
                    </div>
                    <div class="user_btn">
                        <a class="btn btn-success" href="javascript:;" onclick="document.getElementById('updateForm').submit();">Editar</a>
                        <a class="btn btn-danger" href="javascript:;" onclick="document.getElementById('deleteForm').submit();">Eliminar</a>
                    </div>
                </div>
                <!--content-->
                <div class="col-md-9 basic vp">
                    <div class="head"></div>
                    <div class="profile_mobile_vis">
                        <!--avatar-->
                        <div class="user_avatar">
                            <img src="img/no-profile.jpg" alt=""/>
                            <span><%=contacto.getNombre()%> <%=contacto.getApellidos()%></span>
                            <div class="user_btn">
                                <a class="btn btn-success" href="javascript:;" onclick="document.getElementById('updateForm').submit();">Editar</a>
                                <a class="btn btn-danger" href="javascript:;" onclick="document.getElementById('deleteForm').submit();">Eliminar</a>
                            </div>
                        </div>
                    </div>
                    <div class="place_form_contact">
                        <input type="hidden" name="reg_id" value="<%=contacto.getId()%>" form="updateForm">
                        <input type="hidden" name="reg_id" value="<%=contacto.getId()%>" form="deleteContact">
                        <input type="hidden" name="current" value="<%=current.getNick()%>" form="updateForm">
                        <input type="hidden" name="password" value="<%=current.getPassword()%>" form="updateForm">
                        <label>Nombre:<input type="text" value="<%=contacto.getNombre()%>" name="reg_name" placeholder="<%=contacto.getNombre()%>" form="updateForm"></label>
                        <label>Apellido:<input type="text" value="<%=contacto.getApellidos()%>" name="reg_surname" placeholder="<%=contacto.getApellidos()%>" form="updateForm"></label>
                        <label>Mail:<input type="text" value="<%=contacto.getMail()%>" name="reg_mail" placeholder="<%=contacto.getMail()%>" form="updateForm"></label>
                        <label>Móvil:<input type="text" value="<%=contacto.getTmovil()%>" name="reg_mobile" placeholder="<%=contacto.getTmovil()%>" form="updateForm"></label>
                        <label>Casa:<input type="text" value="<%=contacto.getTfijo()%>" name="reg_house" placeholder="<%=contacto.getTfijo()%>" form="updateForm"></label>
                        <label>Dirección:<input type="text" value="<%=contacto.getDireccion()%>" name="reg_location" placeholder="<%=contacto.getDireccion()%>" form="updateForm"></label>
                    </div>
                    <a href="myprofile.jsp" class="more_btn"><< Volver</a>
                </div>
            </div>
        </div>
        <!--
        #################################
        - SCRIPT FILES -
        #################################
        -->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!--Google maps API linl-->
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCsbzuJDUEOoq-jS1HO-LUXW4qo0gW9FNs"></script>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <!--Other main scripts-->
        <script src="js/custom.js" type="text/javascript"></script>
        <script src="js/alert.js" type="text/javascript"></script>
    </body>
</html>
