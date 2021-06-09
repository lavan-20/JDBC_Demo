package com.lav.org.dto;

public class OrderItem implements DataTransferObject{
	
	private int orderItemId;
	private int orderId;
	private int productId;
	private int quantity;
		
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return getOrderItemId();
	}
	
	
	

}
