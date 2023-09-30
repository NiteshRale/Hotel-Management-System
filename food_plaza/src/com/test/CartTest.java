
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CartDaoImpl;
import com.pojo.Cart;
import com.pojo.Customer;

public class CartTest 
{

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cartId, foodId, quantity;
		String emailId, foodName;
		float price, totalPrice;
		
		CartDaoImpl cartObj = new CartDaoImpl();
		
		while(true)
		{
			System.out.println("1.Add\n2.ShowAllData\n3.Delete\n4.Clear\n5.Exit");
			System.out.println("Enter the choice : ");
			
			int choice = sc.nextInt();
			
			boolean b;
			
			switch(choice)
			{

			case 1 :
				System.out.println("How many Products you want to add : ");
				int num = sc.nextInt();
				
				for(int i=1; i<=num; i++)
				{
					System.out.println("Enter the Cart ID : ");
					cartId = sc.nextInt();
					
					System.out.println("Enter the Food ID : ");
					foodId = sc.nextInt();
					
					System.out.println("Enter the Quantity : ");
					quantity = sc.nextInt(); 
					
					System.out.println("Enter the Email ID : ");
					emailId = br.readLine();
					
					System.out.println("Enter the Food Name : ");
					foodName = br.readLine();
					
					System.out.println("Enter the Price : ");
					price = sc.nextFloat();
					
					totalPrice = quantity * price;
					
					b = cartObj.addCart(new Cart(cartId, foodId, quantity, emailId, foodName, price ,totalPrice));
					
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
				
				
			case 2 :
				
				System.out.println("Show all Data");
				
				List<Cart> l1 = new ArrayList<Cart>();
				
				System.out.println("Enter Email Id : ");
				emailId = sc.next();
				
				l1 = cartObj.ShowCart(emailId);
				
				Iterator<Cart> it = l1.iterator();                                                    
				
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
				
				
			case 3 :
				
				System.out.println("Enter the Cart Id for Delete : ");
				
				cartId = sc.nextInt();
				
				b = cartObj.deleteCart(cartId);
				

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
				
				System.out.println("Enter the Email Id for Delete : ");
				
				emailId = sc.next();
				
				b = cartObj.clearCart(emailId);
				

				if(b)
				{
					System.out.println("Successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				
				break;
				
			case 5 :
				System.exit(0);
				
				
				
			}//switch end
	  }//while End

	}//main end
}//class end
