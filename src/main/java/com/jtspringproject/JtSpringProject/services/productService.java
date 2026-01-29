package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.dao.productDao;
import com.jtspringproject.JtSpringProject.models.Product;

@Service
public class productService {
	@Autowired
	private productDao productDao;

	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return this.productDao.getProducts();
	}

	@Transactional
	public Product addProduct(Product product) {
		return this.productDao.addProduct(product);
	}

	@Transactional(readOnly = true)
	public Product getProduct(int id) {
		return this.productDao.getProduct(id);
	}

	@Transactional
	public Product updateProduct(int id, Product product) {
		product.setId(id);  // РµСЃР»Рё РЅСѓР¶РЅРѕ СЏРІРЅРѕ СѓСЃС‚Р°РЅРѕРІРёС‚СЊ ID (РЅР° РІСЃСЏРєРёР№ СЃР»СѓС‡Р°Р№)
		return this.productDao.updateProduct(product);
	}

	@Transactional
	public boolean deleteProduct(int id) {
		return this.productDao.deleteProduct(id);  // в†ђ Р·РґРµСЃСЊ Р±С‹Р»Рѕ deletProduct в†’ РёСЃРїСЂР°РІР»РµРЅРѕ
	}
}

