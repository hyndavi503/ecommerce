package ecommerce.webdemo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
@Column(unique=true)
private String name;
@Column(unique=true)
private String email;
@Column(unique=true)
private String mobile;
private String password;
private String role;

@OneToMany(mappedBy="user")
private Set<Address> addresses;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public Set<Address> getAddresses() {
	return addresses;
}

public void setAddresses(Set<Address> addresses) {
	this.addresses = addresses;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password=" + password
			+ ", role=" + role + ", addresses=" + addresses + "]";
}



}
