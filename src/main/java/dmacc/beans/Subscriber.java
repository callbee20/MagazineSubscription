package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Mar 9, 2022
 */
@Entity
@Table(name= "subscribers")
public class Subscriber {

	@Id
	@GeneratedValue
	private long id;
	@Column(name= "subscriber_name")
	private String name;
	@Column(name= "subcriber_phone_number")
	private String contactNumber;
	@Column(name= "monthly_fee")
	private double subscriptionFee;
	@Autowired
	private SubAddress address;
	
	public Subscriber() {
		this.subscriptionFee = 12.50;
	}
	
	public Subscriber(String name) {
		this.name = name;
	}
	
	public Subscriber(String name, String contactNumber, double subscriptionFee) {
		this.name = name;
		this.contactNumber = contactNumber;
		this.subscriptionFee = subscriptionFee;
	}
	
	public Subscriber(long id, String name, String contactNumber, double subscriptionFee) {
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.subscriptionFee = subscriptionFee;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the subscriptionFee
	 */
	public double getSubscriptionFee() {
		return subscriptionFee;
	}

	/**
	 * @param subscriptionFee the subscriptionFee to set
	 */
	public void setSubscriptionFee(double subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	/**
	 * @return the address
	 */
	public SubAddress getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(SubAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", subscriptionFee="
				+ subscriptionFee + ", address=" + address + "]";
	}
	
	

	
	
	
}
