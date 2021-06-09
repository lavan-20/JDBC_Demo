package com.lav.org.dto;

import java.util.Date;
import java.util.List;

public class Orders implements DataTransferObject{

	private int orderId;
	private Date creationDate;
	private int totalDue;
	private String status;
	private int customerId;
	private int salespersonId;
	
	private Customer customer;
	private List<OrderItem> item;
	private SalesPerson salesperson;
	private List<Product> products;

	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", creationDate=" + creationDate + ", totalDue=" + totalDue + ", status="
				+ status + ", customerId=" + customerId + ", salespersonId=" + salespersonId + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(int totalDue) {
		this.totalDue = totalDue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSalespersonId() {
		return salespersonId;
	}
	public void setSalespersonId(int salespersonId) {
		this.salespersonId = salespersonId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getItem() {
		return item;
	}
	public void setItem(List<OrderItem> item) {
		this.item = item;
	}
	public SalesPerson getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(SalesPerson salesperson) {
		this.salesperson = salesperson;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return getOrderId();
	}

}
