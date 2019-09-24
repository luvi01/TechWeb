<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Food Service</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/blog-home.css" rel="stylesheet">

<script>
function abrirPopup(el) {
	const id = el.name;
	const blog = document.getElementById(id);
	const text = blog.querySelector("p").innerText
	
	const popup = document.getElementById("textformedit");
	
	const inputId = document.getElementById("idPost");
	
	inputId.value = id;
	
	
	
	popup.innerHTML = text;
	
	$('#editForm').fadeToggle();
	var container = $("#editForm");
	
	
	$(document).mouseup(function(e) {

		if (!container.is(e.target) // if the target of the click isn't the container...
				&& container.has(e.target).length === 0) // ... nor a descendant of the container
		{
			container.fadeOut();
		}
	});
	

	
}

</script>

</head>
	
<body>
	<%@page import="java.util.*,mvc.controller.*"%>
	
	
	




	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Food Service</a> <a href="#"
				id="adicionar" class="btn btn-primary">Adicionar +</a>
				
			  <!--   <a class="navbar-brand" href="#"> user</a> -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<!-- Blog Entries Column -->
			<h1 class="my-4">
					Setor de posts.<small> Comente um pensamento.</small>
				</h1>

			<%
				
				
				NotesDAO dao = new NotesDAO();

				List<Note> notes = dao.getNotes();
				for (Note note : notes) {
			%>


			<div class="col-md-8">
				<!-- Post -->




				

				<!-- Blog Post -->
				<div class="card mb-4" id=<%= note.getId() %>>
		
					<div class="card-body">
						<h2 class="card-title"><%= note.getTitle() %></h2>
						<p class="card-text"><%=note.getText()%></p>

						<div style="display: flex;">
							<form action="RemoveNote" method="post" style='margin: 0 1rem 0 0'>
								<input type="hidden" name="userSession" value="${usuarioLogado.getLogin()}" readonly>
								<input type="hidden" name="user" value="<%= note.getUser() %>" readonly>
								
								<input type="hidden" name="id" value="<%= note.getId() %>" readonly>
								
								
								<button class="btn btn-primary" name=<%= "removeId" + note.getId() %> type="submit">Remover</button>
	
							</form>
							
							
								
								
								<button class="btn btn-primary" name=<%= note.getId() %> onclick="abrirPopup(this)" type="submit">Editar</button>
	
							
							
						</div>



					</div>
					<div class="card-footer text-muted">
						<%=note.getDate()%>
						by <a href="#">${usuarioLogado.getLogin()}</a>
					</div>
				</div>



			</div>
			<!-- Post -->

			<%
				}
			%>


			<!-- /.row -->

		</div>

		<div id="contactForm">

			<h3>Criar pedido.</h3>
			<small>Crie seu pedido através do campo abaixo.</small>

			<form action="AddNote" method="post">
				<input type="hidden" name="userSession" value="${usuarioLogado.getLogin()}" readonly>
				
				
				
				<input id="textform" name="title" placeholder="Título"></input>
				<textarea id="textform" name="text" placeholder="Comentario"></textarea>
				<button class="formBtn" type="submit">Comentar</button>

			</form>


		</div>
		
		
		<div id="editForm">

			<h3>Editar pedido</h3>
			<small>Edite seu pedido no campo abaixo.</small>

			<form action="EditNote" method="post">
				<input type="hidden" name="userSession" value="${usuarioLogado.getLogin()}" readonly>
				
				<input type="hidden" id="idPost" name="id" value="" readonly>
				<textarea class="formedit" id="textformedit" name="text" placeholder="Comentario"></textarea>
				<button class="formBtn" type="submit">Editar</button>

			</form>


		</div>
		
		
		
		<!-- /.container -->

		<!-- Footer -->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Food Service 2019</p>
			</div>
			<!-- /.container -->
		</footer>

		<!-- Bootstrap core- JavaScript -->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script>
			$(function() {

				// contact form animations
				$('#adicionar').click(function() {
					$('#contactForm').fadeToggle();
				})
				$(document).mouseup(function(e) {
					var container = $("#contactForm");

					if (!container.is(e.target) // if the target of the click isn't the container...
							&& container.has(e.target).length === 0) // ... nor a descendant of the container
					{
						container.fadeOut();
					}
					
					
					
					
					
				});

			});
		</script>

		<style>
@import "https://fonts.googleapis.com/css?family=Raleway";

* {
	box-sizing: border-box;
}

#adicionar:hover {
	background: #666;
}

#adicionar:active {
	background: #444;
}

#contactForm, #editForm {
	display: none;
	border: 6px solid salmon;
	padding: 3em;
	width: 400px;
	text-align: center;
	background: #fff;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	-webkit-transform: translate(-50%, -50%)
}

#inputform, #textformedit {
	margin: .8em auto;
	font-family: inherit;
	text-transform: inherit;
	font-size: inherit;
	display: block;
	width: 280px;
	padding: .4em;
}

#textformedit {
	height: 80px;
	resize: none;
}

.formBtn {
	width: 140px;
	display: inline-block;
	background: teal;
	color: #fff;
	font-weight: 100;
	font-size: 1.2em;
	border: none;
	height: 30px;
}
</style>
</body>

</html>
