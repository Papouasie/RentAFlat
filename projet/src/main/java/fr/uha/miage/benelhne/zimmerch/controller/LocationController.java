package fr.uha.miage.benelhne.zimmerch.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sun.mail.smtp.SMTPTransport;

import fr.uha.miage.benelhne.zimmerch.modele.Contact;
import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.OubliMDP;
import fr.uha.miage.benelhne.zimmerch.modele.repository.ContactRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.LogementsRepository;

@Controller
public class LocationController extends WebMvcConfigurerAdapter{
	@Autowired
	private LogementsRepository LogementsRepository;
	@Autowired
	private ContactRepository contactrepository;
	
	@RequestMapping("/location")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("logements", new Logement());
		model.addAttribute("contact", new Contact());
		
		LogementsRepository.count();

		List<Logement> logs = (List<Logement>) LogementsRepository.findByLEnabled(1);
		model.addAttribute("logements",logs);
		
		return "location";
	}
	
	@RequestMapping(value="/location", method=RequestMethod.POST)
	public String getDetails(Model model, Logement log){
		model.addAttribute("logements", new Logement());
		Logement selectedLogement = LogementsRepository.findOne(log.getL_id());
		model.addAttribute("selectedLogement", selectedLogement);
		
		//model.addAttribute("demande", new Contact());

		//contactrepository.save(demande);
		
		//return "/details_logement";
		return "redirect:/details_logement";
	}
	
	/*@RequestMapping(value="/rechercheavancee", method=RequestMethod.POST)
	public String getRechercheAvancee(Model model, Logement log) {
		
		if(log.getL_region().isEmpty() &&
		   log.getL_ville().isEmpty() &&
		   log.getL_type().isEmpty() &&
		   log.getL_surface().isEmpty() &&
		   log.getL_pieces().isEmpty() &&
		   log.getL_price().isEmpty()
		   ){
			Logement selectedLogement = (Logement) LogementsRepository.findAll();
			model.addAttribute("logements", selectedLogement);
			
		} else if(log.getL_region().isEmpty() &&
				  log.getL_ville().isEmpty() &&
				  log.getL_type().isEmpty() &&
				  log.getL_surface().isEmpty() &&
				  log.getL_pieces().isEmpty() &&
				  log.getL_price()!=null) {
			String price = log.getL_price();
			Logement selectedLogement = (Logement) LogementsRepository.findByCriterias(
																					   "%",
																					   "%",
																					   "%",
																					   "%",
																					   "%",
																					   price);
			model.addAttribute("logements", selectedLogement);
		} else if(log.getL_region().isEmpty() &&
				  log.getL_ville().isEmpty() &&
				  log.getL_type().isEmpty() &&
				  log.getL_surface().isEmpty() &&
				  log.getL_pieces()!=null &&
				  log.getL_price()!=null) {
			String price = log.getL_price();
			String pieces = log.getL_pieces();
			Logement selectedLogement = (Logement) LogementsRepository.findByCriterias(
																					   "%",
																					   "%",
																					   "%",
																					   "%",
																					   pieces,
																					   price);
			model.addAttribute("logements", selectedLogement);
		} else if(log.getL_region().isEmpty() &&
				  log.getL_ville().isEmpty() &&
				  log.getL_type().isEmpty() &&
				  log.getL_surface()!=null &&
				  log.getL_pieces()!=null &&
				  log.getL_price()!=null) {
			String price = log.getL_price();
			String pieces = log.getL_pieces();
			String surface = log.getL_surface();
			Logement selectedLogement = (Logement) LogementsRepository.findByCriterias(
																					   "%",
																					   "%",
																					   "%",
																					   surface,
																					   pieces,
																					   price);
			model.addAttribute("logements", selectedLogement);
		} else if(log.getL_region().isEmpty() &&
				  log.getL_ville().isEmpty() &&
				  log.getL_type()!=null &&
				  log.getL_surface()!=null &&
				  log.getL_pieces()!=null &&
				  log.getL_price()!=null) {
			String price = log.getL_price();
			String pieces = log.getL_pieces();
			String surface = log.getL_surface();
			String type = log.getL_type();
			Logement selectedLogement = (Logement) LogementsRepository.findByCriterias(
																					   "%",
																					   "%",
																					   type,
																					   surface,
																					   pieces,
																					   price);
			model.addAttribute("logements", selectedLogement);
		} else if(log.getL_region().isEmpty() &&
				  log.getL_ville()!=null &&
				  log.getL_type()!=null &&
				  log.getL_surface()!=null &&
				  log.getL_pieces()!=null &&
				  log.getL_price()!=null) {
			String price = log.getL_price();
			String pieces = log.getL_pieces();
			String surface = log.getL_surface();
			String type = log.getL_type();
			String ville = log.getL_ville();
			Logement selectedLogement = (Logement) LogementsRepository.findByCriterias(
																					   "%",
																					   ville,
																					   type,
																					   surface,
																					   pieces,
																					   price);
			model.addAttribute("logements", selectedLogement);
		}
		
		
		Logement selectedLogement = LogementsRepository.findOne(log.getL_id());
		model.addAttribute("logements", selectedLogement);
		
		return "redirect:/rechercheavancee";
	}*/
	
	@RequestMapping("/deleteLogement/{l_id}")
	public String deleteLogement(@PathVariable("l_id") Long l_id){
		LogementsRepository.delete(l_id);
		
		return "redirect:/location";
	}

	@RequestMapping("/desactiveLog/{l_id}")
	public String desactiveLog(@PathVariable("l_id") Long l_id){
		//LogementsRepository.delete(l_id);
		int l_enabled=0;
		LogementsRepository.desactiveLog(l_enabled,l_id);
		
		return "redirect:/location";
	}
	

	
	
}



