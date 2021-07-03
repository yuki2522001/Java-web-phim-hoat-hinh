package edu.poly.domain;

import java.util.Date;

public class FavoriteReport {
	private String videoTitle;
	private String videoId;
	private Long favoriteCount;
	private Date newsDate;
	private Date oldesDate;

	public FavoriteReport() {
	}

	public FavoriteReport(String videoTitle, String videoId, Long favoriteCount, Date newsDate, Date oldesDate) {
		super();
		this.videoTitle = videoTitle;
		this.videoId = videoId;
		this.favoriteCount = favoriteCount;
		this.newsDate = newsDate;
		this.oldesDate = oldesDate;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public Date getOldesDate() {
		return oldesDate;
	}

	public void setOldesDate(Date oldesDate) {
		this.oldesDate = oldesDate;
	}

	
}
