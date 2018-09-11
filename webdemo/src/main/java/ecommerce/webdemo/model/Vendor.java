
package ecommerce.webdemo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/*@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not be blank")*/
	/*@Pattern(regexp = "[a-zA-Z/s]{3,15}", message = "name must contain a-z.min are 3 and max are 15")*/
	@Column(unique = true)
	private String name;
	/*@NotNull(message = "email should not be null")
	@NotBlank(message = "email should not be blank")*/
	/*@Pattern(regexp = "[a-z0-9]{5,15}@[a-z]{3,6}\.[a-z]{2,6}
	 * ", message = "email must contain the following rules")*/
	@Column(unique = true)
	private String email;
	/*@NotNull(message = "mobile should not be null")
	@NotBlank(message = "mobile should not be blank")*/
	/*@Pattern(regexp = "[0-9] {1,10}", message = "mobile number should have 0-9")*/
	@Column(unique = true)
	private String mobile;
	private String password;
	

	private String companyname;

	private boolean status = false;

	@OneToMany(mappedBy = "vendor")
	private Set<Address> addresses;
	
	@OneToMany(mappedBy = "vendor")
	private List<Products> products;


	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", companyname=" + companyname + ", addresses=" + addresses + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (companyname == null) {
			if (other.companyname != null)
				return false;
		} else if (!companyname.equals(other.companyname))
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
		if (status != other.status)
			return false;
		return true;
	}

	
}
