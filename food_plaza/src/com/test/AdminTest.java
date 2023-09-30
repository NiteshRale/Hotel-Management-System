package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dao.AdminDaoImpl;
import com.dao.CustomerDaoImpl;

public class AdminTest 
{

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String cEmailId, cPassword, aEmailId, aPassword ; 
		
		AdminDaoImpl adObj = new AdminDaoImpl();
		
		while(true)
		{
			System.out.println("1.User Login\n2.User Change Password\n3.Admin Login\n4.Admin Change Password\n5.Exit");
			System.out.println("Enter the choice : ");
			
			int choice = sc.nextInt();
			
			boolean b;
			
			switch(choice)
			{
			case 1 :
				
				System.out.println("Enter the Email Id : ");
				cEmailId = br.readLine();
				
				System.out.println("Enter the password : ");
				cPassword = br.readLine();
				
				b = adObj.userLogin(cEmailId, cPassword);
				
				if(b)
				{
					System.out.println("Login Successfully");
				}
				else
				{
					System.out.println("Login Failed");
				}
				
				break;
				
				
			case 2 :
				
				System.out.println("Enter the Existing emailId : ");
				cEmailId = br.readLine();
				
				System.out.println("Enter the new password : ");
				cPassword = br.readLine();
				
				b = adObj.userchangepassword(cEmailId, cPassword);
				
				if(b)
				{
					System.out.println("Password change Successfully");
				}
				else
				{
					System.out.println("Invalid EmailId");
				}
				
				break;
				
			case 3 :
				
				System.out.println("Enter the Email Id : ");
				aEmailId = br.readLine();
				
				System.out.println("Enter the password : ");
				aPassword = br.readLine();
				
				b = adObj.adminLogin(aEmailId, aPassword);
				
				if(b)
				{
					System.out.println("Login Successfully");
				}
				else
				{
					System.out.println("Login Failed");
				}
				
				break;
				
				
			case 4 :
				
				System.out.println("Enter the Existing emailId : ");
				aEmailId = br.readLine();
				
				System.out.println("Enter the new password : ");
				aPassword = br.readLine();
				
				b = adObj.adminchangepassword(aEmailId, aPassword);
				
				if(b)
				{
					System.out.println("Password change Successfully");
				}
				else
				{
					System.out.println("Invalid EmailId");
				}
				
				break;
				
			case 5 :
				System.exit(0);
			
			}//Switch End
		}//While end
	}

}
