package dao;

import java.util.List;

import entity.Mark;

public interface MarkDao {
	
	void add(Mark mark);
	
	Mark get(int id);
	
	void update(Mark mark);
	
	List<Mark> getAll();
	
}
