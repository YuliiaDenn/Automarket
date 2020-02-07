package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Mark;

public class MarkDaoImpl extends Dao implements MarkDao {
	
	public void add(Mark mark) {
		Connection conn = getConnection(); // get connection
		Statement stat = null; // create statement link
		try {
			stat = conn.createStatement(); // create statement - обєкт запроса ок?
			stat.executeUpdate("insert into mark(mark) values('" + mark.getMark() + "')"); //exec statement
			stat.close(); // close statement
			conn.close(); // close connection
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Mark get(int id) {
		Connection conn = getConnection(); // get connection 
		Statement stat = null; // create statement link
		Mark mark = new Mark();  // create mark object
		try {
			stat = conn.createStatement();  // create statement
			ResultSet rs = stat.executeQuery("select * from mark where id = " + id + "");// exec statement
			rs.next(); // get first element of result
			mark.setId(rs.getInt(1)); // set mark id
			mark.setMark(rs.getString(2)); // set mark name
			stat.close(); // close stat
			conn.close(); // close connection
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mark;
	}

	public void update(Mark mark) {
		Connection conn = getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate("update mark set mark = '"+mark.getMark()+"' where id = "+mark.getId()+" ");
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Mark> getAll() {
		Connection conn = getConnection();
		Statement stat = null;
		List<Mark> marks = new ArrayList<>();
		
		try {
			
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from mark");
			Mark mark = null;
			while(rs.next()) {
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
