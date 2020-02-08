package dao;

import entity.Mark;
import java.util.List;

public interface MarkDao {

	void add(Mark mark);

	Mark get(int id);

	void update(Mark mark);

	List<Mark> getAll();

}
