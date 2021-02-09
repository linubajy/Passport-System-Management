package com.mindtree.PassportManagement.ServiceImpl;

import java.util.List;

import com.mindtree.PassportManagement.DAO.PassportManagementDAO;
import com.mindtree.PassportManagement.DAOException.IDAbsentException;
import com.mindtree.PassportManagement.DAOException.IDPresentException;
import com.mindtree.PassportManagement.DAOException.PassportManagementDAOException;
import com.mindtree.PassportManagement.DAOImpl.PassportManagementDAOImpl;
import com.mindtree.PassportManagement.Entity.Passport;
import com.mindtree.PassportManagement.Entity.Person;
import com.mindtree.PassportManagement.Service.PassportManagementService;
import com.mindtree.PassportManagement.ServiceException.PassportManagementServiceException;

public class PassportManagementServiceImpl implements PassportManagementService {

	private static PassportManagementDAO dao=new PassportManagementDAOImpl();
	
	public boolean insertPassportIntoDB(Passport passport) throws PassportManagementServiceException
	{
		try {
			return dao.insertPassportIntoDB(passport);
		} catch (PassportManagementDAOException e) {
			throw new PassportManagementServiceException("Something is wrong in DB",e);
		}
		
		
	}

	public boolean insertPersonIntoDB(Person person) throws PassportManagementServiceException {
		
		try {
			return dao.insertPersonIntoDB(person);
		} catch (PassportManagementDAOException e) {
			throw new PassportManagementServiceException("Something is wrong in DB",e);
		}
		
	}
	public boolean getAllDetails(String pid) throws PassportManagementServiceException 
	{
		try {
			return dao.getAllDetails(pid);
		} catch (PassportManagementDAOException e) {
			throw new PassportManagementServiceException("Something is wrong in DB",e);
		}
	
	}

	public boolean sortBirthplace() throws PassportManagementServiceException
	{
		try {
			return dao.sortBirthplace();
		} catch (PassportManagementDAOException e) {
			throw new PassportManagementServiceException("Something is wrong in DB");
		}
	
	}

	public boolean checkPersonID(String pid) throws IDPresentException {
	
		try {
			return dao.checkPersonID(pid);
		}
		catch(IDPresentException e)
		{
			throw new IDPresentException("Person ID is present");
		}
		
	}

	public boolean checkPassportID(String id) throws IDAbsentException 
	{
		try {
			return dao.checkPassportID(id);
		}
		catch(IDAbsentException e)
		{
			throw new IDAbsentException("Person ID not present");
		}
		
		
	}


	

	

}
