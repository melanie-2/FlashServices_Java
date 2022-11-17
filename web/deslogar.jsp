<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import=" dao.ConexaoDao, dao.UsuarioDao, classes.Usuario, java.util.*"%>
<%
          request.getSession().invalidate();
        response.sendRedirect("index.html");
%>