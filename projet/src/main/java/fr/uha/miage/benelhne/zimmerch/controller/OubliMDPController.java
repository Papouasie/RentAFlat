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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class OubliMDPController extends WebMvcConfigurerAdapter{
	@RequestMapping("/oubliMDP")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("oubliMDP", new OubliMDP());
		
		return "oubliMDP";
	}
	
	@RequestMapping(value="/oubliMDP", method=RequestMethod.POST)
	public String submitoubliMDP(OubliMDP omdp) throws MessagingException {
		//oubliMDPRepository.save(omdp);
		
		String addr_u=omdp.getUsername();
		
		//int id_u=user.getUserId();
		SecureRandom random = new SecureRandom();
		
		String test_u=UtilisateursRepository.findByUserName(addr_u);
		//Users test_u=UtilisateursRepository.findOne(id_u);
		
		if(test_u!=null){
			String btn = new BigInteger(130, random).toString(32);
			//String test = "bouh";
			
			oubliMDPRepository.save(new OubliMDP(addr_u,btn));
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(btn);
			//this.password=hashedPassword;
			UtilisateursRepository.updateUser(hashedPassword,addr_u);
			
			//Envoi d'un email à l'admin du site
			//pour lui donner le message de l'internaute
			Properties props2 = System.getProperties();
		    props2.put("mail.smtps.host","smtp.gmail.com");
		    props2.put("mail.smtps.auth","true");
		    Session session2 = Session.getInstance(props2, null);
		    Message msg2 = new MimeMessage(session2);
		    
		    //de la part de
		    msg2.setFrom(new InternetAddress(addr_u));
		    msg2.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse(addr_u, false));//mail_c --> destinataire. Ici, formulaire de contact
		    msg2.setSubject("Rent-a-flat | Redéfinission de votre mot de passe"+System.currentTimeMillis());
		    
		    String texte = "<H1>Rent a flat.fr</H1>"
	        		+" <h2>Redéfinission de votre mot de passe</h2>"
	        		+ "<p>M, Mme, Voici votre code : "+btn+"</p>"
	        		+ "C'est votre nouveau mot de passe."
	        		+ "Merci de le modifier dans votre espace membre."
	        		+ "<br /><hr/><br/>"
	        		+ "A bientôt, sur <b>rent-a-flat.fr</b> !";
	        msg2.setContent(texte, "text/html");
		    
		    msg2.setHeader("X-Mailer", "Coucou");
		    Date d2 = new Date();
		    msg2.setSentDate(d2);
		    SMTPTransport t2 =
		        (SMTPTransport)session2.getTransport("smtps");
		    t2.connect("smtp.gmail.com", "contact.rentaflat@gmail.com", "vetbla&&");
		    t2.sendMessage(msg2, msg2.getAllRecipients());
		    System.out.println("Response: " + t2.getLastServerResponse());
		    t2.close();
			
			//je redirige mon utilisateur sur /liste après traitement
			return "redirect:/entercode";
			
		}

		//je redirige mon utilisateur sur /liste après traitement
		return "redirect:/index";
	}
	

	
	@Autowired
	private UtilisateursRepository UtilisateursRepository;
	@Autowired
	private RoleRepository RoleRepository;
	@Autowired
	private OubliMDPRepository oubliMDPRepository;
}
