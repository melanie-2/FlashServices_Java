<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.ConexaoDao, dao.ProfissionalDao, classes.Profissional, dao.UsuarioDao, classes.Usuario, dao.ServicoDao, classes.Servico, java.util.*"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
        <title>Lista de Profissionais</title>
    </head>
    <body>        
        
        <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
              
                
            <%
                List<Profissional> list = ProfissionalDao.getProfissionais();
                request.setAttribute("list", list);
                
                int[] valores = ProfissionalDao.getRelatoriosServico();
                request.setAttribute("valores", valores);
            %>
            
            <h1>Lista de profissionais</h1>
            
            <input type="text" id="filtrarnomes" onkeyup="filtrar('filtrarnomes', 1)" placeholder="Busca de nomes">
            <input type="text" id="filtraremails" onkeyup="filtrar('filtraremails', 2)" placeholder="Busca de emails">
    
            
           <table id="myTable">
               <tr>
                   <th>Nome</th>
                   <th colspan="1">Serviço</th>
               <tr>
                <c:forEach items="${list}" var="usuario">
                <tr>
                    <td>${usuario.getNome()}</td>
                    <td>${usuario.getServico()}</td>
                    </tr>
                </c:forEach>
            </table>
    
         <h1>Relatório de profissionais</h1>
                            
               <div class="grafico">
               <canvas id="myChart"></canvas>
               <p>Distribuição de profissionais</p>
               <p>Construção: <%=valores[0]%></p>
               <p>Serviços Gerais: <%=valores[1]%></p>
               <p>Tecnologia: <%=valores[2]%></p>
               <p>Estética: <%=valores[3]%></p>
               <p>Técnico: <%=valores[4]%></p>
               <p>Eventos: <%=valores[5]%></p>
               
            </div>
         
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
            
    <script type="text/javascript">
        var ctx = document.getElementById("myChart");
        var valores = [<%=valores[0]%>, <%=valores[1]%>, <%=valores[2]%>, <%=valores[3]%>, <%=valores[4]%>, <%=valores[5]%> ];
        var tipos = ["Construção", "Serviços Gerais", "Tecnologia", "Estética", "Tecnico", "Eventos"];

        var myChart = new Chart(ctx, {
          type: "pie",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "Serviço com mais profissionais",
                data: valores,
                backgroundColor: [
                  "rgba(139, 10, 80, 0.2)",
                  "rgba(85, 26, 139, 0.2)",
		  "rgba(178, 34, 34, 0.2)",
		  "rgba(0, 255, 255, 0.2)",
                  "rgba(0, 100, 0 , 0.2)",
                  "rgba(148, 0, 211, 0.1)" 
                ]
              }
            ]
          }
        }); 
    </script>
</html>
