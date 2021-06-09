package com.lav.org.dto;

public class Product implements DataTransferObject {

	private int productId;
	private String code;
	private String name;
	private int size;
	private String variety;
	private int price;
	private String status;
	
	
	
	public Product(int productId, String name, int size, String variety) {
		super();
		this.productId = productId;
		this.name = name;
		this.size = size;
		this.variety = variety;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", code=" + code + ", name=" + name + ", size=" + size + ", variety="
				+ variety + ", price=" + price + ", status=" + status + "]";
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return getProductId();
	}
	
	
}
