package dao;

import java.util.List;

import entity.Advertisement;

public interface AdvertisementDao {

	void add(Advertisement adver);

	Advertisement get(int id);

	void update(Advertisement adver);

	List<Advertisement> getAll();

}
