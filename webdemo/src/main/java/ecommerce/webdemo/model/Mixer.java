package ecommerce.webdemo.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Mixer extends Products
{
private String companyname;
private String waranty;
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
