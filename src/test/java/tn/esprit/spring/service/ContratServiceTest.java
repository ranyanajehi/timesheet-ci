package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	
	@Autowired
	IContratService cs; 
	
	@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = cs.retrieveAllContrats(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(15, listContrats.size());
	}
	
	
	/*@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User("Mayssa1", "Mayssa1", d, Role.INGENIEUR); 
		User userAdded = us.addUser(u); 
		Assert.assertEquals(u.getLastName(), userAdded.getLastName());
	}*/
	


}
