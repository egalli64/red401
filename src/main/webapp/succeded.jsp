<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booked</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<style>
body {
	background-color: rgb(255, 223, 223);
	border: 18px;
	text-align: center;
}

h1 {
	color: rgb(0, 0, 0);
	font-family: Times New Roman;
	font-size: px;
	text-align: center;
}

h4 {
	color: rgb(0, 0, 0);
	font-family: Times New Roman;
	text-align: center;
}

.titolo {
	color: rgb(0, 0, 0);
	background-color: rgb(255, 100, 100);
	border: 1px solid black;
}

#spiegazione {
	color: rgb(230, 16, 16);
	text-align: center;
}

.Pick {
	background-color: rgb(255, 183, 183);
	text-align: center;
	font-size: 16px;
	margin: auto;
	width: 50%;
	padding: 10px;
}
</style>
</head>
<body>

<div class="titolo">
		<h1>Save A Seat</h1>
		<p>Riservati un posto in una delle aule studio di Torino</p>
	</div>
	<br>
	
	<figure>
		<img id="image" src="/red/img/download.jpg" height="200px"
			width="500px">
		<img id="image2" src="/red/img/download_1.jpg" height="200px"
			width="350px">
		<img id="image3" src="/red/img/aula-studio-opera.jpg" height="200px"
			width="350px">
	</figure>
	<h2>Ciao, ti sei prenotato con successo all'aula studio ${name} in ${address} per lo slot ${ora} <br>
	Buono Studio!</h2>
	<br>
	<a href="/red/index.html">Home</a>

</body>
</html>