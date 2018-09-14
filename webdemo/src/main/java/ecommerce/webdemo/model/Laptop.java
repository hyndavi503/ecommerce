
package ecommerce.webdemo.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Laptop extends Products
{
private int ram;
private int rom;
private String processor;
private String os;
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

}
