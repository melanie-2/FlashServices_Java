<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.ConexaoDao, dao.ServicoDao, classes.Servico, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/tabela.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <script src="./scripts/filtrar.js"></script>
        <title>Lista de Servicos</title>
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
                
                List<Servico> list = ServicoDao.getServicos(id, total);
                request.setAttribute("list", list); 

                int[] valores = ServicoDao.getRelatorioServicos();
                request.setAttribute("valores", valores);
                
            %>
            
            <h1>Lista de Servicos</h1>
            
            <input type="text" id="filtrarservico" onkeyup="filtrar('filtrarservico', 1)" placeholder="Busca de serviço...">
    
            
           <table id="myTable">
            <tr><th>Id</th><th>Serviço</th></tr>
                <c:forEach items="${list}" var="servico">
                <tr>
                    <td>${servico.getId()}</td>
                    <td>${servico.getServico()}</td>
                    </tr>
                </c:forEach>
            </table>          
              <a href="servicorelatorio.jsp?page=1">1</a>
   <a href="servicorelatorio.jsp?page=2">2</a>
    <a href="servicorelatorio.jsp?page=3">3</a>
 
    </div>
         <h1>Relatório de Servicos</h1>
                            
               <div class="grafico">
               <canvas id="Pedidos"></canvas>
               <p>Distribuição de Cadastro:</p>
               <p>Construção: <%=valores[0]%></p>
               <p>Serviços Gerais: <%=valores[1]%></p>
               <p>Tecnologia: <%=valores[2]%></p>
               <p>Estética: <%=valores[3]%></p>
               <p>Jardinagem: <%=valores[4]%></p>
               <p>Eletricista: <%=valores[5]%></p>
               
            </div>
         
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>
    
    <script type="text/javascript">
        var ctx = document.getElementById("Pedidos");
        var valores = [<%=valores[0]%>, <%=valores[1]%>, 3, 2, 4, 5];
        var tipos = ["Construção", "Serviços Gerais", "Tecnologia", "Estética", "Técnico", "Eventos"];

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
