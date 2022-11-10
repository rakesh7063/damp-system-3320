package com.job.usecases;

import java.util.Scanner;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.ProjectsBeen;

public class CreateProjectCase {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Project Name");
		String projectname = sc.next();
		
		System.out.println("Enter Project Number");
		
		int pnumber = sc.nextInt();
		
		System.out.println("Total Employee Working On Project");
		int totalEmployee = sc.nextInt();
		
		System.out.println("Total Wages of Project");
		
		int totalWages = sc.nextInt();
		
		System.out.println("Project Location");
		
		String plocation = sc.next();
		
		BDODao dao = new BDOImp();
		
		ProjectsBeen project = new ProjectsBeen(projectname, totalEmployee, totalWages, plocation,pnumber );
		
		try {
			String res = dao.CreateProject(project);
			System.out.println(res);
		} catch (BDOException e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		

		
		
		
	}

}
