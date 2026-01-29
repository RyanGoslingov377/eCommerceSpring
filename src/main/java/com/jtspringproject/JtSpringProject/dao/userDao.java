package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.User;

@Repository
public class userDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<User> getAllUser() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	@Transactional
	public User saveUser(User user) {
		if (user.getId() == 0) {
			entityManager.persist(user);
		} else {
			entityManager.merge(user);
		}
		System.out.println("User added/updated: " + user.getId());
		return user;
	}

	@Transactional
	public User getUser(String username, String password) {
		try {
			User user = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
					.setParameter("username", username)
					.getSingleResult();
			System.out.println(user.getPassword());
			if (password.equals(user.getPassword())) {
				return user;
			} else {
				return new User();
			}
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return new User();
		}
	}

	@Transactional
	public boolean userExists(String username) {
		Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username");
		query.setParameter("username", username);
		return (Long) query.getSingleResult() > 0;
	}

	@Transactional
	public User getUserByUsername(String username) {
		try {
			return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
}

