package main;

import java.util.List;

import dao.MarkDao;
import dao.MarkDaoImpl;
import dao.ModelDao;
import dao.ModelDaoImpl;
import entity.Mark;
import entity.Model;

public class Main {

	public static void main(String[] args) {
		
		MarkDao markDao = new MarkDaoImpl();
		ModelDao modelDao = new ModelDaoImpl();
		
		
		Model model = modelDao.get(1);
		Mark mark = model.getMark();
		
		
		System.out.println(mark);
		System.out.println(model);
	}

}
