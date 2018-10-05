/*package ecommerce.webdemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderedItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderedItem_id;
	private int quantity;
	private int unitPrice;
	private int totalPrice;
	@ManyToOne
	private Order order;
	@OneToMany(mappedBy = "orderedItems",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<OrderedItemId> orderedItemdIds;

	public int getOrderedItem_id() {
		return orderedItem_id;
	}

	public void setOrderedItem_id(int orderedItem_id) {
		this.orderedItem_id = orderedItem_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderedItemId> getOrderedItemdIds() {
		return orderedItemdIds;
	}

	public void setOrderedItemdIds(List<OrderedItemId> orderedItemdIds) {
		this.orderedItemdIds = orderedItemdIds;
	}

	
}*/