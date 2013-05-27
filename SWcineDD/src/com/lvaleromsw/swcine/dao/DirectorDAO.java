package com.lvaleromsw.swcine.dao;

import com.lvaleromsw.swcine.persistence.Director;
import java.util.List;

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
		return null;
	}
	
	public List<Director> searchDirectors(String s){
		return null;
	}
	
	public boolean addComment(String comment,String username,long key){
		return false;
	}
}
