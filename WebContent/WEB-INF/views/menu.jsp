<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<body>
	<h2>Página inicial da Lista de Tarefas</h2>
	<p>Bem vindo, ${usuarioLogado.getLogin()}</p>
	<a href="listaTarefas">Clique aqui</a> para acessar a lista de tarefas
	<a href="logout">Sair do sistema</a>
</body>