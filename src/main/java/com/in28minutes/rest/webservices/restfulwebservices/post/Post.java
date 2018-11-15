package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;

@Entity
public class Post implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String descrition;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	public Post(Integer id, String descrition) {
		super();
		this.id = id;
		this.descrition = descrition;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", descrition=" + descrition + "]";
	}
	
}
