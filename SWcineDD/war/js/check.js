function checkMovie(){ 
	if($.trim(check_movie.title.value) == ""){
		alert("El titulo no puede ser vacio");
		return;
	}
	if($.trim(check_movie.movieTitle.value) == ""){
		alert("El titulo de la pelicula no puede ser vacio");
		return;
	}
	if($.trim(check_movie.realMovieTitle.value) == ""){
		alert("El titulo original no puede ser vacio");
		return;
	}
	if($.trim(check_movie.date.value) == ""){
		alert("El año no puede ser vacio");
		return;
	}
	if($.trim(check_movie.country.value) == ""){
		alert("El pais no puede ser vacio");
		return;
	}
	if($.trim(check_movie.director.value) == ""){
		alert("El director no puede ser vacio");
		return;
	}
	if($.trim(check_movie.casting.value) == ""){
		alert("El reparto no puede ser vacio");
		return;
	}
	if($.trim(check_movie.genre.value) == ""){
		alert("El genero no puede ser vacio");
		return;
	}
	if($.trim(check_movie.synopsis.value) == ""){
		alert("La sinopsis no puede ser vacio");
		return;
	}
	if($.trim(check_movie.imagefile.value) == ""){
		alert("La imagen no puede ser vacio");
		return;
	}
	
	check_movie.submit();
}