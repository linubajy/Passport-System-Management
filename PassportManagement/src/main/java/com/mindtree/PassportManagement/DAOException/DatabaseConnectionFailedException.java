package com.mindtree.PassportManagement.DAOException;

import com.mindtree.PassportManagement.Exception.PassportManagementException;

public class DatabaseConnectionFailedException extends PassportManagementException
{

	public DatabaseConnectionFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectionFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectionFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectionFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectionFailedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
