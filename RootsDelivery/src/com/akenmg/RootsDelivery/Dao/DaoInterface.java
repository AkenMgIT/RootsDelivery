package com.akenmg.RootsDelivery.Dao;

import java.util.List;

public interface DaoInterface<T> {
	public void create(T obj);
	public T find(int id);
	public void delete(int id);
	public void update(T obj);
	public List<T> getAll();
}
