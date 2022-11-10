package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.job.exception.BDOException;
import com.job.modelClass.BDOBenn;
import com.job.modelClass.Employee;
import com.job.modelClass.GPMBenn;
import com.job.modelClass.ProjectsBeen;
import com.job.utility.DBUtility;

public class BDOImp implements BDODao {

	@Override
	public BDOBenn BDOLogIn(String username, String password) throws BDOException {
		BDOBenn bdo = null;
		
		try(Connection conn = DBUtility.ProvideConnetion()) {
			
		PreparedStatement ps = conn.prepareStatement(" select username from bdo where username= ? AND password= ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
		ResultSet rs =	ps.executeQuery();
		
		if(rs.next()) {
			
			String name = rs.getString("username");
			
		bdo = new BDOBenn();
			bdo.setUsername(name);
			
		}
		else {
			throw new BDOException("Invalid Username or password..");
		}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDOException(e.getMessage());
			
			
		}
		
		
		
		
		
		
		return bdo;
	}

	@Override
	public String CreateProject(ProjectsBeen pro) throws BDOException {
		
String message = "Not Inserted";
		
		try (Connection conn=DBUtility.ProvideConnetion()){
			PreparedStatement ps = conn.prepareStatement("insert into projects values(?,?,?,?,?)");
			
			ps.setString(1, pro.getName());
			ps.setInt(2, pro.getProectNo());
			ps.setString(3, pro.getLocation());
			ps.setInt(4, pro.getNoOfEmployee());
			ps.setInt(5, pro.getTotalWages());
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				message="Project added successfully......";
			}
			
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new BDOException(e.getMessage());
			}
			return message;
		
		
	}

	@Override
	public List<ProjectsBeen> ListOfProjects() throws BDOException {
List<ProjectsBeen> project= new ArrayList<>();
		
		

		try(Connection conn= DBUtility.ProvideConnetion()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Projects");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				String n= rs.getString("pname");
				int pno = rs.getInt("projectNo");
				String add=rs.getString("paddress");
				int list_of_employeeworking=rs.getInt("noOfEmployee");
				int wages= rs.getInt("totalwages");
				
				
				ProjectsBeen pro= new ProjectsBeen(n, list_of_employeeworking, wages, add, pno);
				project.add(pro);

			}
			
			  
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new BDOException(e.getMessage());
		}
		
		
		
		
		return project;
		
		
		
	}

	@Override
	public String CreateGramPanchayatMember(GPMBenn gpm) throws BDOException {
		String result ="Not Created";
		
		try (Connection conn = DBUtility.ProvideConnetion()) {
			PreparedStatement ps = conn.prepareStatement("insert into gpm (gname,gaddress,gphone,username,password) values(?,?,?,?,?)");
			
			ps.setString(1, gpm.getName());
			ps.setString(2, gpm.getLocation());
			ps.setString(3, gpm.getPhoneNo());
			ps.setString(4, gpm.getUsername());
			ps.setString(5, gpm.getPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Gram Panchayat Member created succesfuly....";
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDOException(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}

	@Override
	public List<GPMBenn> ListOfGMP() throws BDOException {
List<GPMBenn> gpms= new ArrayList<>();
		
		

		try(Connection conn= DBUtility.ProvideConnetion()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from gpm");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("gid");
				String name = rs.getString("gname");
				String address= rs.getString("gaddress");
				String phone= rs.getString("gphone");
				String user= rs.getString("username");
				String password= rs.getString("password");
				
				GPMBenn gpm = new GPMBenn();
				gpm.setId(id);
				gpm.setName(name);
				gpm.setLocation(address);
				gpm.setPhoneNo(phone);
				gpm.setUsername(user);
				gpm.setPassword(password);
				
				gpms.add(gpm);

			}
			
			  
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new BDOException(e.getMessage());
		}
		
		
		
		
		return gpms;
	}

	

	
	

}
