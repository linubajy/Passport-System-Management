package com.mindtree.PassportManagement.Service;

import java.util.List;

import com.mindtree.PassportManagement.DAOException.IDAbsentException;
import com.mindtree.PassportManagement.DAOException.IDPresentException;
import com.mindtree.PassportManagement.Entity.Passport;
import com.mindtree.PassportManagement.Entity.Person;
import com.mindtree.PassportManagement.ServiceException.PassportManagementServiceException;

public interface PassportManagementService
{

	public boolean insertPassportIntoDB(Passport passport) throws PassportManagementServiceException;
	public boolean insertPersonIntoDB(Person person) throws PassportManagementServiceException;
	
	public boolean getAllDetails(String pid) throws PassportManagementServiceException;
	public boolean sortBirthplace() throws PassportManagementServiceException;
	
	public boolean  checkPersonID(String pid) throws IDPresentException;
	public boolean checkPassportID(String id) throws IDAbsentException;


}
