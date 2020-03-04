package com.ak.eventapi.dao;

public interface BaseDao {
	public void reload(Object obj);

	public Object save(Object obj);
	
	public void delete(Object obj);

	public <T> T merge(Object obj);

	public <T> T get(Class<T> clazz, Integer id);
	
	
	

}
