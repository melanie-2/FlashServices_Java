<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="dao.ConexaoDao, classes.Usuario, dao.UsuarioDao, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <title>Lista de Usuários</title>
    </head>
    <body>
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <%
                String pageid = request.getParameter("page");
                int id = Integer.parseInt(pageid);
                int total = 10;
                
                List<Usuario> list = UsuarioDao.getUsuarios(id,total);
                request.setAttribute("list", list);
                
                int contagem = UsuarioDao.getContagem();
                int i;
                request.setAttribute("contagem", contagem);
                if(contagem%total==0){
                    contagem=contagem/total;
                }else{
                    contagem=contagem/total + 1;    
                }

            %>
        
            <h1>Lista de Usuários</h1>
            <table>
            <tr><th>Id</th><th>Nome</th><th>Email</th><th>Acesso</th><th>Status</th><th colspan="2">Ações</td></tr>
                <c:forEach items="${list}" var="usuario">
                <tr>
                    <td>${usuario.getId()}</td>
                    <td>${usuario.getNome()}</td>
                    <td>${usuario.getEmail()}</td>            
                    <td>${usuario.getAcesso()}</td>    
                    <td>${usuario.getStatus()}</td> 
                    <td><a href="usuarioeditarform.jsp?id=${usuario.getId()}"><img src="./imagens/editar1.png" alt="Editar Usuário"></a></td>
                    <td><a href="usuariobloquear.jsp?id=${usuario.getId()}&status=${usuario.getStatus()}"><img src="./imagens/bloquear1.png" alt="Bloquear Usuário"></a></td>           
                </tr>
                </c:forEach>
            </table>
<div class="pagination">
    <% for(i=1; i <= contagem; i++) {%>
            <a href="usuarioscontrolar.jsp?pag=<%=i%>"><%=i%></a>
    <% } %>   
</div>  
            <a href="usuariocadastrarform.jsp"><img src="./imagens/incluir1.png" alt="Incluir Usuário"></a>
    </div>
    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>
