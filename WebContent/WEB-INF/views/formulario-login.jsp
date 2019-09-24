<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<h2>Página de Login</h2>
	<form action="efetuaLogin" method="post">
		Login: <input type="text" name="login" /> <br /> 
		Senha: <input type="password" name="senha" /> <br /> 
		<input type="submit" value="Entrar nas tarefas" />
	</form>
		<a href="registro">Registrar</a>
</body>