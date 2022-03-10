package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Subscriber;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Mar 9, 2022
 */
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{

	
	
}
