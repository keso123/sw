package com.lvaleromsw.swcine.dao;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.lvaleromsw.swcine.persistence.Director;
import com.lvaleromsw.swcine.persistence.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Director.class.getSimpleName(), key);
		
		Director dir = null;
		
		try{
			
			dir = pm.getObjectById(Director.class,k);
			
			if(dir == null)
				return false;
			else{
				pm.deletePersistent(dir);
			
				return true;
			}
			
		}catch(Exception e){
			
		}finally{
			pm.close();
		}
		return false;
	}
	
	public boolean updateDirector(Director d,long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Director.class.getSimpleName(),key);
		
		Director dir = null;
		
		try{
			
			dir = pm.getObjectById(Director.class,k);
			
			if(dir == null)
				return false;
			else{
				if(d.getTitle()!= null && !d.getTitle().equals(""))
					dir.setTitle(d.getTitle());
				
				if(d.getRealName()!= null && !d.getRealName().equals(""))
					dir.setRealName(d.getRealName());
				
				if(d.getName()!= null && !d.getName().equals(""))
					dir.setName(d.getName());
				
				if(d.getBirth()!= null && !d.getBirth().equals(""))
					dir.setBirth(d.getBirth());
				
				if(d.getDeath()!= null && !d.getDeath().equals(""))
					dir.setDeath(d.getDeath());
				
				if(d.getAge()!= null && !d.getAge().equals(""))
					dir.setAge(d.getAge());
				
				if(d.getOcupation()!= null && !d.getOcupation().equals(""))
					dir.setOcupation(d.getOcupation());
				
				if(d.getDebut()!= null && !d.getDebut().equals(""))
					dir.setDebut(d.getDebut());
				
				if(d.getAwards()!= null &&  !d.getAwards().equals(""))
					dir.setAwards(d.getAwards());
				
				if(d.getFilmography()!= null && !d.getFilmography().equals(""))
					dir.setFilmography(d.getFilmography());
				
				if(d.getImageType()!= null)
					dir.setImageType(d.getImageType());
				
				if(d.getImage() != null)
					dir.setImage(d.getImage());
				
				return true;
			}
			
		}finally{
			pm.close();
		}
	}
	
	public Director getDirector(long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		//String query = "select from "+Movie.class.getName()+" where key == '"+KeyFactory.createKey(Movie.class.getName(),key)+"'";
		
		Director dir = null;
		
		try{
			
			Key k = KeyFactory.createKey(Director.class.getSimpleName(), key);
			
			dir = pm.getObjectById(Director.class,k);
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
		return dir;
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
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Director.class.getSimpleName(),key);
		
		Director dir = null;
		
		try{
			
			dir = pm.getObjectById(Director.class,k);
			
			if(dir == null)
				return false;
			else{
				//pm.deletePersistent(mov);
				
				Vector<String> comments = dir.getComments();
				comments.add(comment);
				comments.add(username);
				dir.setComments(comments);
				
				//pm.makePersistent(mov);
				//pm.flush();
				
				return true;
			}
			
		}finally{
			pm.close();
		}
	}
}
