package fr.uha.miage.benelhne.zimmerch.modele.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.benelhne.zimmerch.modele.User_roles;

public interface RoleRepository extends CrudRepository<User_roles, Long>{

	User_roles findByIduser(Long id);

}
