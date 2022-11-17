<%@ page import="dao.UsuarioDao"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    int i = UsuarioDao.bloquearUsuario(u);
    response.sendRedirect("usuarioscontrolar.jsp?page=1");
%>
