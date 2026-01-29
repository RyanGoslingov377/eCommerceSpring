package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.userDao;
import com.jtspringproject.JtSpringProject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class userService {

	@Autowired
	private userDao userDao;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return this.userDao.getAllUser();
	}

	@Transactional
	public User addUser(User user) {
		try {
			return this.userDao.saveUser(user);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("РџРѕР»СЊР·РѕРІР°С‚РµР»СЊ СЃ С‚Р°РєРёРј РёРјРµРЅРµРј СѓР¶Рµ СЃСѓС‰РµСЃС‚РІСѓРµС‚", e);
		}
	}

	@Transactional(readOnly = true)
	public User checkLogin(String username, String password) {
		return this.userDao.getUser(username, password);
	}

	@Transactional(readOnly = true)
	public boolean checkUserExists(String username) {
		return this.userDao.userExists(username);
	}

	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Transactional(readOnly = true)
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
}

