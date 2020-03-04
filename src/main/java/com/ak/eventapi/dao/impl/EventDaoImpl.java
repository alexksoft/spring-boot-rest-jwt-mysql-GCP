package com.ak.eventapi.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.ak.eventapi.dao.EventDao;
import com.ak.eventapi.db.domain.EventEntity;

@Component
public class EventDaoImpl extends BaseDaoImpl implements EventDao {
		
	@Override
	public List<EventEntity> getEventList() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<EventEntity> query = builder.createQuery(EventEntity.class);
		Root<EventEntity> root = query.from(EventEntity.class);
		query.select(root);
		return em.createQuery(query).getResultList();
	}

}
