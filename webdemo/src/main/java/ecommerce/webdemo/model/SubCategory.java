package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class SubCategory {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int sid;
private String subcategoryname;

@ManyToOne
private Category category;


public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSubcategoryname() {
	return subcategoryname;
}
public void setSubcategoryname(String subcategoryname) {
	this.subcategoryname = subcategoryname;
}
@Override
public String toString() {
	return "SubCategory [sid=" + sid + ", subcategoryname=" + subcategoryname + ", category=" + category + "]";
}


}
