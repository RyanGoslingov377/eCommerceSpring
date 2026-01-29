package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.CartProduct;
import com.jtspringproject.JtSpringProject.models.Product;

@Repository
public class cartProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public CartProduct addCartProduct(CartProduct cartProduct) {
        entityManager.persist(cartProduct);
        return cartProduct;
    }

    @Transactional
    public List<CartProduct> getCartProducts() {
        return entityManager.createQuery("SELECT cp FROM CartProduct cp", CartProduct.class).getResultList();
    }

    @Transactional
    public List<Product> getProductByCartID(Integer cart_id) {
        List<Integer> productIds = entityManager.createNativeQuery("SELECT product_id FROM cart_products WHERE cart_id = :cart_id")
                .setParameter("cart_id", cart_id)
                .getResultList();

        if (productIds.isEmpty()) {
            return List.of();
        }

        return entityManager.createNativeQuery("SELECT * FROM products WHERE id IN (:product_ids)", Product.class)
                .setParameter("product_ids", productIds)
                .getResultList();
    }

    @Transactional
    public void updateCartProduct(CartProduct cartProduct) {
        entityManager.merge(cartProduct);
    }

    @Transactional
    public void deleteCartProduct(CartProduct cartProduct) {
        entityManager.remove(entityManager.contains(cartProduct) ? cartProduct : entityManager.merge(cartProduct));
    }
}

