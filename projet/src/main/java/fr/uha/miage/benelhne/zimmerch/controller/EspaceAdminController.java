package fr.uha.miage.benelhne.zimmerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.User_roles;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.LogementsRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.RoleRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;


@Controller
public class EspaceAdminController {
	
	@Autowired
	private UtilisateursRepository UserRep;
	@Autowired
	private LogementsRepository LogementsRepository;
	@Autowired
	private RoleRepository rolesRepository;

	@RequestMapping("/espaceadmin")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("utilisateurs", new Users());
		
		long nbrelog=UserRep.count();
		model.addAttribute("nbrelog",nbrelog);
		System.out.println(nbrelog);
		
		//retourne une liste
		List<Users> utilisateurs = (List<Users>) UserRep.findAll();
		//List<Users> utltr = (List<Users>) UserRep.findByEnabled();
		model.addAttribute("utilisateurs",utilisateurs);
		System.out.println(utilisateurs);
		
		List<Logement> logs = (List<Logement>) LogementsRepository.findByLEnabled(0);
		model.addAttribute("logs",logs);
		System.out.println(logs);
		
		return "espaceadmin";
	}
	
	@RequestMapping("/removeUser/{id}")
	public String deleteLogement(@PathVariable("id") Long iduser){
		User_roles userrole=rolesRepository.findByIduser(iduser);
		System.out.println(userrole);
		System.out.println("id : "+iduser);
		rolesRepository.delete(userrole);
		UserRep.delete(iduser);
		
		return "redirect:/espaceadmin";
	}
	
	@RequestMapping("/activeLog/{l_id}")
	public String activeLogement(@PathVariable("l_id") Long l_id){
		int l_enabled=1;
		LogementsRepository.updateStateLog(l_enabled,l_id);
		
		return "redirect:/espaceadmin";
	}
	
	@RequestMapping("/changeStateUser/{id}")
	public String changeStateUser(@PathVariable("id") Long id){
		Users u=UserRep.findOne(id);
		int e=u.getEnabled();
		int enabled=0;
		
		if(e==0){
			enabled=1;			
		}
		if(e==1){
			enabled=0;			
		}
		
		UserRep.changeStateUser(enabled,id);
		
		return "redirect:/espaceadmin";
	}

}
