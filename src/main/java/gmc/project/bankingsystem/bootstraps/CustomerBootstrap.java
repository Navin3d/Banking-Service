package gmc.project.bankingsystem.bootstraps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import gmc.project.bankingsystem.dao.CustomerDao;
import gmc.project.bankingsystem.entities.CustomerEntity;

@Component
public class CustomerBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private CustomerDao customerDao;
	
	private List<CustomerEntity> loadAllCustomers() {
		List<CustomerEntity> returnValue = new ArrayList<>();
		
		
		CustomerEntity user1 = new CustomerEntity();
		user1.setName("Jenish rojin");
		user1.setEmail("jenishrojin2002@gmail.com");
		user1.setCurrentBalance(500000l);
		returnValue.add(user1);
		
		CustomerEntity user2 = new CustomerEntity();
		user2.setName("Jenish victmon");
		user2.setEmail("jenish@gmail.com");
		user2.setCurrentBalance(10000l);
		returnValue.add(user2);
		
		CustomerEntity user3 = new CustomerEntity();
		user3.setName("krishnaraghjavan");
		user3.setEmail("krishna@gmail.com");
		user3.setCurrentBalance(900000l);
		returnValue.add(user3);
		
		CustomerEntity user4 = new CustomerEntity();
		user4.setName("loga");
		user4.setEmail("loga@gmail.com");
		user4.setCurrentBalance(200000l);
		returnValue.add(user4);
		
		CustomerEntity user5 = new CustomerEntity();
		user5.setName("naveen kumar");
		user5.setEmail("naveen@gmail.com");
		user5.setCurrentBalance(600000l);
		returnValue.add(user5);
		
		CustomerEntity user6 = new CustomerEntity();
		user6.setName("kaushik");
		user6.setEmail("kaushik@gmail.com");
		user6.setCurrentBalance(200000l);
		returnValue.add(user6);
		
		CustomerEntity user7 = new CustomerEntity();
		user7.setName("kishore");
		user7.setEmail("kishore@gmail.com");
		user7.setCurrentBalance(800000l);
		returnValue.add(user7);
		
		CustomerEntity user8 = new CustomerEntity();
		user8.setName("jay kumar");
		user8.setEmail("jaykumar@gmail.com");
		user8.setCurrentBalance(300000l);
		returnValue.add(user8);
		
		CustomerEntity user9 = new CustomerEntity();
		user9.setName("laxman");
		user9.setEmail("laxman@gmail.com");
		user9.setCurrentBalance(180000l);
		returnValue.add(user9);
		
		CustomerEntity user10 = new CustomerEntity();
		user10.setName("sateesh");
		user10.setEmail("sateesh@gmail.com");
		user10.setCurrentBalance(7800000l);
		returnValue.add(user10);
		
		return returnValue;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		customerDao.saveAll(loadAllCustomers());
	}

}
