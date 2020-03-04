package com.ak.eventapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak.eventapi.dao.UserDao;
import com.ak.eventapi.db.domain.UserEntity;
import com.ak.eventapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
    UserDao userDao;
    
    @Transactional(readOnly = true)
    @Override
    public UserEntity findByUsername(String username) {
        return userDao.findByUsername(username);
	}

}
