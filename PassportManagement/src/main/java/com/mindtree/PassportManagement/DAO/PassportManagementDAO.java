package com.mindtree.PassportManagement.DAO;

import java.util.List;

import com.mindtree.PassportManagement.DAOException.IDAbsentException;
import com.mindtree.PassportManagement.DAOException.IDPresentException;
import com.mindtree.PassportManagement.DAOException.PassportManagementDAOException;
import com.mindtree.PassportManagement.Entity.Passport;
import com.mindtree.PassportManagement.Entity.Person;

public interface PassportManagementDAO 
{

	public boolean insertPassportIntoDB(Passport passport) throws PassportManagementDAOException;
	public boolean insertPersonIntoDB(Person person) throws PassportManagementDAOException;
	
	public boolean getAllDetails(String pid) throws PassportManagementDAOException;
	public boolean sortBirthplace() throws PassportManagementDAOException;
	
	public boolean  checkPersonID(String pid) throws IDPresentException;
	public boolean checkPassportID(String id) throws IDAbsentException;
	
	
}
