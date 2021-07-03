package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import edu.poly.model.Video;

public class VideoDao extends AbstracEntityDao<Video> {

	public VideoDao() {
		super(Video.class);

	}
	public List<Video> listget8Video(String pageNumber) {
		int number = Integer.parseInt(pageNumber);
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("videoPage", Video.class);
		query.setParameter(1, 1+(number-1)*8);
		query.setParameter(2, number*8);		
		return query.getResultList();
	}
	
}
