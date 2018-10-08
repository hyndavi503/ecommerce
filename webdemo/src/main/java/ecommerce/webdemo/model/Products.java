package ecommerce.webdemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Inheritance(strategy=InheritanceType.JOINED)
public class Products {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int pid;
private String price;
private int numberOfProducts;
@Transient
private MultipartFile image;


@ManyToOne
private Vendor vendor;
@ManyToOne
private SubCategory subCategory;

@OneToMany(mappedBy="products",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
private List<NoOfProducts> noOfProducts;




public List<NoOfProducts> getNoOfProducts() {
	return noOfProducts;
}
public void setNoOfProducts(List<NoOfProducts> noOfProducts) {
	this.noOfProducts = noOfProducts;
}
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

public int getNumberOfProducts() {
	return numberOfProducts;
}
public void setNumberOfProducts(int numberOfProducts) {
	this.numberOfProducts = numberOfProducts;
}
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




 
}
