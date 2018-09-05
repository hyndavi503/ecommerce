package ecommerce.webdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Admin 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long admin_id;
@Column(unique=true)
private String admin_name;
@Column(unique=true)
private String admin_email;
private String admin_password;
public long getAdmin_id() {
	return admin_id;
}
public void setAdmin_id(long admin_id) {
	this.admin_id = admin_id;
}
public String getAdmin_name() {
	return admin_name;
}
public void setAdmin_name(String admin_name) {
	this.admin_name = admin_name;
}
public String getAdmin_email() {
	return admin_email;
}
public void setAdmin_email(String admin_email) {
	this.admin_email = admin_email;
}
public String getAdmin_password() {
	return admin_password;
}
public void setAdmin_password(String admin_password) {
	this.admin_password = admin_password;
}
@Override
public String toString() {
	return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_email=" + admin_email
			+ ", admin_password=" + admin_password + "]";
}


}
