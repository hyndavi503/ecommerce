package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
@Inheritance(strategy=InheritanceType.JOINED)
public class Products {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long pid;
private String price;
private String quantity;

@ManyToOne
private Vendor vendor;
@ManyToOne
private SubCategory subCategory;


public Vendor getVendor() {
	return vendor;
}
public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}
public SubCategory getSubCategory() {
	return subCategory;
}
public void setSubCategory(SubCategory subCategory) {
	this.subCategory = subCategory;
}
public long getPid() {
	return pid;
}
public void setPid(long pid) {
	this.pid = pid;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Products [pid=" + pid + ", price=" + price + ", quantity=" + quantity + ", vendor=" + vendor
			+ ", subCategory=" + subCategory + "]";
}

 
}
