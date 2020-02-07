package dao;

import java.util.List;

import entity.Model;

public interface ModelDao {

	void add(Model model);
	
	Model get(int id);
	
	void update(Model model);
	
	List<Model> getAll();
	
}
