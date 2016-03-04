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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.mail.smtp.SMTPTransport;

import fr.uha.miage.benelhne.zimmerch.modele.OubliMDP;
import fr.uha.miage.benelhne.zimmerch.modele.User_roles;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;

@Controller
public class UtilisateursController {
	@Autowired
	private UtilisateursRepository userRepository;

	@RequestMapping("/espacemembre")
	public String requestListProduct(Model model) {
		//userRepository.count();
		//création d'un objet vide

	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    System.out.println(name);
	    
	    Users user_good=userRepository.findByEmail(name);
	    System.out.println(user_good);
	    model.addAttribute("users", user_good);
	    
		return "espacemembre";
	}
	
	@RequestMapping(value="/espacemembre", method=RequestMethod.POST)
	public String submitFormUtilisateurs(Users user) throws MessagingException{		
		String email_u=user.getEmail();
		userRepository.updateUser(user.getPassword(),user.getUsername());
		
		//Envoi d'un email à l'user inscrit
		Properties props4 = System.getProperties();
		props4.put("mail.smtps.host","smtp.gmail.com");
		props4.put("mail.smtps.auth","true");
	    Session session4 = Session.getInstance(props4, null);
	    Message msg4 = new MimeMessage(session4);
	    
	    //de la part de
	    msg4.setFrom(new InternetAddress(email_u));;
	    msg4.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(email_u, false));//mail_c --> destinataire. Ici, formulaire de contact
	    msg4.setSubject("Formulaire de contact"+System.currentTimeMillis());
	    msg4.setText("M, Mme, votre mot de passe a bien été modifié ! ");
	    msg4.setHeader("X-Mailer", "Coucou");
	    Date d2 = new Date();
	    msg4.setSentDate(d2);
	    SMTPTransport t2 =
	        (SMTPTransport)session4.getTransport("smtps");
	    t2.connect("smtp.gmail.com", "contact.rentaflat@gmail.com", "vetbla&&");
	    t2.sendMessage(msg4, msg4.getAllRecipients());
	    System.out.println("Response: " + t2.getLastServerResponse());
	    t2.close();
		
		//je redirige mon utilisateur sur /liste après traitement
		return "redirect:/espacemembre";
	}

}