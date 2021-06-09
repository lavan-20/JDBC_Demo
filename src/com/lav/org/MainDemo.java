package com.lav.org;

import java.sql.Connection;
import java.sql.SQLException;

import com.lav.org.dao.CustomerDAO;
import com.lav.org.dao.DataAccessObject;
import com.lav.org.dao.OrderDAO;
import com.lav.org.dto.Customer;
import com.lav.org.dto.Orders;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Hey I am here");

		DatabaseConnectionManager manager = new DatabaseConnectionManager("jdbc:postgresql://localhost:5432/SuperLeague",
				"postgres", "password");		
		try {
			Connection conn = manager.getConnection();	
			DataAccessObject dao = new OrderDAO(conn);
			
			/*
			DataTransferObject customerInsert = dao.createNew(new Customer("Saradha","Sankar","cshaw0@mlb.com","(206)804-8771","8157 Longview Court","Seattle","WA","98121"));
			System.out.println(customerInsert);
			
			Customer customer = (Customer) dao.getRecordById(10000);
			System.out.println(customer);
			customer.setFirstName("Beautiful");
			System.out.println("Customer ID :: "+dao.updateRecord(customer)+" has been updated");
			
			
			
			Customer customer = (Customer) dao.getRecordById(10000);
			System.out.println(customer);
			
			if(customer != null) dao.deleteRecord(customer.getCustomerId());*/
			
			Orders order = (Orders) dao.getRecordById(1128);
			System.out.println(order.toString() + order.getCustomer() + order.getSalesperson() + order.getItem());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
