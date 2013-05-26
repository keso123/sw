funcion checkLogin(){
	if($.trim(check_login.username.value) == ""){
		alert("El nombre de usuario no puede ser vacio");
		return;
	}
	
	if($.trim(check_login.passwd.value) == ""){
		alert("La contraseña no puede ser vacia");
		return;
	}
	
	check_login.submit();
}