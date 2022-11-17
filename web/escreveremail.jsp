<html>
<head>
	<meta charset="utf-8">
        <link rel="icon" href="imagens/icon_site.png" />
	<title>Redijir emails</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body class="form">
    
    <div class="topnav">
    <%@include file="menu.jsp"%>
</div>
    
	<div class="page-content">
	  <div class="form-v4-content">
	     <div class="form-left">
		<form class="form-detail"  action="javaemail.jsp" method="post">
	       	  <h2>Redija Emails Avaliativos</h2>
			<div class="form-group">
			   <div class="form-row form-row-1">
				<label for="first_name">Assunto...</label>
				<input type="text" name="assunto" size="45" class="input-text">
			   </div>
          					
		        </div>
                  
			<div class="form-group">
		        <div class="form-row form-row-1 ">
			     <label for="your_email">Texto do email...</label>
			     <textarea name="comenta" class="input-text" cols="50" rows="10"> </textarea>
		        </div>
		
			</div>
                  
			<div class="form-row-last">
	       		     <input type="submit" name="Submit" class="register" value="Enviar emails">
			</div>
		</form>
	     </div>
	  </div>
	
	</div>
</body>
</html>
