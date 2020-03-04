package com.ak.eventapi.dao;

import com.ak.eventapi.db.domain.UserEntity;


public interface UserDao extends BaseDao{
	    
	UserEntity findByUsername(String username);
}
