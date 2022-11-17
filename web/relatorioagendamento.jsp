<%@ page import="dao.AgendamentoDao, dao.ConexaoDao, java.util.*"%>
<%@ page import="classes.Agendamento" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link rel="icon" href="imagens/icon_site.png" />
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <script src="./scripts/filtrar.js"></script>
        <title>Lista de Serviços Mais Pedidos</title>
    </head>
    
    <body>        
        
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
        
            <div class="topnav">
           
            </div>
            <div class="content">        
            <%                
                String pageid = request.getParameter("page");
                int id = Integer.parseInt(pageid);
                int total = 10;
                
                List<Agendamento> list = AgendamentoDao.getAgendamento();
                request.setAttribute("list", list);
                
                int[] valores = AgendamentoDao.getRelatorioServicos();
                request.setAttribute("valores", valores);
                
            %>
            
            <h1>Lista de Serviços</h1>    
            
           <table id="myTable">
            <tr><th>Serviço</th></tr>
                <c:forEach items="${list}" var="agendamento">
                <tr>
                    <td>${agendamento.getDescription()}</td>
                </tr>
                </c:forEach>
            </table>                       
 
    </div>
         <h1>Relatório de serviços</h1>
                            
               <div class="grafico">
               <canvas id="myChart"></canvas>
               <p>Distribuição de serviços</p>
               <p>Construção: <%=valores[0]%></p>
               <p>Serviços Gerais: <%=valores[1]%></p>
               <p>Tecnologia: <%=valores[2]%></p>
               <p>Estética: <%=valores[3]%></p>
               <p>Técnico: <%=valores[4]%></p>
               <p>Eventos: <%=valores[5]%></p>
               
            </div>
         
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>
    
    <script type="text/javascript">
        var ctx = document.getElementById("myChart");
        var valores = [<%=valores[0]%>, <%=valores[1]%>, <%=valores[2]%>, <%=valores[3]%>, <%=valores[4]%>, <%=valores[5]%> ];
        var tipos = ["Construção", "Serviços Gerais", "Tecnologia", "Estética", "Tecnico", "Eventos"];

        var myChart = new Chart(ctx, {
          type: "bar",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "Serviço",
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
  
    <div class="footer">
       
    </div>
    
    </body>
</html>
