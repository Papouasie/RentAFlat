package fr.uha.miage.benelhne.zimmerch.modele.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.benelhne.zimmerch.modele.Users;

public interface UtilisateursRepository extends CrudRepository<Users, Long>{
	List<Users> findByEnabled();
	
	String findByUserName(String addr_u);
	Users findByEmail(String name);
	
	/*@Transactional
	@Query("select username from Users where username = ?")
	String findByUserName(String addr_u);*/

	@Modifying
	@Transactional
	@Query("UPDATE Users SET password=?1 WHERE username=?2")
	void updateUser(String password, String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE Users SET enabled=?1 WHERE id=?2")
	void changeStateUser(int l_enabled,Long l_id);

}
