<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="index.jsp"%>
<div class="edit" style="margin-left: 300px; margin-bottom: 300px;">
	<div class="main-card mb-3 card">
		<div class="card-body">
			<h5 class="card-title">Emploi du temps</h5>
			<form  action="AddEmploipost" method="POST" enctype="multipart/form-data">


				<div class="form-row">
					<div class="col-md-6">

						<div class="position-relative form-group">
							<label for="Nom Etudiant" class="">Nom EDT</label> <input
								id="Nom Etudiant" type="text" name="nom" />


						</div>

					</div>
				</div>
		
		<div class="col-md-6">
			<div class="position-relative form-group">
				<label for="Filiere" class="">Professeurs</label> <select
					name="idProfesseur" id="Filiere" class="form-control" required>
					<option>Choisir le Professeur :</option>
					<c:forEach var="p" items="${professeurs}">
						<option value="${p.getIdProfeseur()}">${p.getNom()}</option>
					</c:forEach>
				</select>
			</div>
			

		</div>
	<div class="form-row">
		<div class="col-md-6">
			<div class="position-relative form-group">
				<input type="checkbox" class="form-check-input"
					onchange="displayInput('edt')" name="edt" style="margin-left: 1px">
				<label style="margin-left: 15px">E D T</label>
			</div>
		</div>

		<div class="col-md-6" id="edt" style="display: none">
			<div class="position-relative form-group">
				<label for="edt" class="">Inserer EDT</label><input name="photo"
					id="file" type="file" class="form-control-file">
			</div>


		</div>
	</div>
	<button class="mt-2 btn btn-primary col-md-12" type="submit">Valider</button>
	</form>
</div>
</div>
</div>


<script>
	function displayInput(idS) {

		var x = document.getElementById(idS + "");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
