package fr.uha.miage.benelhne.zimmerch.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.uha.miage.benelhne.zimmerch.ProjetApplication;
import fr.uha.miage.benelhne.zimmerch.modele.Logement;
import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.LogementsRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.FileCopyUtils;


@Controller
public class ProposerLogController {
	@Autowired
	private UtilisateursRepository userRepository;
	
	@Autowired
	private LogementsRepository LogementsRepository;

	@RequestMapping("/proposerlog")
	public String requestListProduct(Model model) {
		//je transmets mon objet vide
		model.addAttribute("logements", new Logement());
		model.addAttribute("usergood", new Users());
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    System.out.println(name);
	    
	    Users user_good=userRepository.findByEmail(name);
	    System.out.println(user_good);
	    model.addAttribute("usergood", user_good);
		
		return "proposerlog";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/proposerlog")
	public String provideUploadInfo(Model model) {
		model.addAttribute("logements", new Logement());
		
		File rootFolder = new File(ProjetApplication.ROOT);
		List<String> fileNames = Arrays.stream(rootFolder.listFiles())
			.map(f -> f.getName())
			.collect(Collectors.toList());

		model.addAttribute("files",
			Arrays.stream(rootFolder.listFiles())
					.sorted(Comparator.comparingLong(f -> -1 * f.lastModified()))
					.map(f -> f.getName())
					.collect(Collectors.toList())
		);

		return "proposerlog";
	}

	
	@RequestMapping(value="/proposerlog", method=RequestMethod.POST)
	public String submitFormUtilisateurs(Logement nouveau,
										   @RequestParam("name") String name,
										   @RequestParam("file") MultipartFile file,
										   RedirectAttributes redirectAttributes){
		//je sauvegarde le produit dans la base
		//String ref=System.currentTimeMillis();
		
		String l_reference="";
		
		Random rand = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12356789";
		int longueur = alphabet.length();
		
		for(int i = 0; i < 15; i++) {
		  int k = rand.nextInt(longueur);
		  l_reference+=alphabet.charAt(k)+"";
		}
		
		String l_nomimage="";
		
		if(nouveau.getL_img()==null) {
			l_nomimage="aucunvisuel";
		} else{
			l_nomimage=l_reference.toLowerCase();
		}	
			
			if (name.contains("/")) {
				redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
				return "redirect:proposerlog";
			}
			if (name.contains("/")) {
				redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
				return "redirect:proposerlog";
			}
	
			if (!file.isEmpty()) {
				try {
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(ProjetApplication.ROOT + "/" + l_nomimage + ".jpg")));
					System.out.println(ProjetApplication.ROOT + "/" + l_nomimage);
	                FileCopyUtils.copy(file.getInputStream(), stream);
					stream.close();
					redirectAttributes.addFlashAttribute("message",
							"You successfully uploaded " + l_nomimage + "!");
				}
				catch (Exception e) {
					redirectAttributes.addFlashAttribute("message",
							"You failed to upload " + l_nomimage + " => " + e.getMessage());
				}
			}
			else {
				redirectAttributes.addFlashAttribute("message",
						"You failed to upload " + l_nomimage + " because the file was empty");
			}
		
		nouveau.setL_img("img/"+l_nomimage+".jpg");
		nouveau.setL_reference(l_reference);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String l_username = auth.getName(); //get logged in username
	    //System.out.println(name);
		
		nouveau.setL_username(l_username);
		nouveau.setL_emailL(l_username);

		Users infouser=userRepository.findByEmail(l_username);
		String last=infouser.getLastname();
		String sur=infouser.getSurname();
		String tel=infouser.getTel();
		
		nouveau.setL_nameL(last);
		nouveau.setL_surnameL(sur);
		nouveau.setL_numberL(tel);
		
		LogementsRepository.save(nouveau);
		
		//String emailUser=nouveau.getL_emailL();
		//Utilisateurs user=userRepository.findOne(emailUser);
		
		//je redirige mon utilisateur sur /location après traitement
		return "redirect:/location";
	}
	
	
}