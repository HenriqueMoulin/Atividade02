
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp"/>
	
    <!-- Container Principal -->
    <div id="main" class="container">
       <div class="login">
			<h1>Login</h1>
		    <form method="post" action="fazer_login">
		    	<input type="text" name="login" placeholder="Usuario" required="required" value="" autocomplete="off"/>
		        <input type="password" name="senha" placeholder="Senha" required="required" autocomplete="off"/>
		        <button type="submit">Logar</button>
		    </form>
		</div>
	</div>
           
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>