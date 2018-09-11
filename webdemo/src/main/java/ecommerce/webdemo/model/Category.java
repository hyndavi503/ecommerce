package ecommerce.webdemo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long cid;
private String cname;
@OneToMany(mappedBy="category")
private Set<SubCategory> subCategory;


public Set<SubCategory> getSubCategory() {
	return subCategory;
}
public void setSubCategory(Set<SubCategory> subCategory) {
	this.subCategory = subCategory;
}
public long getCid() {
	return cid;
}
public void setCid(long cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "Category [cid=" + cid + ", cname=" + cname + ", subCategory=" + subCategory + "]";
}


}
