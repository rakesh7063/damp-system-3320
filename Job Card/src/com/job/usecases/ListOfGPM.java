package com.job.usecases;

import java.util.List;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.GPMBenn;

public class ListOfGPM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BDODao daos =new BDOImp();

	try {
		List<GPMBenn> dao =	daos.ListOfGMP();
		dao.forEach(s -> System.out.println(s));
		
	} catch (BDOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	}
		
	}

}
