/*package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderedItemId {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderedItemdId_no;
	@OneToOne
	private NoOfProducts noOfProducts;
	@OneToOne
	private OrderedItems orderedItems;

	public int getOrderedItemdId_no() {
		return orderedItemdId_no;
	}

	public void setOrderedItemdId_no(int orderedItemdId_no) {
		this.orderedItemdId_no = orderedItemdId_no;
	}

	public NoOfProducts getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(NoOfProducts noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public OrderedItems getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(OrderedItems orderedItems) {
		this.orderedItems = orderedItems;
	}

}*/