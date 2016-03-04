package fr.uha.miage.benelhne.zimmerch.controller;

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
import fr.uha.miage.benelhne.zimmerch.modele.Contact;
import fr.uha.miage.benelhne.zimmerch.modele.repository.ContactRepository;

@Controller
public class ContactController  extends WebMvcConfigurerAdapter{
	@Autowired
	private ContactRepository contactrep;
	
	@RequestMapping("/contact")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("contact", new Contact());

		return "contact";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public String submitContact(Contact contact) throws MessagingException{

		contactrep.save(contact);
		String mail_c=contact.getContactMail();
		String msg_c=contact.getContactMsg();
		String tel_c=contact.getContactTel();
		String name_c=contact.getContactName();
		
		//Envoi d'un email à l'admin du site
			//pour lui donner le message de l'internaute
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        
        //de la part de
        msg.setFrom(new InternetAddress(mail_c));
        msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("contact.rentaflat@gmail.comm", false));//mail_c --> destinataire. Ici, formulaire de contact
        msg.setSubject("Rent-a-flat.fr | Formulaire de contact"+System.currentTimeMillis());
        String texte = "<H1>Rent a flat.fr</H1>"
        		+" <h2>Formulaire de contact</h2>"
        		+ "<p>Message de : "+name_c+"</p>"
        		+ "<p>Son message : "+msg_c+"</p>"
        		+ "<p>Son numéro de téléphone : "+tel_c+"</p>"
        		+ "<br /><hr/><br/>"
        		+ "A bientôt, sur <b>rent-a-flat.fr</b> !";
        msg.setContent(texte, "text/html");
        //msg.setText("Message de : "+name_c+" Voici son message : "+msg_c+". Numéro : "+tel_c);
        msg.setHeader("X-Mailer", "Bonjour");
        Date d = new Date();
        msg.setSentDate(d);
        SMTPTransport t =
            (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "contact.rentaflat@gmail.com", "vetbla&&");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
        
		//Envoi d'un email à l'internaute
		Properties props2 = System.getProperties();
	    props.put("mail.smtps.host","smtp.gmail.com");
	    props.put("mail.smtps.auth","true");
	    Session session2 = Session.getInstance(props2, null);
	    Message msg2 = new MimeMessage(session2);
	    
	    //de la part de
	    msg2.setFrom(new InternetAddress(mail_c));
	    msg2.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(mail_c, false));//mail_c --> destinataire. Ici, formulaire de contact
	    msg2.setSubject("Rent-a-flat.fr | Formulaire de contact"+System.currentTimeMillis());
	    
	    String texte2 = "<H1>Rent-a-flat.fr</H1>"
        		+" <h2>Formulaire de contact</h2>"
        		+ "<p>M, Mme  : "+name_c+"</p>"
        		+ "<p>Vous avez envoyé le message suivant : "+msg_c+"</p>"
        		+ "<p>Votre numéro de téléphone : "+tel_c+"</p>"
        		+ "<br/><p>Nous vous répondrons à votre demande très prochainement, merci.</p>"
        		+ "<br /><hr/><br/>"
        		+ "A bientôt, sur <b>rent-a-flat.fr</b> !";
	    
        msg2.setContent(texte2, "text/html");
	    msg2.setHeader("X-Mailer", "Coucou");
	    Date d2 = new Date();
	    msg2.setSentDate(d2);
	    SMTPTransport t2 =
	        (SMTPTransport)session.getTransport("smtps");
	    t2.connect("smtp.gmail.com", "contact.rentaflat@gmail.com", "vetbla&&");
	    t2.sendMessage(msg2, msg2.getAllRecipients());
	    System.out.println("Response: " + t2.getLastServerResponse());
	    t2.close();
		
		//je redirige mon utilisateur sur /liste après traitement
		return "redirect:/contact";
	}
	
}
