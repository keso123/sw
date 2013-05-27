package com.lvaleromsw.swcine.dao;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.lvaleromsw.swcine.persistence.Director;

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
		
		Director dir = null;
		
		try{
			
			Key k = KeyFactory.createKey(Director.class.getSimpleName(), key);
			
			dir = pm.getObjectById(Director.class,k);
			
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
		
		
		String query = "select from "+Director.class.getName()+
				" order by realName" ;
		try{
			
			@SuppressWarnings("unchecked")
			List<Director> list = (List<Director>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Director> result = new ArrayList<Director>();
				for(int i = 0; i < list.size(); i++){
					
					if(letter.equals("*")){
						if(!(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '0')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '1')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '2')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '3')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '4')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '5')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '6')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '7')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '8')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '9')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'a')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'b')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'c')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'd')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'e')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'f')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'g')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'h')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'i')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'j')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'k')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'l')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'm')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'n')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'o')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'p')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'q')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'r')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 's')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 't')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'u')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'v')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'w')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'x')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'y')&&
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'z')){
							result.add(list.get(i));
						}
					}else if(letter.equals("0")){
						if(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '0'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '1'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '2'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '3'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '4'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '5'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '6'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '7'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '8'||
						   Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '9'){
							result.add(list.get(i));
						}
					}else if(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 
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
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+Director.class.getName()+
					   " order by realName";
		try{
			
			@SuppressWarnings("unchecked")
			List<Director> list = (List<Director>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Director> result = new ArrayList<Director>();
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).getRealName().contains(s)){
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
