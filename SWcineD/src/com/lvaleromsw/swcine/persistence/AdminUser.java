package com.lvaleromsw.swcine.persistence;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class AdminUser extends MyUser {
	
	public AdminUser(String name,String pass,String email){
		super(name,pass,email);
		super.setAdmin(true);
	}
}
