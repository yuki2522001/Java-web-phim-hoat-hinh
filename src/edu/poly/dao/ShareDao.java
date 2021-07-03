package edu.poly.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.domain.Send;
import edu.poly.model.Share;

public class ShareDao extends AbstracEntityDao<Share>{

	public ShareDao() {
		super(Share.class);
		
	}
	public List<Send> findShareByVideoID(String videoId) {
		String jpql = "select new edu.poly.domain.FavoriteShare(u.username, u.share.emails, u.email, u.share.likedDate) "
				+ "from Favorite u where u.video.videoId =:videoId";
		EntityManager em = JpaUtils.getEntityManager();
		List<Send> list = new ArrayList<>();
		try {
			TypedQuery<Send> query = em.createQuery(jpql, Send.class);
			query.setParameter("videoId",videoId);
			list = query.getResultList();
		} catch(Exception e){
			e.printStackTrace();
			
		}finally {
			em.close();
		}
		return list;
	}

}
