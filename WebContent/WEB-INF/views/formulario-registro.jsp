<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@page import="java.util.*,mvc.model.*"%>
<h2>Registro de usuário</h2>
<form action="efetuaRegistro" method="get"
	enctype="multipart/form-data">
	Login: <input type="text" name="login" /> <br /> 
	Senha: <input type="password" name="senha" /> <br /> 
	<br /> <input type="submit" value="Registrar" />
</form>
