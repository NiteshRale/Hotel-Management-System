package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Food;
import com.utility.DataConnect;

public class FoodDaoImpl implements FoodDao 
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Food food = null;
	
	@Override
	public boolean addFood(Food food) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("insert into Food values(?,?,?,?,?)");
			ps.setInt(1, food.getFoodId());
			ps.setString(2, food.getfName());
			ps.setString(3, food.getfType());
			ps.setInt(4,food.getfQuantity());
			ps.setFloat(5, food.getfPrice());
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
				
			}
			
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	
	
	@Override
	public boolean updateFoodById(Food food) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Update Food set fName = ?, fType = ?, fQuantity = ?, fPrice = ? where foodId = ? ");
			ps.setString(1, food.getfName());
			ps.setString(2, food.getfType());
			ps.setInt(3, food.getfQuantity());
			ps.setFloat(4, food.getfPrice());
			ps.setInt(5, food.getFoodId());
			
			int row = ps.executeUpdate();
			
			if(row > 0)
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	
	
	@Override
	public boolean deleteFoodById(int foodId) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Food where foodId = ?");
			ps.setInt(1, foodId);
			int row = ps.executeUpdate();
		
			if(row > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			
		}
		return false;
	}	
	
	
	@Override
	public List<Food> getAllFood() 
	{
		List<Food> l = new ArrayList<Food>();
		
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Food");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				food = new Food();
				food.setFoodId(rs.getInt("foodId"));
				food.setfName(rs.getString("fName"));
				food.setfType(rs.getString("fType"));
				food.setfQuantity(rs.getInt("fQuantity"));
				food.setfPrice(rs.getFloat("fPrice"));
				l.add(food);
			}
		}
		catch(Exception e)
		{
			
		}
		
		return l;
	}
	
	
	@Override
	public Food searchFoodById(int foodId) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Food where foodId = ?" );
			ps.setInt(1, foodId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				food = new Food();
				
				food.setfName(rs.getString("fName"));
				food.setFoodId(rs.getInt("foodId"));
				food.setfQuantity(rs.getInt("fQuantity"));
				food.setfType(rs.getString("fType"));
				food.setfPrice(rs.getFloat("fPrice"));
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		return food;
		
	}
}
