package com.lvaleromsw.swcine.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.lvaleromsw.swcine.persistence.Actor;

public class ActorDAO {

	private static ActorDAO instance = null;
	
	private ActorDAO(){}
	
	public static ActorDAO getInstance(){
		if(instance == null){
			instance = new ActorDAO();
		}
		return instance;
	}
	
	public boolean createActor(Actor a){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+Actor.class.getName()
					+" where realName == '"+a.getRealName()
					+"'";
		try{
			
			@SuppressWarnings("unchecked")
			List<Actor> list = (List<Actor>) pm.newQuery(query).execute();
			if(list.isEmpty()){
				pm.makePersistent(a);
				return true;
			}
			
		}finally{
			pm.close();
		}
		return false;
	}
	
	public boolean deleteActor(long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Actor.class.getSimpleName(), key);
		
		Actor actor = null;
		
		try{
			
			actor = pm.getObjectById(Actor.class,k);
			
			if(actor == null)
				return false;
			else{
				pm.deletePersistent(actor);
			
				return true;
			}
			
		}catch(Exception e){
			
		}finally{
			pm.close();
		}
		return false;
	}
	
	public Actor getActor(long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Actor actor = null;
		
		try{
			
			Key k = KeyFactory.createKey(Actor.class.getSimpleName(), key);
			
			actor = pm.getObjectById(Actor.class,k);
			
		}catch(Exception e){
			
		}finally{
			pm.close();
		}
		return actor;
	}
	
	public List<Actor> getActors(){
		return null;
	}
	
	public List<Actor> getActors(String letter){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		
		String query = "select from "+Actor.class.getName()+
				" order by realName" ;
		try{
			
			@SuppressWarnings("unchecked")
			List<Actor> list = (List<Actor>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Actor> result = new ArrayList<Actor>();
				for(int i = 0; i < list.size(); i++){
					
					if(letter.equals("*")){
						if(!(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '0')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '1')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '2')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '3')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '4')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '5')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '6')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '7')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '8')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == '9')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'a')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'b')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'c')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'd')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'e')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'f')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'g')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'h')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'i')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'j')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'k')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'l')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'm')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'n')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'o')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'p')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'q')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'r')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 's')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 't')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'u')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'v')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'w')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'x')||
						   !(Character.toLowerCase(list.get(i).getRealName().charAt(0)) == 'y')||
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
	
	public List<Actor> searchActors(String s){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		String query = "select from "+Actor.class.getName()+
					   " order by realName";
		try{
			
			@SuppressWarnings("unchecked")
			List<Actor> list = (List<Actor>) pm.newQuery(query).execute();
			
			if(list.isEmpty())
				return null;
			else{
				List<Actor> result = new ArrayList<Actor>();
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
	
	public boolean updateActor(Actor a,long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Actor.class.getSimpleName(),key);
		
		Actor actor = null;
		
		try{
			
			actor = pm.getObjectById(Actor.class,k);
			
			if(actor == null)
				return false;
			else{
				if(a.getTitle()!= null && !a.getTitle().equals(""))
					actor.setTitle(a.getTitle());
				
				if(a.getRealName()!= null && !a.getRealName().equals(""))
					actor.setRealName(a.getRealName());
				
				if(a.getName()!= null && !a.getName().equals(""))
					actor.setName(a.getName());
				
				if(a.getBirth()!= null && !a.getBirth().equals(""))
					actor.setBirth(a.getBirth());
				
				if(a.getDeath()!= null && !a.getDeath().equals(""))
					actor.setDeath(a.getDeath());
				
				if(a.getAge()!= null && !a.getAge().equals(""))
					actor.setAge(a.getAge());
				
				if(a.getOcupation()!= null && !a.getOcupation().equals(""))
					actor.setOcupation(a.getOcupation());
				
				if(a.getDebut()!= null && !a.getDebut().equals(""))
					actor.setDebut(a.getDebut());
				
				if(a.getAwards()!= null &&  !a.getAwards().equals(""))
					actor.setAwards(a.getAwards());
				
				if(a.getFilmography()!= null && !a.getFilmography().equals(""))
					actor.setFilmography(a.getFilmography());
				
				if(a.getImageType()!= null)
					actor.setImageType(a.getImageType());
				
				if(a.getImage() != null)
					actor.setImage(a.getImage());
				
				return true;
			}
			
		}finally{
			pm.close();
		}
	}
	
	public boolean addComment(String comment,String username,long key){
		PersistenceManager pm = PMF.getInstance().getPersistenceManager();
		
		Key k = KeyFactory.createKey(Actor.class.getSimpleName(),key);
		
		Actor dir = null;
		
		try{
			
			dir = pm.getObjectById(Actor.class,k);
			
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
