package com.lvaleromsw.swcine.persistence;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class SimpleUser extends MyUser{
	
	public SimpleUser(String name,String pass,String email){
		super(name,pass,email);
		super.setName(name);
		super.setPass(pass);
		super.setEmail(email);
	}
	
}
