package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Cart;
import com.pojo.Customer;
import com.utility.DataConnect;

public class CartDaoImpl implements CartDao
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Cart cart = null;
	
	
	@Override
	public boolean addCart(Cart cart) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("insert into Cart values(?,?,?,?,?,?,?)");
			ps.setInt(1, cart.getCartId());
			ps.setInt(2, cart.getFoodId());
			ps.setInt(3, cart.getQuantity());
			ps.setString(4, cart.getEmailId());
			ps.setString(5, cart.getFoodName());
			ps.setDouble(6, cart.getPrice());
			ps.setDouble(7, cart.getTotalPrice());
			
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
	public List<Cart> ShowCart(String emailId) 
	{
		List<Cart> l1 = new ArrayList<Cart>();
		
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Cart where emailId = ?");
			ps.setString(1, emailId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				cart = new Cart();
				
				cart.setCartId(rs.getInt("CartId"));
				cart.setFoodId(rs.getInt("FoodId"));
				cart.setQuantity(rs.getInt("Quantity"));
				cart.setEmailId(rs.getString("EmailId"));
				cart.setFoodName(rs.getString("FoodName"));
				cart.setPrice(rs.getFloat("Price"));
				cart.setTotalPrice(rs.getFloat("TotalPrice"));
				
				l1.add(cart);
			}
		}
		catch(Exception e)
		{
			
		}
		
		return l1;
		
	}
	
	@Override
	public boolean deleteCart(int cartId) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Cart where cartId = ?");
			ps.setInt(1, cartId);
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
	public boolean clearCart(String emailId) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Cart where emailId = ?");
			ps.setString(1, emailId);
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
}
