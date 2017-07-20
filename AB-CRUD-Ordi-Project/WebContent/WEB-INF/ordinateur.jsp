<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
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
       padding-bottom:50px;
		padding-top:50px;      
       padding-right:50px;
       padding-left:50px;  
      border-radius:80px;
       }

      table{   
      padding-top:10px; 
       border: 1px solid green; 
       border-radius:80px; }
    </style>
    
    
<title>Ordinateur</title>
</head>
<body>


<div class="container">
<form action="OrdinateurController" method="post">
	
		
		<table>
		<tr>
		<td><label for="ordinateurId">Ordinateur ID</label></td> 
		<td><input type="text" name="ordinateurId" 
				value="<c:out value="${ordinateur.ordinateurId}" />"
				readonly="readonly" placeholder="Ordinateur ID" />
		</td>
		</tr>
		<tr>
		<td>
		<label for="fabricant">Fabricant</label>
		</td>
		<td>
		 <input type="text"
					name="fabricant" value="<c:out value="${ordinateur.fabricant}" />"
					placeholder="Fabricant" />
		</td>	
		</tr>
		
		<tr>
		<td>
		<label for="model">Model</label> 
		</td>
		<td>
		<input type="text" name="model" 
				value="<c:out value="${ordinateur.model}" />"
					placeholder="Model" />
		</td>
		
		
		</tr>
		<tr>
		<td>
		<label for="tailleDD">Taille du disque dure</label> 
				
		</td>
		<td>
		<input type="text" name="tailleDD" 
				value="<c:out value="${ordinateur.tailleDD}" />"
				 placeholder="Taille Disque Dure"/>
		</td>
		
		
		</tr>		
		<tr>
		<td>
		<label for="tailleMemoire">Taille de memoire</label> 
				
		</td>
		<td>
		<input type="text" name="tailleMemoire" 
				value="<c:out value="${ordinateur.tailleMemoire}" />" 
				placeholder="Taille Memoire" />
		</td>
		
		
		</tr>
		<tr>
		<td>
		<label for="tailleEcran">Taille d'écran</label> 
				
		</td>
		<td>
		<input type="text" name="tailleEcran"
					value="<c:out value="${ordinateur.tailleEcran}" />"
					 placeholder="Taille Ecran" />
		</td>
		
		
		</tr>
		
		
		<tr>
		<td>
		<label for="typeProcesseur">Type de processeur</label>
				 
		</td>
		<td>
		<input type="text" name="typeProcesseur"
					value="<c:out value="${ordinateur.typeProcesseur}" />"
					 placeholder="Type Processeur" />
		</td>
		
		
		</tr>
		</table>
			
			
			
			<div>
				<input type="submit" value="Submit" />
			</div>
		
	</form>

</div>
</body>
</html>