package fr.uha.miage.benelhne.zimmerch.modele.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.benelhne.zimmerch.modele.OubliMDP;

public interface OubliMDPRepository extends CrudRepository<OubliMDP, Integer>{
	OubliMDP findByUsernameHashcde(String username, String hashcde);
	//String findByUserName(String username, String hashcde);
	//String findByHashcde(String username, String hashcde);
	
}
