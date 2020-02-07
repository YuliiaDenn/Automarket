package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import entity.Mark;
import entity.Model;

public class ModelDaoImpl extends Dao implements ModelDao {

	private MarkDao markDao = new MarkDaoImpl();
	
	@Override
	public void add(Model model) {
		Connection conn = getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate("insert into model(model,mark_id) values('"+model.getModel()+"','"+model.getMark().getId()+"')" );
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Model get(int id) {
		Connection conn = getConnection(); // get connection 
		Statement stat = null; // create statement link
		Model model = new Model();  // create mark object
		try {
			stat = conn.createStatement();  // create statement
			ResultSet rs = stat.executeQuery("select * from model where id = " + id + "");// exec statement
			rs.next(); // get first element of result
			model.setId(rs.getInt(1)); // set mark id
			model.setModel(rs.getString(2)); // set mark name
			Mark mark = markDao.get(rs.getInt(3));
			model.setMark(mark);
			stat.close(); // close stat
			conn.close(); // close connection
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
