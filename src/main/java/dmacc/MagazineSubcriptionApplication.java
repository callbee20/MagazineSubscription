package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.SubAddress;
import dmacc.beans.Subscriber;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.SubscriberRepository;

@SpringBootApplication
public class MagazineSubcriptionApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MagazineSubcriptionApplication.class, args);
	}

	@Autowired
	SubscriberRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Subscriber s = appContext.getBean("subscriber", Subscriber.class);
		
		s.setSubscriptionFee(7.85);
		repo.save(s);
		
		Subscriber b = new Subscriber("Wayne Karagon", "555-555-5543", 8.95);
		SubAddress a = new SubAddress("724 2nd Avenue", "Des Moines", "IA", 50323);
		
		b.setAddress(a);
		repo.save(b);
		
		List<Subscriber> allSubscribers = repo.findAll();
		for (Subscriber people: allSubscribers) {
			System.out.println(people.toString());
		}
		
		((AbstractApplicationContext) appContext).close();
		
		
	}
	
	

}

