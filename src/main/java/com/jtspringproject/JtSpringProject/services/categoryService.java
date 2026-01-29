package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.dao.categoryDao;
import com.jtspringproject.JtSpringProject.models.Category;

@Service
public class categoryService {
	@Autowired
	private categoryDao categoryDao;

	@Transactional
	public Category addCategory(String name) {
		return this.categoryDao.addCategory(name);
	}

	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		return this.categoryDao.getCategories();
	}

	@Transactional
	public Boolean deleteCategory(int id) {
		return this.categoryDao.deleteCategory(id);  // в†ђ Р·РґРµСЃСЊ Р±С‹Р»Рѕ deletCategory в†’ РёСЃРїСЂР°РІР»РµРЅРѕ
	}

	@Transactional
	public Category updateCategory(int id, String name) {
		return this.categoryDao.updateCategory(id, name);
	}

	@Transactional(readOnly = true)
	public Category getCategory(int id) {
		return this.categoryDao.getCategory(id);
	}
}

