package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.Cart;

@Repository
public class cartDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Cart addCart(Cart cart) {
        entityManager.persist(cart);
        return cart;
    }

    @Transactional
    public List<Cart> getCarts() {
        return entityManager.createQuery("SELECT c FROM Cart c", Cart.class).getResultList();
    }

    @Transactional
    public void updateCart(Cart cart) {
        entityManager.merge(cart);
    }

    @Transactional
    public void deleteCart(Cart cart) {
        entityManager.remove(entityManager.contains(cart) ? cart : entityManager.merge(cart));
    }
}

