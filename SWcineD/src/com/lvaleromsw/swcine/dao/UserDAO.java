package com.lvaleromsw.swcine.dao;

import java.util.List;

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
	
	public boolean createUser(SimpleUser user){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+SimpleUser.class.getName()+" where name == '"+user.getName()+"' && email == '"+user.getEmail()+"'";
		
		try{
			List<SimpleUser> list = (List<SimpleUser>) pm.newQuery(query).execute();
			if(list.isEmpty()){
				pm.makePersistent(user);
				return true;
			}
			
		}finally {
			pm.close();
		}
		
		return false;
		
	}
	
	public SimpleUser getUser(String username,String pass){
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+SimpleUser.class.getName()+" where name == '"+username+"' && pass == '"+pass+"'";
		
		try {
			List<SimpleUser> user = (List<SimpleUser>) pm.newQuery(query).execute();
			if(!user.isEmpty()){
				return user.get(0);
			}
		}finally {
			pm.close();
		}
		
		return null;
	}
}
