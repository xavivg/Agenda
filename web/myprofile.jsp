<%-- 
    Document   : myprofile
    Created on : 10-may-2017, 16:47:50
    Author     : Brian
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Contactos"%>
<%@page import="entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mi Agenda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            Usuario current = (Usuario) session.getAttribute("usuario");

        %>
        <div class="menu-btn" onclick="changeClass()">☰</div>
        <nav class="pushy" id="pushy-left">
            <div class="profile">
                <div class="avatar">
                    <img src="img/no-profile.jpg" alt=""/>
                    <span><%=current.getContactosCollection().size()%></span>
                </div>
                <h3>
                    <a href="#"><%=current.getNick()%></a>
                </h3>
                <a class="log_btn" href="index.html">Log Out</a>
            </div>
        </nav>
        <div class="add_place" id="pl">
            <div class="place_form">
                <i class="fa fa-times close_window" id="close"></i>
                <h3>Nuevo Contacto<span></span></h3>
                <form action="newContact" method="POST">
                    <label>Nombre:<input type="text" name="reg_name"></label>
                    <label>Apellido:<input type="text" name="reg_surname"></label>
                    <label>Mail:<input type="text" name="reg_mail"></label>
                    <label>Móvil:<input type="text" name="reg_mobile"></label>
                    <label>Casa:<input type="text" name="reg_house"></label>
                    <label>Dirección:<input type="text" name="reg_location"></label>
                    <input type='hidden' name='reg_user' value="<%=current.getNick()%>">
                    <input type='hidden' name='reg_password' value="<%=current.getPassword()%>">
                    <button type="submit" class="green_btn_header" id="add">Añadir</button>
                </form>
            </div>
        </div>
        <div class="container contant">
            <div class="row">
                <div class="col-md-12 basic">
                    <div class="head">
                        <a href="index.html" class="logo"><h1>Mi Agenda</h1></a>
                        <a href="#" class="green_btn_header" id="addContact">
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                    <div class="contactos">
                        <h4><%=current.getContactosCollection().size()%> contactos</h4>
                        <!--Contacto-->
                        <%
                            for (Contactos contacto : current.getContactosCollection()) {
                        %>
                        <div class="contacto">
                            <div class="user">
                                <a class="user_avatars" href="Contacto?id=<%=contacto.getId()%>&current=<%=current.getNick()%>">
                                    <div class="user_go">
                                        <i class="fa fa-link"></i>
                                    </div>
                                    <img src="img/no-profile.jpg" alt=""/>
                                </a>
                            </div>
                            <div class="info">
                                <div class="head_contact">
                                    <a href="Contacto?id=<%=contacto.getId()%>&current=<%=current.getNick()%>"><%=contacto.getNombre()%> <%=contacto.getApellidos()%></a>
                                    <span><%=contacto.getTmovil()%></span>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <!-- contacto end--->
                    </div>
                    <!--morebtn-->
                    <a class="more_btn" href="#">Mostras más</a>
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
    </body>
</html>