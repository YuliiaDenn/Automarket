package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Advertisement;
import entity.Mark;
import entity.Model;

public class AdvertisementDaoImpl extends Dao implements AdvertisementDao {

	ModelDao modelDao = new ModelDaoImpl();
	MarkDao markdao = new MarkDaoImpl();

	@Override
	public void add(Advertisement adver) {

		Connection conn = getConnection();
		Statement stat = null;

		try {
			stat = conn.createStatement();
			stat.executeUpdate("insert into advertisement(year, price, model_id, mark_id) values ('" + adver.getYear()
					+ "', '" + adver.getPrice() + "', '" + adver.getModel().getId() + "', '" + adver.getMark().getId()
					+ "') ");

			stat.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Advertisement get(int id) {
		Connection conn = getConnection();
		Statement stat = null;
		Advertisement adver = new Advertisement();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from advertisement where id = " + id);
			rs.next();
			adver.setId(rs.getInt(1));
			adver.setYear(rs.getInt(2));
			adver.setPrice(rs.getDouble(3));
			Model model = modelDao.get(rs.getInt(4));
			adver.setModel(model);
			Mark mark = markdao.get(rs.getInt(5));
			adver.setMark(mark);
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return adver;
	}

	@Override
	public void update(Advertisement adver) {
		Connection conn = getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate("update advertisement set year = '" + adver.getYear() + "', price = '" + adver.getPrice()
					+ "'  where id = '" + adver.getId() + "' ");
			stat.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Advertisement> getAll() {
		Connection conn = getConnection();
		Statement stat = null;
		List<Advertisement> advers = new ArrayList<>();

		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from advertisement");
			while (rs.next()) {
				Advertisement adver = new Advertisement();
				adver.setId(rs.getInt(1));
				adver.setYear(rs.getInt(2));
				adver.setPrice(rs.getDouble(3));
				Model model = modelDao.get(rs.getInt(4));
				adver.setModel(model);
				Mark mark = markdao.get(rs.getInt(5));
				adver.setMark(mark);
				advers.add(adver);
			}
			stat.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return advers;
	}

}
