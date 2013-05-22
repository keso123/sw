package com.lvaleromsw.swcine.dao;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.lvaleromsw.swcine.persistence.Movie;

public class MovieDAO {

	private static MovieDAO instance = null;
	
	private MovieDAO(){}
	
	public static MovieDAO getInstance(){
		if(instance == null){
			instance = new MovieDAO();
		}
		return instance;
	}
	
	public boolean createMovie(Movie mov){
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+Movie.class.getName()
					+" where realMovieTitle == '"+mov.getRealMovieTitle()
					+"' && director == '"+mov.getDirector()
					+"' && date == '"+mov.getDate()+"'";
		try{
			
			List<Movie> list = (List<Movie>) pm.newQuery(query).execute();
			if(list.isEmpty()){
				pm.makePersistent(mov);
				return true;
			}
			
		}finally{
			pm.close();
		}
		return false;
	}
	
	public List<Movie> getMovies(){
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+Movie.class.getName()+" order by realMovieTitle";
		
		try{
			
			List<Movie> list = (List<Movie>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else
				return list;
			
		}finally{
			pm.close();
		}
	}
}
