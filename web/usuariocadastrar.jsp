<%@ page import="dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    int i = UsuarioDao.cadastrarUsuario(u);
        response.sendRedirect("usuarioscontrolar.jsp?page=1");
%>