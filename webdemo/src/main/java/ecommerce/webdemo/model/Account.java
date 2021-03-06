package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Account 
{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int accountid;

private String bankName;
private String accountNumber;

@ManyToOne
private Vendor vendor;



public Vendor getVendor() {
	return vendor;
}
public void setUser(Vendor vendor) {
	this.vendor = vendor;
}
public int getAccountid() {
	return accountid;
}
public void setAccountid(int accountid) {
	this.accountid = accountid;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
@Override
public String toString() {
	return "Account [accountid=" + accountid + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ",vendor="
			+ vendor+ "]";
}




}
