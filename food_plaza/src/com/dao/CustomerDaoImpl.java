package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Customer;
import com.pojo.Food;
import com.utility.DataConnect;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Customer customer = null;
	
	
	@Override
	public boolean addCustomer(Customer customer) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("insert into Customer values(?,?,?,?,?)");
			ps.setString(1, customer.getcName());
			ps.setString(2, customer.getcEmailId());
			ps.setString(3, customer.getcPassword());
			ps.setString(4,customer.getcAddress());
			ps.setString(5, customer.getcContactNo());
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
	public boolean updateCustomerByContact(Customer customer) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Update Customer set cName = ?, cEmailId = ?, cPassword = ?, cAddress = ? where cContactNo = ? ");
			ps.setString(1, customer.getcName());
			ps.setString(2, customer.getcEmailId());
			ps.setString(3, customer.getcPassword());
			ps.setString(4, customer.getcAddress());
			ps.setString(5, customer.getcContactNo());
			
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
	public boolean deleteCustomerByContact(String cContactNo) 
	{
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Customer where cContactNo = ?");
			ps.setString(1, cContactNo);
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
	public List<Customer> getAllCustomer() 
	{
		List<Customer> l1 = new ArrayList<Customer>();
		
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Customer");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				customer = new Customer();
				customer.setcName(rs.getString("cName"));
				customer.setcEmailId(rs.getString("cEmailId"));
				customer.setcPassword(rs.getString("cPassword"));
				customer.setcAddress(rs.getString("cAddress"));
				customer.setcContactNo(rs.getString("cContactNo"));
				l1.add(customer);
			}
		}
		catch(Exception e)
		{
			
		}
		
		return l1;
		
	}
	
	
	public Customer searchCustomerByContact(String cContactNo) 
	{
		
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Customer where cContactNo = ?");
			ps.setString(1,cContactNo);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				customer = new Customer();
				
				customer.setcName(rs.getString("cName"));
				customer.setcEmailId(rs.getString("cEmailId"));
				customer.setcPassword(rs.getString("cPassword"));
				customer.setcAddress(rs.getString("cAddress"));
				customer.setcContactNo(rs.getString("cContactNo"));
				
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		return customer;
	}
}
