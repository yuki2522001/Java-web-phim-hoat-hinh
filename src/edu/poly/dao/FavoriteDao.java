package edu.poly.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUser;
import edu.poly.domain.Send;
import edu.poly.model.Favorite;

public class FavoriteDao extends AbstracEntityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
		
	}
	public List<FavoriteReport> reportFavriteByVideo(){
		String jpql = "select new edu.poly.domain.FavoriteReport(f.video.title,f.video.videoId,count(f), min(f.likedDate), max(f.likedDate)) "
				+ " from Favorite f group by f.video.title, f.video.videoId";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	public List<FavoriteUser> findUserByVideoID(String videoId) {
		String jpql = "select new edu.poly.domain.FavoriteUser(u.user.username,u.user.fullname,u.user.email,u.likedDate) "
				+ "from Favorite u where u.video.videoId =:videoId";
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteUser> list = new ArrayList<>();
		try {
			TypedQuery<FavoriteUser> query = em.createQuery(jpql, FavoriteUser.class);
			query.setParameter("videoId",videoId);
			list = query.getResultList();
		} catch(Exception e){
			e.printStackTrace();
			
		}finally {
			em.close();
		}
		return list;
	}
	
	public List<Send> reportShareFriendsByVideos(String videoId) {
		String jpql = "select new edu.poly.domain.Send(s.user.username,s.user.email, s.emails,s.sharedDate)"
				+ " from Share s where s.video.videoId=:videoId";
		EntityManager em = JpaUtils.getEntityManager();
		List<Send> list = null;
		try {
			TypedQuery<Send> query = em.createQuery(jpql, Send.class);
			query.setParameter("videoId", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<Favorite> getFavByUser(String username) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select f from Favorite f where f.user.username = :username";
		TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
		query.setParameter("username", username);
		return query.getResultList();
	}
	public Favorite getFavorite(String username, String videoId) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select f from Favorite f where f.user.username = :username and f.video.videoID = :videoId";
		TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
		query.setParameter("username", username);
		query.setParameter("videoId", videoId);
		return query.getSingleResult();
	}
}
