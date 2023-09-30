package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pojo.Order;
import com.utility.DataConnect;

public class OrderDaoImpl implements OrderDao
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	int orderId;
	
	
	public Order placeOrder(String emailId) 
	{
		String ODate = new Date().toString();
		float totalPrice = 0;
		Order o = null;
		
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("select sum(totalPrice) as total from Cart where emailId = ?");
			ps.setString(1, emailId);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				totalPrice =  rs.getFloat("total");//here total is from above Aggregate total
			}
			if(totalPrice>0)
			{
				ps = con.prepareStatement("insert into Orders(orderId, emailId, totalPrice, ODate) values(?,?,?,?)");/////////////////////
				ps.setInt(1, orderId);
				ps.setString(2, emailId);
				ps.setFloat(3, totalPrice);
				ps.setString(4, ODate);
				row = ps.executeUpdate();
			}
			if(row>0)
			{
				ps = con.prepareStatement("select * from Orders where emailId = ? and ODate = ?");
				ps.setString(1, emailId);
				ps.setString(2, ODate);
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					o = new Order();
					o.setOrderId(rs.getInt("orderId"));///////////////////////////////
					o.setEmailId(rs.getString("emailId"));
					o.setTotalPrice(rs.getFloat("totalPrice"));
					o.setDate(rs.getString("ODate"));
				}
			}
		}
		catch(Exception e)
		{
			
		}
		return o;
	}
	
	public List<Order> showOrder() 
	{
		List<Order>l = new ArrayList<>();
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("select * from Orders");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setEmailId(rs.getString("emailId"));
				o.setTotalPrice(rs.getFloat("totalPrice"));
				o.setDate(rs.getString("ODate"));
				l.add(o);
			}
		}
		catch(Exception s)
		{
			
		}
		return l;
	}
	
}
