package fr.uha.miage.benelhne.zimmerch.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sun.mail.smtp.SMTPTransport;
import fr.uha.miage.benelhne.zimmerch.modele.OubliMDP;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.RoleRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.OubliMDPRepository;

@Controller
public class EnterCodeController extends WebMvcConfigurerAdapter{
	@RequestMapping("/entercode")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("oubliMDP", new OubliMDP());
		
		return "entercode";
	}
	
	@RequestMapping(value="/entercode", method=RequestMethod.POST)
	public String submitenterCode(OubliMDP omdp) {
		String username=omdp.getUsername();
		String hashcde=omdp.getHashcde();
		omdp.setHashcde(hashcde);
		hashcde=omdp.getHashcde();
		System.out.println(username);
		System.out.println(hashcde);
		
		OubliMDP test_u=oubliMDPRepository.findByUsernameHashcde(username,hashcde);
		System.out.println(test_u);
		
		int id_o=test_u.getId();
		System.out.println(id_o);
		
		if(test_u!=null){ //on a trouvé un user dans la base
			oubliMDPRepository.delete(id_o);
			
			//je redirige mon utilisateur sur /login après traitement
			return "redirect:/validation";
		}
		
		//je redirige mon utilisateur sur /index après traitement
		return "redirect:/index";
		
	}
	
	@Autowired
	private UtilisateursRepository UtilisateursRepository;
	@Autowired
	private RoleRepository RoleRepository;
	@Autowired
	private OubliMDPRepository oubliMDPRepository;
}
