package com.lav.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lav.org.dto.Customer;

public class CustomerDAO extends DataAccessObject<Customer> {

	private final String INSERT_QUERY = "INSERT INTO customer "
			+ "(first_name, last_name, email, phone, address, city, state, zipcode)" + "VALUES (?,?,?,?,?,?,?,?)";

	private final String UPDATE_QUERY = "UPDATE customer SET first_name = ?, last_name = ?, email = ?,"
			+ " phone = ?, address = ?, city = ?, state = ?, zipcode = ? WHERE CUSTOMER_ID = ?";

	private final String GET_RECORD = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

	private final String DELETE_QUERY = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";

	public CustomerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer createNew(Customer dto) {
		// TODO Auto-generated method stub
		try (PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);) {
			statement.setString(1, dto.getFirstName());
			statement.setString(2, dto.getLastName());
			statement.setString(3, dto.getEmail());
			statement.setString(4, dto.getPhone());
			statement.setString(5, dto.getAddress());
			statement.setString(6, dto.getCity());
			statement.setString(7, dto.getState());
			statement.setString(8, dto.getZipcode());
			statement.execute();
			int lastInserted = findLastVal(SEQUENCE_GEN);
			return getRecordById(lastInserted);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getRecordById(int id) {
		// TODO Auto-generated method stub
		try (PreparedStatement statement = conn.prepareStatement(GET_RECORD);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Customer customer = new Customer(result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6), result.getString(7), result.getString(8),
						result.getString(9));
				customer.setCustomerId(result.getInt(1));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateRecord(Customer customer) {
		// TODO Auto-generated method stub
		try (PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);) {
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPhone());
			statement.setString(5, customer.getAddress());
			statement.setString(6, customer.getCity());
			statement.setString(7, customer.getState());
			statement.setString(8, customer.getZipcode());
			statement.setInt(9, customer.getCustomerId());
			statement.execute();
			return customer.getCustomerId();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		try(PreparedStatement statement = conn.prepareStatement(DELETE_QUERY)) {
			statement.setInt(1, id);
			statement.execute(); 
			System.out.println("Record deleted successfully");
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
