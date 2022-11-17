<head>
<meta charset="utf-8">
<style>
* {
  box-sizing: border-box;
  font-family: Arial, Helvetica, sans-serif;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}

/* Style the content */
.content {
  background-color: #ddd;
  padding: 10px;

}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
}
</style>
</head>
<body>
<ul>
  <li><a href="index.jsp">Principal</a></li>
   <li class='dropdown'><a href='javascript:void(0)' class='dropbtn'>Serviços</a>
      <div class='dropdown-content'><a href='relatorioagendamento.jsp?page=1'>Relatório de Serviços</a><a href='relatorioprofissional.jsp?page=1'>Relatório de Profissionais</a></div></li>
   
<li class='dropdown'><a href='javascript:void(0)' class='dropbtn'>Usuários</a>
    <div class='dropdown-content'><a href='relatorio.jsp?page=1'>Relatório de Usuários</a><a href='usuarioscontrolar.jsp?page=1'>Controlar Usuários</a></div></li>
  
 <li class="dropdown" style="float:right">
     <a href="javascript:void(0)" class="dropbtn">Usuário: Admin</a>
    <div class="dropdown-content">
      <a href="escreveremail.jsp">Enviar e-mails</a>
    </div>
  </li>

</ul>
 
</body>