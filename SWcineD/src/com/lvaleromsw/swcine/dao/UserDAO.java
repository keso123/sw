package com.lvaleromsw.swcine.dao;

import javax.jdo.PersistenceManager;

import com.lvaleromsw.swcine.persistence.SimpleUser;

public class UserDAO {
	
	private static UserDAO instance = null;
	
	private UserDAO(){}
	
	public static UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	public void createUser(SimpleUser user){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		//TODO comprobar que no exista por email
		
		try{
			//pm.makePersistent(user);
			
			System.out.println("makeingPersistent");
			
		}finally {
			pm.close();
		}
		
	}
}
