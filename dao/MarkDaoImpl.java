package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Mark;

public class MarkDaoImpl extends Dao implements MarkDao {

	@Override
	public void add(Mark mark) {
		Connection conn = getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate("insert into mark(mark) values('" + mark.getMark() + "')");
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Mark get(int id) {

		Connection conn = getConnection();
		Statement stat = null;
		Mark mark = new Mark();

		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from mark where id = '" + id + "' ");
			rs.next();
			mark.setId(rs.getInt(1));
			mark.setMark(rs.getString(2));
			conn.close();
			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mark;
	}

	@Override
	public void update(Mark mark) {

		Connection conn = getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate("update mark set mark = '" + mark.getMark() + "' where id = '" + mark.getId() + "' ");
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Mark> getAll() {

		Connection conn = getConnection();
		Statement stat = null;
		List<Mark> marks = new ArrayList<>();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from mark");
			Mark mark = null;
			while (rs.next()) {
				mark = new Mark();
				mark.setId(rs.getInt(1));
				mark.setMark(rs.getString(2));
				marks.add(mark);
			}
			stat.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return marks;
	}

}
