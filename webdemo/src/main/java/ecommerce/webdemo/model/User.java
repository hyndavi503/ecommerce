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

private boolean status=false;

@OneToMany(mappedBy="user")
	private  Set<Address> addresses;


public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

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


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (addresses == null) {
		if (other.addresses != null)
			return false;
	} else if (!addresses.equals(other.addresses))
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
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	if (status != other.status)
		return false;
	return true;
}



}
