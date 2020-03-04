package com.ak.eventapi.dao;

import java.util.List;

import com.ak.eventapi.db.domain.EventEntity;


public interface EventDao extends BaseDao{
	    
	List<EventEntity> getEventList();
}
