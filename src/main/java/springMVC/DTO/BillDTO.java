package springMVC.DTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillDTO {
	private int billId;
	private String productName;
	private String customerName;
	private int employeeID;
	private String employeeName;
	private int totalQuantity;
	private float totalPrice;
	private LocalDateTime date;
	private List<CheckoutDTO> items=new ArrayList<CheckoutDTO>();
/*	private List<String> product=new ArrayList<String>();
	private List<Integer> quantity=new ArrayList<Integer>();
	private List<Float> prince=new ArrayList<Float>();
	private List<Float> total=new ArrayList<Float>();
	private List<String> size=new ArrayList<String>();
	private List<String> color=new ArrayList<String>();
	private List<String> image=new ArrayList<String>(); */
	// phần phân trang
	private int page;
	private int limit;// tổng số lượng phần tử trên một trang
	private String sortBy;
	private int totalPage;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime localDateTime) {
		this.date = localDateTime;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<CheckoutDTO> getItems() {
		return items;
	}
	public void setItems(List<CheckoutDTO> items) {
		this.items = items;
	}
	
}
