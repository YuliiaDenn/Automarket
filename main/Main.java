package main;

import java.util.ArrayList;
import java.util.List;

import dao.AdvertisementDao;
import dao.AdvertisementDaoImpl;
import dao.MarkDao;
import dao.MarkDaoImpl;
import dao.ModelDao;
import dao.ModelDaoImpl;
import entity.Advertisement;
import entity.Mark;
import entity.Model;

public class Main {

	public static void main(String[] args) {
		AdvertisementDao adverDao = new AdvertisementDaoImpl();
		MarkDao markDao = new MarkDaoImpl();
		ModelDao modelDao = new ModelDaoImpl();

		

		System.out.println(markDao.getAll());
		System.out.println(modelDao.getAll());
		System.out.println(adverDao.getAll());

	}

}
