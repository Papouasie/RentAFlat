package fr.uha.miage.benelhne.zimmerch.modele.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.Users;

public interface LogementsRepository extends CrudRepository<Logement, Long>{

	List<Logement> findByLEnabled(int i);

	@Modifying
	@Transactional
	@Query("UPDATE Logement SET l_enabled=?1 WHERE l_id=?2")
	void updateStateLog(int l_enabled,Long l_id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Logement SET l_enabled=?1 WHERE l_id=?2")
	void desactiveLog(int l_enabled,Long l_id);

	/*Logement findByCriterias(String string, String string2, String string3,
			String string4, String string5, String string6);*/
	
}
