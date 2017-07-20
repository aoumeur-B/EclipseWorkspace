<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1">
 

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">

      .container{
       margin-top: 50px;
       border: 1px solid green; 
       padding-right:0;
       padding-left:0;
       border-radius:30px;
       }
   #btAdded{
   margin-left:20px;
   }    
     
     .table-responsive{
     border-radius:30px;
     text-align: center;
     }  
     
    #act,#ordi{
     text-align:center;
     }
    </style>


<title>Insert title here</title>
</head>
<body>
<div class="container">
 <div class="table-responsive">
<table class="table table-striped">
		<thead>
			<tr class="success" >
				<th id="ordi">Ordinateur ID</th>
				<th>Fabricant </th>
				<th>Model</th>
				<th>Taille de Disque Dure</th>
				<th>Taille de Memoir</th>
				<th>Taille d'Ecran</th>
				<th>Type de processeur</th>
				<th colspan="2" id="act">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ordinateurs}" var="ordinateur">
				<tr>
					<td><c:out value="${ordinateur.ordinateurId}" /></td>
					<td><c:out value="${ordinateur.fabricant}" /></td>
					<td><c:out value="${ordinateur.model}" /></td>
					<td><c:out value="${ordinateur.tailleDD}" /></td>
					<td><c:out value="${ordinateur.tailleMemoire}" /></td>
					<td><c:out value="${ordinateur.tailleEcran}" /></td>
					<td><c:out value="${ordinateur.typeProcesseur}" /></td>
					<td><a
						href="OrdinateurController.do?action=edit&ordinateurId=<c:out value="${ordinateur.ordinateurId }"/>"><button type="button" class="btn btn-info">Update</button></a></td>
					<td><a
						href="OrdinateurController.do?action=delete&ordinateurId=<c:out value="${ordinateur.ordinateurId }"/>"> <button type="button" class="btn btn-danger"> Delete</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<p>
	 <a href="OrdinateurController.do?action=insert"><button type="button" id="btAdded" class="btn btn-success">  Add ordinateur</button></a>
		
	</p>
	
	</div>

	
</body>
</html>