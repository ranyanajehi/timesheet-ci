package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServicelmpl implements IContratService {
	
	@Autowired
	ContratRepository contratRepository;
	
	private static final Logger l = LogManager.getLogger(ContratServicelmpl.class);
	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			l.info("In retrieveAllContrats() : ");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				l.debug("contrat +++ : " + contrat);
			} 
			l.info("Out of retrieveAllContrats() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllContrats() : " + e);
		}

		return contrats;
	}

	@Override
	public Contrat addContrat(Contrat c) {
		return contratRepository.save(c);
	}
	

	@Override
	public void deleteContrat(String id) {
		contratRepository.deleteById(Long.parseLong(id));
		
	}
	
	@Override
	public Contrat updateContrat(Contrat c) {
		return contratRepository.save(c);
	}
	
	

	@Override
	public Contrat retrieveContrat(String id) {
		l.info("in  retrieveContrat id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Contrat c =  contratRepository.findById(Long.parseLong(id)).get(); 
		l.info("contrat returned : " + c);
		return c; 
	}
	
}
