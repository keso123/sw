package com.lvaleromsw.swcine.dao;

import com.lvaleromsw.swcine.persistence.Director;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

public class DirectorDAO {

	private static DirectorDAO instance = null;
	
	private DirectorDAO(){}
	
	public static DirectorDAO getInstance(){
		if(instance == null){
			instance = new DirectorDAO();
		}
		return instance;
	}
	
	public boolean createDirector(Director d){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+Director.class.getName()
					+" where realName == '"+d.getRealName()
					+"'";
		try{
			
			@SuppressWarnings("unchecked")
			List<Director> list = (List<Director>) pm.newQuery(query).execute();
			if(list.isEmpty()){
				pm.makePersistent(d);
				return true;
			}
			
		}finally{
			pm.close();
		}
		return false;
	}
	
	public boolean deleteDirector(long key){
		return false;
	}
	
	public boolean updateDirector(Director d){
		return false;
	}
	
	public Director getDirector(long key){
		return null;
	}
	
	public List<Director> getDirectors(){
		return null;
	}
	
	public List<Director> getDirectors(String letter){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		//String filter = "realMovieTitle >= '"+letter+"' && realMovieTitle < '"+letter+"' \uFFFD";
		
		String query = "select from "+Director.class.getName()+
				//" where "+filter+
				" order by realName" ;
		try{
			
			@SuppressWarnings("unchecked")
			List<Director> list = (List<Director>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Director> result = new ArrayList<Director>();
				for(int i = 0; i < list.size(); i++){
					//if(list.get(i).getRealMovieTitle().startsWith(letter)){
						//result.add(list.get(i));
					//}
					if(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 
					   Character.toLowerCase(letter.charAt(0))){
						result.add(list.get(i));
					}
				}
				if(result.isEmpty()) return null;
				return result;
			}
			
		}finally{
			pm.close();
		}
	}
	
	public List<Director> searchDirectors(String s){
		return null;
	}
	
	public boolean addComment(String comment,String username,long key){
		return false;
	}
}
