package com.lvaleromsw.swcine.persistence;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Movie {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String title;
	@Persistent
	private String movieTitle;
	@Persistent
	private String realMovieTitle;
	@Persistent
	private String date;
	@Persistent
	private String country;
	@Persistent
	private String director;
	@Persistent
	private String casting;
	@Persistent
	private String genre;
	
	public Movie(String title,String movieTitle,String realMovieTitle,String date,String country,String director,String casting,String genre){
		this.title = title;
		this.movieTitle = movieTitle;
		this.realMovieTitle = realMovieTitle;
		this.date = date;
		this.country = country;
		this.director = director;
		this.casting = casting;
		this.genre = genre;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getRealMovieTitle() {
		return realMovieTitle;
	}

	public void setRealMovieTitle(String realMovieTitle) {
		this.realMovieTitle = realMovieTitle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCasting() {
		return casting;
	}

	public void setCasting(String casting) {
		this.casting = casting;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}