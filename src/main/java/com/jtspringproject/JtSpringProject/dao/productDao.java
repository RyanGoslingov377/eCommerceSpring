package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.Product;

@Repository
public class productDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<Product> getProducts() {
		return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}

	@Transactional
	public Product addProduct(Product product) {
		entityManager.persist(product);
		return product;
	}

	@Transactional
	public Product getProduct(int id) {
		return entityManager.find(Product.class, id);
	}

	@Transactional
	public Product updateProduct(Product product) {
		entityManager.merge(product);
		return product;
	}

	@Transactional
	public Boolean deleteProduct(int id) {
		Product product = entityManager.find(Product.class, id);
		if (product != null) {
			entityManager.remove(product);
			return true;
		}
		return false;
	}
}

