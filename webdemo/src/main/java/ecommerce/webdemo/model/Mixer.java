package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Mixer extends Products
{
	private int numberOfProducts;
private String companyname;
private String waranty;




public int getNumberOfProducts() {
	return numberOfProducts;
}
public void setNumberOfProducts(int numberOfProducts) {
	this.numberOfProducts = numberOfProducts;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getWaranty() {
	return waranty;
}
public void setWaranty(String waranty) {
	this.waranty = waranty;
}


}
