package com.dao;

import java.util.List;

import com.pojo.Customer;

public interface CustomerDao 
{
	boolean addCustomer(Customer customer);
	boolean updateCustomerByContact(Customer customer);
	boolean deleteCustomerByContact(String cEmailId);
	List<Customer>getAllCustomer();
	Customer searchCustomerByContact(String cEmailId);
}
