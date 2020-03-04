package com.ak.eventapi.service;

import com.ak.eventapi.db.domain.UserEntity;

public interface UserService
{
	UserEntity findByUsername(String username);
}
