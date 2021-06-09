package com.lav.org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lav.org.dto.Customer;
import com.lav.org.dto.DataTransferObject;

public abstract class DataAccessObject <T extends DataTransferObject>{
	
	protected Connection conn;
	private final String LAST_VAL = "select last_value from ";
	protected final String SEQUENCE_GEN = "hp_customer_seq";

	
	public DataAccessObject(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	public int findLastVal(String sequenceName) {
		String sql = LAST_VAL+sequenceName;
		try(Statement statement = conn.createStatement();){
			ResultSet rs =  statement.executeQuery(sql);
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public abstract T createNew(T dto);
	public abstract T getRecordById(int id);
	public abstract int updateRecord(Customer customer);
	public abstract void deleteRecord(int id);

}
