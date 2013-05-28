function checkMovie(){ 
	var error = 0;
	if($.trim(check_movie.title.value) == ""){
		error = 1;
		alert("El titulo no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.movieTitle.value) == ""){
		error = 1;
		alert("El titulo de la pelicula no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.realMovieTitle.value) == ""){
		error = 1;
		alert("El titulo original no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.date.value) == ""){
		error = 1;
		alert("El año no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.country.value) == ""){
		error = 1;
		alert("El pais no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.director.value) == ""){
		error = 1;
		alert("El director no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.casting.value) == ""){
		error = 1;
		alert("El reparto no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.genre.value) == ""){
		error = 1;
		alert("El genero no puede ser vacio");
		//return;
	}
	if($.trim(check_movie.synopsis.value) == ""){
		error = 1;
		alert("La sinopsis no puede ser vacia");
		//return;
	}
	if($.trim(check_movie.imagefile.value) == ""){
		error = 1;
		alert("La imagen no puede ser vacia");
		//return;
	}
	if(error == 0){
		check_movie.submit();
	}
}

function checkActor(){ 
	var error = 0;
	if($.trim(check_actor.title.value) == ""){
		error = 1;
		alert("El titulo no puede ser vacio");
		//return;
	}
	if($.trim(check_actor.name.value) == ""){
		error = 1;
		alert("El nombre no puede ser vacio");
		//return;
	}
	if($.trim(check_actor.realName.value) == ""){
		error = 1;
		alert("El nombre real no puede ser vacio");
		//return;
	}
	if($.trim(check_actor.birth.value) == ""){
		error = 1;
		alert("La fecha de nacimiento no puede ser vacia");
		//return;
	}
	if($.trim(check_actor.death.value) == ""){
		error = 1;
		alert("La fecha de muerte no puede ser vacia");
		//return;
	}
	if($.trim(check_actor.age.value) == ""){
		error = 1;
		alert("La edad no puede ser vacia");
		//return;
	}
	if($.trim(check_actor.ocupation.value) == ""){
		error = 1;
		alert("La ocupacion no puede ser vacia");
		//return;
	}
	if($.trim(check_actor.debut.value) == ""){
		error = 1;
		alert("El debut no puede ser vacio");
		//return;
	}
	if($.trim(check_actor.awards.value) == ""){
		error = 1;
		alert("Los premios no pueden ser vacios");
		//return;
	}
	if($.trim(check_actor.filmography.value) == ""){
		error = 1;
		alert("La filmografia no puede ser vacia")
		//return;
	}
	if($.trim(check_actor.imagefile.value) == ""){
		error = 1;
		alert("La imagen no puede ser vacia");
		//return;
	}
	
	if(error == 0){
		check_actor.submit();
	}
}

function checkDirector(){ 
	var error = 0;
	if($.trim(check_director.title.value) == ""){
		error = 1;
		alert("El titulo no puede ser vacio");
		//return;
	}
	if($.trim(check_director.name.value) == ""){
		error = 1;
		alert("El nombre no puede ser vacio");
		//return;
	}
	if($.trim(check_director.realName.value) == ""){
		error = 1;
		alert("El nombre real no puede ser vacio");
		//return;
	}
	if($.trim(check_director.birth.value) == ""){
		error = 1;
		alert("La fecha de nacimiento no puede ser vacia");
		//return;
	}
	if($.trim(check_director.death.value) == ""){
		error = 1;
		alert("La fecha de muerte no puede ser vacia");
		//return;
	}
	if($.trim(check_director.age.value) == ""){
		error = 1;
		alert("La edad no puede ser vacia");
		//return;
	}
	if($.trim(check_director.ocupation.value) == ""){
		error = 1;
		alert("La ocupacion no puede ser vacia");
		//return;
	}
	if($.trim(check_director.debut.value) == ""){
		error = 1;
		alert("El debut no puede ser vacio");
		//return;
	}
	if($.trim(check_director.awards.value) == ""){
		error = 1;
		alert("Los premios no pueden ser vacios");
		//return;
	}
	if($.trim(check_director.filmography.value) == ""){
		error = 1;
		alert("La filmografia no puede ser vacia")
		//return;
	}
	if($.trim(check_director.imagefile.value) == ""){
		error = 1;
		alert("La imagen no puede ser vacia");
		//return;
	}
	
	if(error == 0){
		check_director.submit();
	}
}
function checkLogin(){ 
	var error = 0;
	if($.trim(check_login.username.value) == ""){
		error = 1;
		alert("El nombre no puede ser vacio");
	}
	if($.trim(check_login.passwd.value) == ""){
		error = 1;
		alert("La password no puede ser vacia");
	}
	if(error == 0){
		check_login.submit();
	}
	
	
}
function checkReg(){ 
	var error = 0;
	if($.trim(check_reg.username.value) == ""){
		error = 1;
		alert("El nombre no puede ser vacio");
	}
	if($.trim(check_reg.passwd.value) == ""){
		error = 1;
		alert("La password no puede ser vacia");
	}
	if($.trim(check_reg.repasswd.value) == ""){
		error = 1;
		alert("La password no puede ser vacia");
	}
	if(error == 0){
		check_reg.submit();
	}
	
	
}


