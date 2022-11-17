<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.ConexaoDao, dao.UsuarioDao, classes.Usuario, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link rel="icon" href="imagens/icon_site.png" /> 
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <script src="./scripts/filtrar.js"></script>
        <title>Lista de Usuarios</title>
    </head>
    
    <body>        
        
        <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
        
            <div class="content">       
                
            <%
                List<Usuario> list = UsuarioDao.getRelatorio();
                request.setAttribute("list", list);
                
                int[] mes = UsuarioDao.getRelatorioUsuarioPorMes();
                request.setAttribute("mes", mes);
                
                int[] valores = UsuarioDao.getRelatorioCondicao();
                request.setAttribute("valores", valores);
            %>
            
            <h1>Lista de Usuarios</h1>
            
            <input type="text" id="filtrarnomes" onkeyup="filtrar('filtrarnomes', 1)" placeholder="Busca de nomes">
            <input type="text" id="filtraremails" onkeyup="filtrar('filtraremails', 2)" placeholder="Busca de emails">
    
            
           <table id="myTable">
               <tr><th>Id</th><th>Nome</th><th colspan="1">Email</th><th colspan="3">Data_Acesso</th><tr>
                <c:forEach items="${list}" var="usuario">
                <tr>
                    <td>${usuario.getId()}</td>
                    <td>${usuario.getNome()}</td>
                    <td>${usuario.getEmail()}</td>
                    <td>${usuario.getTelefone()}</td>
                    <td>${usuario.getAcesso()}</td>
                    <td>${usuario.getData_Acesso()}</td>
                    </tr>
                </c:forEach>
            </table>      
           
            <a href="relatorio.jsp?page=1">1</a>
   <a href="relatorio.jsp?page=2">2</a>
    <a href="relatorio.jsp?page=3">3</a>
            
    </div>
         <h1>Relatório de Usuários</h1>
                            
         
            <div class="grafico">
                <p>Novos Usuarios por mês:</p>
                <canvas id="myChart"></canvas>
            </div>
         
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>
   
  
     <script type="text/javascript">
        var ctx = document.getElementById("myChart");
        var mes = [<%=mes[0]%>, <%=mes[1]%>, <%=mes[2]%>, <%=mes[3]%>, <%=mes[4]%>, <%=mes[5]%>, <%=mes[6]%>, <%=mes[7]%>, <%=mes[8]%>, <%=mes[9]%>, <%=mes[10]%>, <%=mes[11]%>];
        var nome_mes = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"];

        var myChart4 = new Chart(ctx, {
          type: "bar",
          data: {
            labels: nome_mes,
            datasets: [
              {
                label: "Novos Usuarios Por Mês",
                data: mes,
                backgroundColor: [
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)",
                  "rgba(255, 206, 86, 0.2)",
                  "rgba(75, 192, 192, 0.2)",
                  "rgba(153, 102, 255, 0.2)",
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)",
                  "rgba(255, 206, 86, 0.2)",
                  "rgba(75, 192, 192, 0.2)",
                  "rgba(153, 102, 255, 0.2)",
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)"
                ]
              }
            ]
          }
        }); 
    </script> 
   
     <div class="grafico">
                <canvas id="myChart2"></canvas>
                <p>Condição dos Usuarios:</p>
                <p>Ativos: <%=valores[0]%></p>
                <p>Inativos: <%=valores[1]%></p>
            </div>
    
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>
            
            <script type="text/javascript">
        var ctx = document.getElementById("myChart2");
        var valores = [<%=valores[0]%>, <%=valores[1]%>];
        var tipos = ["Ativo", "Inativo"];

        var myChart = new Chart(ctx, {
          type: "pie",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "Status Usuarios",
                data: valores,
                backgroundColor: [
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)",                 
                ]
              }
            ]
          }
        }); 
    </script>
            
    <div class="footer">
       
    </div>
    
    </body>
</html>
