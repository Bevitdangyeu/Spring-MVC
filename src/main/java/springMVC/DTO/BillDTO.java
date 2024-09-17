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
	private List<String> product=new ArrayList<String>();
	private List<Integer> quantity=new ArrayList<Integer>();
	private List<Float> prince=new ArrayList<Float>();
	private List<Float> total=new ArrayList<Float>();
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
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public List<Float> getPrince() {
		return prince;
	}
	public void setPrince(List<Float> prince) {
		this.prince = prince;
	}
	public List<Float> getTotal() {
		return total;
	}
	public void setTotal(List<Float> total) {
		this.total = total;
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
	public List<String> getProduct() {
		return product;
	}
	public void setProduct(List<String> product) {
		this.product = product;
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
	public void addProduct(String product) {
		this.product.add(product);
	}
	public  void addQuantity(int quantity) {
		this.quantity.add(quantity);
	}
	public void addPrice(float price) {
		this.prince.add(price);
	}
	public void addTotal(float total) {
		this.total.add(total);
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
