package com.lvaleromsw.swcine.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.jdo.PersistenceManager;

import com.lvaleromsw.swcine.persistence.Movie;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

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
			
			@SuppressWarnings("unchecked")
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
			
			@SuppressWarnings("unchecked")
			List<Movie> list = (List<Movie>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else
				return list;
			
		}finally{
			pm.close();
		}
	}

	public List<Movie> getMovies(String letter){
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		//String filter = "realMovieTitle >= '"+letter+"' && realMovieTitle < '"+letter+"' \uFFFD";
		
		String query = "select from "+Movie.class.getName()+
				//" where "+filter+
				" order by realMovieTitle" ;
		try{
			
			@SuppressWarnings("unchecked")
			List<Movie> list = (List<Movie>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Movie> result = new ArrayList<Movie>();
				for(int i = 0; i < list.size(); i++){
					//if(list.get(i).getRealMovieTitle().startsWith(letter)){
						//result.add(list.get(i));
					//}
					if(letter.equals("*")){
						if(!(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '0')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '1')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '2')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '3')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '4')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '5')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '6')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '7')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '8')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '9')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'a')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'b')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'c')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'd')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'e')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'f')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'g')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'h')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'i')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'j')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'k')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'l')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'm')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'n')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'o')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'p')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'q')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'r')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 's')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 't')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'u')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'v')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'w')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'x')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'y')&&
						   !(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 'z')){
							result.add(list.get(i));
						}
					}else if(letter.equals("0")){
						if(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '0'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '1'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '2'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '3'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '4'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '5'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '6'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '7'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '8'||
						   Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == '9'){
							result.add(list.get(i));
						}
					}else if(Character.toLowerCase(list.get(i).getRealMovieTitle().charAt(0)) == 
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
	
	public List<Movie> searchMovies(String s){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		//String filter = "realMovieTitle >= '"+letter+"' && realMovieTitle < '"+letter+"' \uFFFD";
		
		String query = "select from "+Movie.class.getName()+
				//" where "+filter+
				" order by realMovieTitle" ;
		try{
			
			@SuppressWarnings("unchecked")
			List<Movie> list = (List<Movie>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Movie> result = new ArrayList<Movie>();
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).getRealMovieTitle().contains(s)){
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
	
	public Movie getMovie(long key){
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		//String query = "select from "+Movie.class.getName()+" where key == '"+KeyFactory.createKey(Movie.class.getName(),key)+"'";
		
		Movie mov = null;
		
		try{
			
			Key k = KeyFactory.createKey(Movie.class.getSimpleName(), key);
			
			mov = pm.getObjectById(Movie.class,k);
			/*List<Movie> list = (List<Movie>) pm.newQuery(query).execute();
			
			System.out.println("despues de la query");
			
			if(list.size() == 1){
				return list.get(0);
			}else{
				return null;
			}*/
			
		}catch(Exception e){
			
		}finally{
			pm.close();
		}
		return mov;
	}
	
	public boolean addComment(String comment,String username,long key){
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Movie.class.getSimpleName(),key);
		
		Movie mov = null;
		
		try{
			
			mov = pm.getObjectById(Movie.class,k);
			
			if(mov == null)
				return false;
			else{
				//pm.deletePersistent(mov);
				
				Vector<String> comments = mov.getComments();
				comments.add(comment);
				comments.add(username);
				mov.setComments(comments);
				
				//pm.makePersistent(mov);
				//pm.flush();
				
				return true;
			}
			
		}finally{
			pm.close();
		}
	}

	public boolean updateMovie(Movie m,long key) {
		
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Movie.class.getSimpleName(),key);
		
		Movie mov = null;
		
		try{
			
			mov = pm.getObjectById(Movie.class,k);
			
			if(mov == null)
				return false;
			else{
				//pm.deletePersistent(mov);
				//System.out.println(m.getTitle());
				if(m.getTitle() != null && !m.getTitle().equals("")) 
					mov.setTitle(m.getTitle());
				
				//System.out.println(m.getMovieTitle());
				if(m.getMovieTitle() != null && !m.getMovieTitle().equals("")) 
					mov.setMovieTitle(m.getMovieTitle());
				
				//System.out.println(m.getRealMovieTitle());
				if(m.getRealMovieTitle() != null && !m.getRealMovieTitle().equals("")) 
					mov.setRealMovieTitle(m.getRealMovieTitle());
				
				//System.out.println(m.getDate());
				if(m.getDate() != null && !m.getDate().equals("")) 
					mov.setDate(m.getDate());
				
				//System.out.println(m.getCountry());
				if(m.getCountry() != null && !m.getCountry().equals("")) 
					mov.setCountry(m.getCountry());
				
				//System.out.println(m.getDirector());
				if(m.getDirector() != null && !m.getDirector().equals("")) 
					mov.setDirector(m.getDirector());
				
				//System.out.println(m.getCasting());
				if(m.getCasting() != null && !m.getCasting().equals("")) 
					mov.setCasting(m.getCasting());
				
				//System.out.println(m.getGenre());
				if(m.getGenre() != null && !m.getGenre().equals("")) 
					mov.setGenre(m.getGenre());
				
				//System.out.println(m.getSynopsis());
				if(m.getSynopsis() != null && !m.getSynopsis().equals("")) 
					mov.setSynopsis(m.getSynopsis());
				
				//System.out.println(m.getImageType());
				if(m.getImageType() != null) 
					mov.setImageType(m.getImageType());
				
				//System.out.println(m.getImage());
				if(m.getImage() != null) 
					mov.setImage(m.getImage());
				
				//pm.makePersistent(mov);
				//pm.flush();
				
				return true;
			}
			
		}finally{
			pm.close();
		}
	}
	
	public boolean deleteMovie(long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Movie.class.getSimpleName(),key);
		
		Movie mov = null;
		
		try{
			
			mov = pm.getObjectById(Movie.class,k);
			
			if(mov == null)
				return false;
			else{
				//pm.deletePersistent(mov);
				
				pm.deletePersistent(mov);
				
				//pm.makePersistent(mov);
				//pm.flush();
				
				return true;
			}
			
		}finally{
			pm.close();
		}
	}
}
