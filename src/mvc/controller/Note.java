package mvc.controller;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;

public class Note {
	private String user;
	private String userSession;
	private String text;
	private String date;
	//private Blob image;

	private int id;
	private String title;
	
	
	
	
	public String getUser() {return this.user;}
	public void setUser(String user) {this.user = user;}
	
	public String getUserSession() {return this.userSession;}
	public void setUserSession(String userSession) {this.userSession = userSession;}
	
	public String getText() {return this.text;}
	public void setText(String text) {this.text = text;}
	
	public String getTitle() {return this.title;}
	public void setTitle(String title) {this.title = title;}
	
	//public Blob getImage() {return this.image;}
	//public void setImage(Blob image) {this.image = image;}
	
	public String getDate() {return this.date;}
	public void setDate(String date) {this.date = date;}
	
	
	
	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}
	

}
