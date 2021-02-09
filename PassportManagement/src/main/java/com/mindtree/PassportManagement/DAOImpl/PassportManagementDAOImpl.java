package com.mindtree.PassportManagement.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.PassportManagement.DAO.PassportManagementDAO;
import com.mindtree.PassportManagement.DAOException.DatabaseConnectionFailedException;
import com.mindtree.PassportManagement.DAOException.IDAbsentException;
import com.mindtree.PassportManagement.DAOException.IDPresentException;
import com.mindtree.PassportManagement.DAOException.PassportManagementDAOException;
import com.mindtree.PassportManagement.Entity.Passport;
import com.mindtree.PassportManagement.Entity.Person;
import com.mindtree.PassportManagement.Utility.JDBCConnection;

public class PassportManagementDAOImpl implements PassportManagementDAO
{

	private static JDBCConnection connection = new JDBCConnection();
	
	public boolean insertPassportIntoDB(Passport passport) throws PassportManagementDAOException
	{
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try 
		{
			
			con = connection.getConnection();
			String insertQuery = "Insert into Passport values(?,?)";
			ps = con.prepareStatement(insertQuery);

			ps.setString(1, passport.getId());
			ps.setInt(2, passport.getPassNumber());
			

			ps.executeUpdate();
			isInserted = true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (DatabaseConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}
		return isInserted;
		
	}

	public boolean insertPersonIntoDB(Person person) throws PassportManagementDAOException 
	{
		
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = connection.getConnection();
			String insertQuery = "Insert into Person values(?,?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, person.getpid());
			ps.setString(2, person.getName());
			ps.setString(3, person.getBirthplace());
			ps.setInt(4, person.getAge());

			ps.executeUpdate();
			isInserted = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (DatabaseConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}

		return isInserted;
		
	}
	public boolean getAllDetails(String pid) throws PassportManagementDAOException
	{
		
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con = connection.getConnection();
			String Query = "Select pid,name,birthplace,age,passNumber from Person inner join Passport on Passport.id=Person.pid ";
			ps= con.prepareStatement(Query);
			rs = ps.executeQuery();
			while (rs.next()) 
			{
				
				String id=rs.getString(1);
				String name=rs.getString(2);
				String birthplace=rs.getString(3);
				int age=rs.getInt(4);
				int pnum=rs.getInt(5);
				
				
				System.out.println("Person id:"+id);
				System.out.println("Person name:"+name);
				System.out.println("Birthplace:"+birthplace);
				System.out.println("Age:"+age);
				System.out.println("Passport Number:"+pnum);
			}	
		
			isInserted = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (DatabaseConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}

		return isInserted;
	}

	public boolean sortBirthplace() throws PassportManagementDAOException 
	{
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con = connection.getConnection();
			String Query = "Select name,birthplace from Person order by birthplace asc";
			ps= con.prepareStatement(Query);
			rs = ps.executeQuery();
			while (rs.next()) 
			{
				
				String name=rs.getString(1);
				String birthplace=rs.getString(2);
			
				System.out.println("Person name:"+name);
				System.out.println("Birthplace:"+birthplace);
				
			}	
		
			isInserted = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (DatabaseConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
		}
		// TODO Auto-generated method stub
		return isInserted;
	}

	public boolean checkPersonID(String pid) throws IDPresentException 
	{
		String peid=null;
		boolean isPresent = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			con = connection.getConnection();
			String query = "Select count(*) from Person where pid='" + pid + "'";
			ps = con.prepareStatement(query);

			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count==1) {
					isPresent = true;
					break;

				}
			}

			if (isPresent == true) {
				throw new IDPresentException("ID is Present");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
			connection.closeResources(resultSet);
		}

		// TODO Auto-generated method stub
		return isPresent;
	}

	public boolean checkPassportID(String id) throws IDAbsentException
	{
		String paid=null;
		boolean isPresent = true;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			con = connection.getConnection();
			String query = "Select count(*) from Passport where id='" + id + "'";
			ps = con.prepareStatement(query);

			resultSet = ps.executeQuery();
			while (resultSet.next()) 
			{
				int count = resultSet.getInt(1);
				if (count==0) 
				{
					isPresent = false;
					

				}
			}

			if (isPresent == false) {
				throw new IDPresentException("ID is absent");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			connection.closeResources(con);
			connection.closeResources(ps);
			connection.closeResources(resultSet);
		}

		return isPresent;
	}

	
	

}
