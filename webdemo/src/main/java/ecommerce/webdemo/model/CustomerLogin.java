package ecommerce.webdemo.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
public class CustomerLogin 
{
private String email;
private String password;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
