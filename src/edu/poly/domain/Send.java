package edu.poly.domain;

import java.util.Date;

public class Send {
	private String lastname;
	private String email;
	private String emails;
	private Date sharedDate;
	public Send() {
		super();
	}
	public Send(String lastname, String email, String emails, Date sharedDate) {
		super();
		this.lastname = lastname;
		this.email = email;
		this.emails = emails;
		this.sharedDate = sharedDate;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getSharedDate() {
		return sharedDate;
	}
	public void setSharedDate(Date sharedDate) {
		this.sharedDate = sharedDate;
	}
	
	
}
