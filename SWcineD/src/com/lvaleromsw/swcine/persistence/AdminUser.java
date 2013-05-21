package com.lvaleromsw.swcine.persistence;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class AdminUser extends MyUser {

	public AdminUser(String name,String pass,String email){
		super(name,pass,email);
		super.setName(name);
		super.setPass(pass);
		super.setEmail(email);
	}
}
