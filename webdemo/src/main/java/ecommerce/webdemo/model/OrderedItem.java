/*package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderedItem 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int orderItemId;
private int quantity;
private int unitPrice;
private int totalPrice;
@OneToOne
private CartOrder cartOrder;
@ManyToOne
private Products products;

}
*/