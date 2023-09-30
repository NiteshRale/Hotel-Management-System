package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.FoodDaoImpl;
import com.pojo.Food;

public class FoodTest 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int foodId, fQuantity;
		String fName, fType;
		float fPrice;
		
		FoodDaoImpl foodObj = new FoodDaoImpl();
		
		while(true)
		{
			System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.ShowAllData\n6.Exit");
			System.out.println("Enter the choice : ");
			
			int choice = sc.nextInt();
			
			boolean b;
			
			switch(choice)
			{
			case 1 :
				System.out.println("How many items you want to add : ");
				int num = sc.nextInt();
				
				for(int i=1; i<=num; i++)
				{
					System.out.println("Enter the foodId : ");
					foodId = sc.nextInt();
					
					System.out.println("Enter the Food name : ");
					fName = br.readLine();
					
					System.out.println("Enter the Food Type : ");
					fType = br.readLine();
					
					System.out.println("Enter the Food Quantity : ");
					fQuantity = sc.nextInt();
					
					System.out.println("Enter the Food Price");
					fPrice = sc.nextFloat();
					
					b = foodObj.addFood(new Food(foodId, fName,fType,fQuantity,fPrice));
					
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
				
				System.out.println("Enter the foodId : ");
				foodId = sc.nextInt();
				
				System.out.println("Enter the Food name : ");
				fName = br.readLine();
				
				System.out.println("Enter the Food Type : ");
				fType = br.readLine();
				
				System.out.println("Enter the Food Quantity : ");
				fQuantity = sc.nextInt();
				
				System.out.println("Enter the Food Price");
				fPrice = sc.nextFloat();
				
				b = foodObj.updateFoodById(new Food(foodId, fName,fType,fQuantity,fPrice));
				

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
				
				System.out.println("Enter the foodId for Delete : ");
				
				foodId = sc.nextInt();
				
				b = foodObj.deleteFoodById(foodId);
				

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
				
				System.out.println("Enter the foodId for search : ");
				
				foodId = sc.nextInt();
				
				Food food = new Food();
				
				food = foodObj.searchFoodById(foodId);
				
				if(food!=null && foodId==food.getFoodId())
				{
					System.out.println(food);
				}
				else
				{
					System.out.println("Not Available");
				}
				break;
				
			case 5 :
				
				System.out.println("Show all Data");
				
				List<Food> l = new ArrayList<Food>();
				
				l = foodObj.getAllFood();
				
				Iterator<Food> it = l.iterator();                                                    
				
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
