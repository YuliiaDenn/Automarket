package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			stat.executeUpdate("insert into model(model,mark_id) values('" + model.getModel() + "','"
					+ model.getMark().getId() + "')");
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public Model get(int  id) {
		Connection conn = getConnection();
		Statement stat = null;
		Model model = new Model();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from model where id = " + id);
			rs.next();
			model.setId(rs.getInt(1));
			model.setModel(rs.getString(2));
			Mark mark = markDao.get(rs.getInt(3));
			model.setMark(mark);
			stat.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return model;
	}

	@Override
	public void update(Model model) {
		Connection conn = getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(
					"update model set model = '" + model.getModel() + "' where id = '" + model.getId() + "'");
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Model> getAll() {

		Connection conn = getConnection();
		Statement stat = null;
		List<Model> models = new ArrayList<>();

		try {
			stat = conn.createStatement();
			ResultSet rs = null;
			rs = stat.executeQuery("select * from model");
			Model model = null;
			while (rs.next()) {
				model = new Model();
				model.setId(rs.getInt(1));
				model.setModel(rs.getString(2));
				Mark mark = markDao.get(rs.getInt(3));
				model.setMark(mark);
				models.add(model);

			}
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return models;
	}

}
