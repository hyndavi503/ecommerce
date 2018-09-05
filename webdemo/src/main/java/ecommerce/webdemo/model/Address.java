package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;
	private String street;
	private String city;
	private String pincode;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setVendor(User user) {
		this.user = user;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", street=" + street + ", city=" + city + ", pincode=" + pincode
				+ ", user=" + user + "]";
	}
	

}
