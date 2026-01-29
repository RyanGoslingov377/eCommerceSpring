package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.Category;

@Repository
public class categoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Category addCategory(String name) {
		Category category = new Category();
		category.setName(name);
		entityManager.persist(category);
		return category;
	}

	@Transactional
	public List<Category> getCategories() {
		return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
	}

	@Transactional
	public Boolean deleteCategory(int id) {
		Category category = entityManager.find(Category.class, id);
		if (category != null) {
			entityManager.remove(category);
			return true;
		}
		return false;
	}

	@Transactional
	public Category updateCategory(int id, String name) {
		Category category = entityManager.find(Category.class, id);
		if (category != null) {
			category.setName(name);
			entityManager.merge(category);
		}
		return category;
	}

	@Transactional
	public Category getCategory(int id) {
		return entityManager.find(Category.class, id);
	}
}

