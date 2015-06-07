package org.tutorial.messenger.model;

import java.util.Date;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private @QueryParam("id") Long id;
	private @QueryParam("message") String message;
	private @QueryParam("date") Date dateCreated;
	private @QueryParam("author") String author;
	
	public Message(){}
	public Message(Long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.dateCreated = new Date();
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
