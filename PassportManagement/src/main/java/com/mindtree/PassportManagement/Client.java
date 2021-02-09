package com.mindtree.PassportManagement;

import java.util.List;
import java.util.Scanner;

import com.mindtree.PassportManagement.DAOException.IDPresentException;
import com.mindtree.PassportManagement.Entity.Passport;
import com.mindtree.PassportManagement.Entity.Person;
import com.mindtree.PassportManagement.Exception.PassportManagementException;
import com.mindtree.PassportManagement.Service.PassportManagementService;
import com.mindtree.PassportManagement.ServiceException.PassportManagementServiceException;
import com.mindtree.PassportManagement.ServiceImpl.PassportManagementServiceImpl;


public class Client {

	static PassportManagementService passServ = new PassportManagementServiceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void displayMessage() {
		System.out.println("PASSPORT MANAGEMENT \n-----------------------------");
		System.out.println("1.CREATE A PERSON");
		System.out.println("2.CREATE A PASSPORT");
		System.out.println("3.GET DETAILS BASED ON PERSON ID");
		System.out.println("4.SORT BASED ON BIRTHPLACE");
		System.out.println("5.EXIT");
		System.out.println("ENTER THE CHOICE:");
	}

	public static void main(String args[]) {
		int ch = 0;
		int flag = 0;
		Passport passport = null;
		Person person = null;

		do {
			displayMessage();
			ch = sc.nextInt();
			switch (ch) {

			case 1:
				person = createPerson();
				if (person != null) {
					boolean isInserted = false;
					try {
						isInserted = passServ.insertPersonIntoDB(person);
					} catch (PassportManagementServiceException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					if (isInserted == true) {
						System.out.println("Inserted Successfully");
					}
				} else
					continue;

				break;
			case 2:

				passport = createPassport();
				if (passport != null) {
					boolean isInserted = false;
					try {
						isInserted = passServ.insertPassportIntoDB(passport);
					} catch (PassportManagementServiceException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					if (isInserted == true) {
						System.out.println("Inserted Successfully");
					}
				} else
					continue;

				break;

				
			case 3:
				
				System.out.println("Enter the person ID to display: ");
				String pid= sc.next();
				try {
					 	passServ.getAllDetails(pid);
					
				} catch (PassportManagementServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 4:
				
				try
				{
					passServ.sortBirthplace();
				}catch (PassportManagementServiceException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			
			
			case 5:
				
				flag=1;
				break;
				
			default:
				System.out.println("Invalid Choice, Please try Again");
			}
	
			

		} while (flag != 1);

	}

	private static Person createPerson() 
	{
		PassportManagementServiceImpl obj = new PassportManagementServiceImpl();

		Person person = null;
		System.out.println("Enter Person id:");
		String id = sc.next();
		try {
			boolean pre = obj.checkPersonID(id);
			if (pre == false) {
				System.out.println("Enter name: ");
				String name=sc.next();
				System.out.println("Enter the birthplace:");
				String birthplace = sc.next();
				System.out.println("Enter the age");
				int age=sc.nextInt();
				System.out.println("id"+id);
				person = new Person(id,name,birthplace,age);
			}
			
		} catch (IDPresentException e) {
			System.out.println(e.getMessage());
		}
		

		return person;
		
	}
	
	private static Passport createPassport() 
	{
		PassportManagementServiceImpl obj = new PassportManagementServiceImpl();

		Passport passport = null;
		System.out.println("Enter Passport id:");
		String id_input = sc.next();
		try {
			boolean pre = obj.checkPassportID(id_input);
			if (pre == false) {
				System.out.println("Enter Passport number: ");
				int passportNum = sc.nextInt();
				Person person=createPerson();
				passport = new Passport(id_input,passportNum,person);
			}
			else
			{
				throw new IDPresentException("ID doesn't exists!");
			}
		} catch (PassportManagementException e) {
			System.out.println(e.getMessage());
		}
		

		return passport;
		
	}

	
}
