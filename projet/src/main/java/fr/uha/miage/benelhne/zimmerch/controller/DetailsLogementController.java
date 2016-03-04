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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sun.mail.smtp.SMTPTransport;

import fr.uha.miage.benelhne.zimmerch.modele.Contact;
import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.Product;
import fr.uha.miage.benelhne.zimmerch.modele.repository.ContactRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.LogementsRepository;

@Controller
public class DetailsLogementController extends WebMvcConfigurerAdapter{
	@Autowired
	private LogementsRepository LogementsRepository;
	@Autowired
	private ContactRepository contactrepository;
	
	@RequestMapping("/details_logement")
	public String requestCreatePage(Model model){
		//je transmets mon objet vide
		model.addAttribute("demande", new Contact());

		return "details_logement";
	}

	
	@RequestMapping("/details_logement/{l_id}")
	public String getLogement(Model model, @PathVariable("l_id") int id, Logement log){
		model.addAttribute("demande", new Contact());
		model.addAttribute("logements", new Logement());
		Logement selectedLogement = LogementsRepository.findOne(log.getL_id());
		model.addAttribute("selectedLogement", selectedLogement);

		return "details_logement";
	}
	
	@RequestMapping(value="/details_logement/{l_id}", method=RequestMethod.POST)
	public String submitDemande(Model model, Contact demande, Logement log) throws MessagingException {
		model.addAttribute("logements", new Logement());
		Logement selectedLogement = LogementsRepository.findOne(log.getL_id());
		model.addAttribute("selectedLogement", selectedLogement);
		
		contactrepository.save(demande);
		
		String mail_annonceur=log.getL_emailL();
		String nom_annonceur=log.getL_nameL();
		System.out.println(mail_annonceur);
		
		String ref_logement=log.getL_reference();
		String mail_demandeur=demande.getContactMail();
		String nom_demandeur=demande.getContactName();
		String tel_demandeur=demande.getContactTel();
		String msg_demandeur=demande.getContactMsg();

		
		//---------------------------------------------------------------------------
		//Envoi d'un email de confirmation au demandeur
		Properties props1 = System.getProperties();
		props1.put("mail.smtps.host","smtp.gmail.com");
		props1.put("mail.smtps.auth","true");
	    Session session1 = Session.getInstance(props1, null);
	    Message msg1 = new MimeMessage(session1);
	    
	    //de la part de
	    msg1.setFrom(new InternetAddress("locavacances.contact@gmail.com"));
	    msg1.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(mail_demandeur, false));//mail_c --> destinataire. Ici, formulaire de contact
	    msg1.setSubject("Confirmation de votre demande de logement - "+System.currentTimeMillis());
	    msg1.setText("M, Mme "+nom_demandeur+
	    			 " Votre demande a bien été envoyée. "+
	    			 ". Référence du logement : "+ref_logement+
	    			 ". Pour rappel, voici votre message : "+msg_demandeur+
	    			 "L'annonceur donnera suite prochainement à votre demande. "
	    			 + "A bientôt sur notre site !");
	    msg1.setHeader("X-Mailer", "Coucou");
	    Date d1 = new Date();
	    msg1.setSentDate(d1);
	    SMTPTransport t1 =
	        (SMTPTransport)session1.getTransport("smtps");
	    t1.connect("smtp.gmail.com", "locavacances.contact@gmail.com", "vetbla&&");
	    t1.sendMessage(msg1, msg1.getAllRecipients());
	    System.out.println("Response: " + t1.getLastServerResponse());
	    t1.close();
	    
	    //----------------------------------------------------------------------------
		//Envoi d'un email d'information à l'annonceur
		Properties props2 = System.getProperties();
		props2.put("mail.smtps.host","smtp.gmail.com");
		props2.put("mail.smtps.auth","true");
	    Session session2 = Session.getInstance(props2, null);
	    Message msg2 = new MimeMessage(session2);
	    
	    //de la part de
	    msg2.setFrom(new InternetAddress("locavacances.contact@gmail.com"));
	    msg2.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(mail_annonceur, false));//mail_c --> destinataire. Ici, formulaire de contact
	    msg2.setSubject("Formulaire de contact"+System.currentTimeMillis());
	    msg2.setText("M, Mme "+nom_annonceur+
	    			 " L'internaute suivant souhaite réserver votre logement : "+nom_demandeur+
	    			 ". Son adresse email est la suivante : "+mail_demandeur+
	    			 ". Son numéro de téléphone est le suivant : "+tel_demandeur+
	    			 ". Voici son message : "+msg_demandeur+
	    			 ". Merci de le contacter pour donner suite à sa demande."
	    			 + "A bientôt sur notre site !");
	    msg2.setHeader("X-Mailer", "Coucou");
	    Date d2 = new Date();
	    msg2.setSentDate(d2);
	    SMTPTransport t2 =
	        (SMTPTransport)session2.getTransport("smtps");
	    t2.connect("smtp.gmail.com", "locavacances.contact@gmail.com", "vetbla&&");
	    t2.sendMessage(msg2, msg2.getAllRecipients());
	    System.out.println("Response: " + t2.getLastServerResponse());
	    t2.close();

	    

		//je redirige mon utilisateur sur /index après traitement
		return "redirect:/details_logement/{l_id}";
	}
	
}