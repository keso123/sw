package com.lvaleromsw.swcine.persistence;

import java.util.Vector;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Director {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String title;
	@Persistent
	private String name;
	@Persistent
	private String realName;
	@Persistent
	private String birth;
	@Persistent
	private String death;
	@Persistent
	private String age;
	@Persistent
	private String ocupation;
	@Persistent
	private String debut;
	@Persistent
	private String awards;
	@Persistent
	private String filmography;
	@Persistent 
	private Vector<String> comments;
	@Persistent
	@Extension(vendorName="datanucleus", key="gae.unidexed", value="true")
	private String imageType;
	@Persistent
	private Blob image;
	
	public Director(String title,
					String name,
					String realName,
					String birth,
					String death,
					String age,
					String ocupation,
					String debut,
					String awards,
					String filmography){
		this.title = title;
		this.name = name;
		this.realName = realName;
		this.birth = birth;
		this.death = death;
		this.age = age;
		this.ocupation = ocupation;
		this.debut = debut;
		this.awards = awards;
		this.filmography = filmography;
		this.comments = new Vector<String>();
		this.imageType = null;
		this.image = null;
	}

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getDeath() {
		return death;
	}

	public void setDeath(String death) {
		this.death = death;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getFilmography() {
		return filmography;
	}

	public void setFilmography(String filmography) {
		this.filmography = filmography;
	}

	public Vector<String> getComments() {
		return comments;
	}

	public void setComments(Vector<String> comments) {
		this.comments = comments;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImage() {
		if(image == null) return null;
		return image.getBytes();
	}

	public void setImage(byte[] bytes) {
		this.image = new Blob(bytes);
	}
	
}
