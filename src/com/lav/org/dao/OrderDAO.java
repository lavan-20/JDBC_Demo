package com.lav.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lav.org.dto.Customer;
import com.lav.org.dto.OrderItem;
import com.lav.org.dto.Orders;
import com.lav.org.dto.Product;
import com.lav.org.dto.SalesPerson;

public class OrderDAO extends DataAccessObject<Orders> {

	private final String GET_QUERY = "select c.first_name, c.last_name, c.email, o.order_id, o.creation_date, o.total_due, o.status, s.first_name, s.last_name, s.email, i.quantity,p.product_id, p.name, p.size,p.variety from orders o  join customer c ON c.customer_id = o.customer_id join salesperson s ON s.salesperson_id = o.salesperson_id join order_item i ON i.order_id = o.order_id join product p ON p.product_id = i.product_id where o.order_id = ?";

	private final String CALL_GET_PROC = "select * from get_orders_by_customer(?)";
	
	public OrderDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Orders createNew(Orders dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getRecordById(int id) {
		// TODO Auto-generated method stub
		Orders order = new Orders();
		int orderId = 0;
		List<OrderItem> items = new ArrayList();
		List<Product> products = new ArrayList();
		try (PreparedStatement statement = conn.prepareStatement(CALL_GET_PROC);) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (orderId == 0) {
					Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
					order.setCustomer(customer);
					SalesPerson salesPerson = new SalesPerson(rs.getString(8), rs.getString(9), rs.getString(10));
					order.setSalesperson(salesPerson);
					order.setOrderId(rs.getInt("order_id"));
					order.setCreationDate(rs.getDate("creation_date"));
					order.setTotalDue(rs.getInt("total_due"));
					order.setStatus(rs.getString("status"));
				}
				OrderItem item = new OrderItem();
				item.setQuantity(rs.getInt("quantity"));
				items.add(item);

				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("size"),
						rs.getString("variety"));
				products.add(product);

			}
			order.setItem(items);
			order.setProducts(products);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public int updateRecord(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub

	}

}
