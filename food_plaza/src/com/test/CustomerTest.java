package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDaoImpl;
import com.pojo.Customer;

public class CustomerTest 
{

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String cName, cEmailId, cPassword, cAddress, cContactNo; 
		
		CustomerDaoImpl customerObj = new CustomerDaoImpl();
		
		while(true)
		{
			System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.ShowAllData\n6.Exit");
			System.out.println("Enter the choice : ");
			
			int choice = sc.nextInt();
			
			boolean b;
			
			switch(choice)
			{
			case 1 :
				System.out.println("How many customer you want to add : ");
				int num = sc.nextInt();
				
				for(int i=1; i<=num; i++)
				{
					System.out.println("Enter the Customer Name : ");
					cName = br.readLine();
					
					System.out.println("Enter the Customer EmailId : ");
					cEmailId = br.readLine();
					
					System.out.println("Enter the Customer Password : ");
					cPassword = br.readLine();
					
					System.out.println("Enter the Customer Address : ");
					cAddress = br.readLine();
					
					System.out.println("Enter the Customer Contact No. : ");
					cContactNo = br.readLine();
					
					b = customerObj.addCustomer(new Customer(cName, cEmailId, cPassword, cAddress, cContactNo));
					
					if(b)
					{
						System.out.println("Successfully");
					}
					else
					{
						System.out.println("Failed");
					}
				}
				break;
				
			case 2: 
				
				System.out.println("Enter the Customer Name : ");
				cName = br.readLine();
				
				System.out.println("Enter the Customer EmailId : ");
				cEmailId = br.readLine();
				
				System.out.println("Enter the Customer Password : ");
				cPassword = br.readLine();
				
				System.out.println("Enter the Customer Address : ");
				cAddress = br.readLine();
				
				System.out.println("Enter the Customer Contact No. : ");
				cContactNo = br.readLine();
				
				b = customerObj.updateCustomerByContact(new Customer(cName, cEmailId, cPassword, cAddress, cContactNo));
				
				if(b)
				{
					System.out.println("Successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 3 :
				
				System.out.println("Enter the Contact No for Delete : ");
				
				cContactNo = sc.next();
				
				b = customerObj.deleteCustomerByContact(cContactNo);
				

				if(b)
				{
					System.out.println("Successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				
				break;
				
			case 4 : 
				
				System.out.println("Enter the Contact No for search : ");
				
				cContactNo = sc.next();
				
				Customer customer = new Customer();
				
				customer = customerObj.searchCustomerByContact(cContactNo);
				
//				boolean e = customer!=null && cContactNo==customer.getcContactNo();
//				
//				System.out.println(e);//FALSE
				
//				System.out.println(customer.getcContactNo()); //NpE
				
				if(customer!=null && cContactNo.equals(customer.getcContactNo()))
				{
					System.out.println(customer);
				}
				else
				{
					System.out.println("Not Available");
				}
				break;
				
			case 5 :
				
				System.out.println("Show all Data");
				
				List<Customer> l1 = new ArrayList<Customer>();
				
				l1 = customerObj.getAllCustomer();
				
				Iterator<Customer> it = l1.iterator();                                                    
				
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
				
			case 6 :
				System.exit(0);
				
			}//Switch
		}//While
	
		
		

	}

}
