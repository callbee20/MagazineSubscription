package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.SubAddress;
import dmacc.beans.Subscriber;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Mar 9, 2022
 */
@Configuration
public class BeanConfiguration {

	@Bean
	public Subscriber subscriber() {
		Subscriber bean = new Subscriber();
		bean.setName("Hypo Thalamus");
		bean.setContactNumber("555-555-5555");
		bean.setSubscriptionFee(13.95);
		return bean;
	}
	
	@Bean
	public SubAddress subAddress () {
		SubAddress bean = new SubAddress("123 Main Street", "Des Moines", "IA", 50313);
		return bean;
	}
}
