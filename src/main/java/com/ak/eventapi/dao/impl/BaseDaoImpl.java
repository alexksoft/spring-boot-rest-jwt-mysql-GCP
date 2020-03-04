package com.ak.eventapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ak.eventapi.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

    @PersistenceContext
    protected EntityManager em;

	protected Logger log = LogManager.getLogger(this.getClass());

	@Override
	public void reload(Object obj) {
		log.debug("Reloading object: " + obj.getClass());
		em.refresh(obj);
	}

	@Override
	public Object save(Object obj) {
		log.debug("Saving object: " + obj.getClass());
		em.merge(obj);
		return obj;
	}

	@Override
	public void delete(Object obj) {
		log.debug("Deleting object: " + obj.getClass());
		em.remove(obj);
	}
	
	@Override
	public <T> T merge(Object obj) {
		T o = (T) em.merge(obj);
		return o;
	}

	@Override
	public <T> T get(Class<T> clazz, Integer id){
		return (T) em.find(clazz, id);
	}
}
