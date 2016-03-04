package fr.uha.miage.benelhne.zimmerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.Product;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.TypeLogementsRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;

@Controller
public class AProposController extends WebMvcConfigurerAdapter{
	@Autowired
	private TypeLogementsRepository typeLogementsRepository2;
	@Autowired
	private UtilisateursRepository UserRepo;

	@RequestMapping("/apropos")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("products", new Product());
		
		typeLogementsRepository2.count();

		List<Logement> logs = (List<Logement>) typeLogementsRepository2.findAll();
		model.addAttribute("logs",logs);
		
		return "apropos";

	}
	
}
