package ecommerce.webdemo.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Mobile extends Products
{
	private int ram;
	private int rom;
	private String processor;
	private String os;
	private String brandname;
	@Transient
	private MultipartFile image;
	

	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRom() {
		return rom;
	}
	public void setRom(int rom) {
		this.rom = rom;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	@Override
	public String toString() {
		return "Laptop [ram=" + ram + ", rom=" + rom + ", processor=" + processor + ", os=" + os + "]";
	}


}
