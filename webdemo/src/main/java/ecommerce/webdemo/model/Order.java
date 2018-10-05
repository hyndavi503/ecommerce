/*package ecommerce.webdemo.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int noOfItems;
	private int netPrice;
	private Date date;
	private Timestamp timestamp;
	private String status;

	@OneToOne
	private Customer customer;
	@OneToMany(mappedBy = "order",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<OrderedItems> orderedItems;
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(int netPrice) {
		this.netPrice = netPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderedItems> getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(List<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
	}
	
	

}
*/