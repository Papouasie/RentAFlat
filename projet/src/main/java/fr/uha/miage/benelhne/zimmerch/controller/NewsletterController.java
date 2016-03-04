package fr.uha.miage.benelhne.zimmerch.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sun.mail.smtp.SMTPTransport;

import fr.uha.miage.benelhne.zimmerch.modele.Contact;
import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.Newsletter;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.NewsletterRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;

@Controller
public class NewsletterController extends WebMvcConfigurerAdapter{
	@RequestMapping("/newsletter")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("newsletter", new Users());
		
		return "newsletter";
	}
	
	@Autowired
	private NewsletterRepository newsrep;
	
	@Autowired
	private UtilisateursRepository userep;
	
	@RequestMapping(value="/newsletter", method=RequestMethod.POST)
	public String submitNewsletter(Newsletter news) throws MessagingException{
		String username=news.getEmail_n();
		newsrep.save(news);
		
		//Envoi d'un email à l'internaute
		Properties props2 = System.getProperties();
		props2.put("mail.smtps.host","smtp.gmail.com");
		props2.put("mail.smtps.auth","true");
	    Session session2 = Session.getInstance(props2, null);
	    Message msg2 = new MimeMessage(session2);
	    
	    //de la part de
	    msg2.setFrom(new InternetAddress(username));
	    msg2.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(username, false));//mail_c --> destinataire. Ici, formulaire de contact
	    msg2.setSubject("Rent-a-flat.fr | Inscription newsletter"+System.currentTimeMillis());
	    
	    String texte = "<H1>Rent a flat.fr</H1>"
        		+" <h2>Confirmation de votre inscription à notre newsletter</h2>"
        		+ "<p>M, Mme : "+username+"</p>"
        		+ " Vous êtes désormais inscris à la newsletter du site rent-a-flat.fr"
        		+ " Vous pouvez à tout moment vous désinscrire, en nous écrivant à contact.rentaflat@gmail.com"
        		+ " ou via la rubrique Contact de notre site."
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
		
		return "redirect:/index";
	}
}
