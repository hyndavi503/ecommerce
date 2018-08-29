package ecommerce.webdemo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component("vendor")
public class Vendor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
	@Column(unique=true)
private String username;
	@Column(unique=true)
private String email;
	@Column(unique=true)
private String mobile;
private String password;
private String companyName;

@OneToMany(mappedBy="vendor")
private Set<Products> products;
@OneToMany(mappedBy="vendor",cascade=CascadeType.ALL)
private Set<Address> addresses;

@OneToMany(mappedBy="vendor")
private Set<Account> accounts;



public Set<Account> getAccounts() {
	return accounts;
}
public void setAccounts(Set<Account> accounts) {
	this.accounts = accounts;
}
public Set<Address> getAddresses() {
	return addresses;
}
public void setAddresses(Set<Address> addresses) {
	this.addresses = addresses;
}
public Set<Products> getProducts() {
	return products;
}
public void setProducts(Set<Products> products) {
	this.products = products;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
/*@Override
public String toString() {
	return "Vendor [id=" + id + ", username=" + username + ", email=" + email + ", mobile=" + mobile + ", password="
			+ password + ", companyName=" + companyName + ", products=" + products + "]";
}
*/
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Vendor other = (Vendor) obj;
	if (companyName == null) {
		if (other.companyName != null)
			return false;
	} else if (!companyName.equals(other.companyName))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	
	if (mobile == null) {
		if (other.mobile != null)
			return false;
	} else if (!mobile.equals(other.mobile))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}

}
