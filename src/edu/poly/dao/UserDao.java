package edu.poly.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import edu.poly.domain.FavoriteUser;
import edu.poly.model.User;

public class UserDao extends AbstracEntityDao<User> {

	public UserDao() {
		super(User.class);

	}

	public User findByEmail(String email) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		return query.getSingleResult();

	}

	public User findByUsernameAndEmail(String username, String email) {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "select u from User u where u.username=:username and u.email = :email";

		try {
			TypedQuery<User> query = em.createNamedQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("email", email);

			return query.getSingleResult();
		} finally {
			em.close();
		}
	}
}
