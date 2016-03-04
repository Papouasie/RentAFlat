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
import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sun.mail.smtp.SMTPTransport;

import fr.uha.miage.benelhne.zimmerch.modele.OubliMDP;
import fr.uha.miage.benelhne.zimmerch.modele.User_roles;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.RoleRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.OubliMDPRepository;

@Controller
public class RegisterController extends WebMvcConfigurerAdapter{
	@RequestMapping("/register")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("utilisateurs", new Users());
		
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String submitFormUtilisateurs(Users user) throws MessagingException{
		//je sauvegarde le produit dans la base
		String username=user.getUsername();
		Users testuserExist=UtilisateursRepository.findByEmail(username);
		
		if(testuserExist!=null){
			return "redirect:/userexist";
		}
		else{
			UtilisateursRepository.save(user);
			Long iduser=user.getId();
			
			String roleu="ROLE_USER";
			
			System.out.println(iduser);
			System.out.println(roleu);
			System.out.println(username);
			User_roles nouveau_ur=new User_roles(roleu,username,iduser);
			
			RoleRepository.save(nouveau_ur);
			
			String mail_c=user.getUsername();
			String name_c=user.getLastname();
			String prenom_c=user.getSurname();
			String tel_c=user.getTel();
			String date_c=user.getUserdate();
			
			//Envoi d'un email à l'admin du site
			//pour lui donner le message de l'internaute
			Properties props3 = System.getProperties();
			props3.put("mail.smtps.host","smtp.gmail.com");
			props3.put("mail.smtps.auth","true");
		    Session session3 = Session.getInstance(props3, null);
		    Message msg3 = new MimeMessage(session3);
		    
		    //de la part de
		    msg3.setFrom(new InternetAddress(mail_c));;
		    msg3.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse("contact.rentaflat@gmail.com", false));//mail_c --> destinataire. Ici, formulaire de contact
		    msg3.setSubject("Rent-a-flat | Inscription"+System.currentTimeMillis());
		    String texte4 = "<H1>Rent-a-flat.fr</H1>"
	        		+" <h2>Validation d'inscription</h2>"
	        		+ "<p>M, Mme  : "+name_c+"</p>"
	        		+ "<p>S'est récemment inscris sur rent-a-flat.fr.</p>"
	        		+ "<p>Voici un rappel de ses informations : "
	        		+ "<p>Son identifiant : "+username+"</p>"
	        		+ "<p>Son adresse e-mail : "+mail_c+"</p>"
	        		+ "<p>Son nom : "+name_c+"</p>"
	        		+ "<p>Son prénom : "+prenom_c+"</p>"
	        		+ "<p>Son date de naissance : "+date_c+"</p>"
	        		+ "<p>Son numéro de téléphone : "+tel_c+"</p>"
	        		+ "<br /><hr/><br/>"
	        		+ "A bientôt, sur <b>rent-a-flat.fr</b> !";
		    msg3.setContent(texte4, "text/html");
		    msg3.setHeader("X-Mailer", "Coucou");
		    Date d = new Date();
		    msg3.setSentDate(d);
		    SMTPTransport t =
		        (SMTPTransport)session3.getTransport("smtps");
		    t.connect("smtp.gmail.com", "contact.rentaflat@gmail.com", "vetbla&&");
		    t.sendMessage(msg3, msg3.getAllRecipients());
		    System.out.println("Response: " + t.getLastServerResponse());
		    t.close();
		    
			//Envoi d'un email à l'user inscrit
			//pour lui donner le message de l'internaute
			Properties props4 = System.getProperties();
			props4.put("mail.smtps.host","smtp.gmail.com");
			props4.put("mail.smtps.auth","true");
		    Session session4 = Session.getInstance(props4, null);
		    Message msg4 = new MimeMessage(session4);
		    
		    //de la part de
		    msg4.setFrom(new InternetAddress(mail_c));;
		    msg4.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse(mail_c, false));//mail_c --> destinataire. Ici, formulaire de contact
		    msg4.setSubject("Rent-a-flat | Inscription"+System.currentTimeMillis());
		    String texte3 = "<H1>Rent-a-flat.fr</H1>"
	        		+" <h2>Confirmation de votre inscription</h2>"
	        		+ "<p>M, Mme  : "+name_c+"</p>"
	        		+ "<p>Vous vous êtes récemment inscris sur rent-a-flat.fr et nous vous en remercions.</p>"
	        		+ "<p>Voici un rappel de vos informations : "
	        		+ "<p>Votre identifiant : "+username+"</p>"
	        		+ "<p>Votre adresse e-mail : "+mail_c+"</p>"
	        		+ "<p>Votre nom : "+name_c+"</p>"
	        		+ "<p>Votre prénom : "+prenom_c+"</p>"
	        		+ "<p>Votre date de naissance : "+date_c+"</p>"
	        		+ "<p>Votre numéro de téléphone : "+tel_c+"</p>"
	        		+ "<p>Votre mot de passe  : Vous seul(e) le connaissez. Gardez-le précieusement.</p>"
	        		+ "<br/><p>Vous pouvez désormais vous connecter avec votre identifiant (votre adresse email)</p>"
	        		+ "<br /><hr/><br/>"
	        		+ "A bientôt, sur <b>rent-a-flat.fr</b> !";
	        msg4.setContent(texte3, "text/html");
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
			return "redirect:/login";
		}
	}

	
	@Autowired
	private UtilisateursRepository UtilisateursRepository;
	@Autowired
	private RoleRepository RoleRepository;

}
