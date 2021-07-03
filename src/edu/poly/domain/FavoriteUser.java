package edu.poly.domain;

import java.util.Date;

public class FavoriteUser {
	private String username;
	private String fullname;
	private String email;
	private Date favoriteDate;

	public FavoriteUser() {
		super();
	}

	public FavoriteUser(String username, String fullname, String email, Date favoriteDate) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.favoriteDate = favoriteDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFavoriteDate() {
		return favoriteDate;
	}

	public void setFavoriteDate(Date favoriteDate) {
		this.favoriteDate = favoriteDate;
	}

}
