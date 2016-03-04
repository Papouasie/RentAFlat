package fr.uha.miage.benelhne.zimmerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import fr.uha.miage.benelhne.zimmerch.modele.Contact;
import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.repository.ContactRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.LogementsRepository;

@Controller
public class IndexController extends WebMvcConfigurerAdapter{
	@Autowired
	private LogementsRepository LogementsRepository;
	@Autowired
	private ContactRepository contactrepository;
	
	@RequestMapping("/index")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("logements", new Logement());
		model.addAttribute("contact", new Contact());
		
		LogementsRepository.count();

		List<Logement> logs = (List<Logement>) LogementsRepository.findByLEnabled(1);
		model.addAttribute("logements",logs);
		
		return "index";
	}
	
}

