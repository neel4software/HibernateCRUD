package com.tb.dao;

public interface DataDao<T> {
	public void create(T entity);

	public T retrieve(int id, Class<T> clazz);

	public void update(T entity);

	public void delete(int id, Class<T> clazz);
}
