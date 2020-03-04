package com.ak.eventapi.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.ak.eventapi.dao.UserDao;
import com.ak.eventapi.db.domain.UserEntity;
import com.ak.eventapi.db.domain.UserRoleEntity;

@Component
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
		
	@Override
	public UserEntity findByUsername(String username) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = query.from(UserEntity.class);
		Fetch<UserEntity, UserRoleEntity> userRolesFetch = root.fetch("userRoles", JoinType.LEFT);
		userRolesFetch.fetch("appRole", JoinType.LEFT);
		query.select(root).where(builder.equal(root.get("username"), username));
		try {
			return em.createQuery(query).getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}

}
