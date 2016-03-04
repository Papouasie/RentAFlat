package fr.uha.miage.benelhne.zimmerch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

import fr.uha.miage.benelhne.zimmerch.modele.repository.TypeLogementsRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.LogementsRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;
import fr.uha.miage.benelhne.zimmerch.modele.repository.RoleRepository;

@Configuration
@SpringBootApplication
public class ProjetApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
	@Autowired
	private TypeLogementsRepository TypeLogementsRepository;
	@Autowired
	private LogementsRepository LogementsRepository;
	@Autowired
	private UtilisateursRepository UtilisateursRepository;
	@Autowired
	private RoleRepository RoleRepository;
	
    //public static String ROOT = "upload-dir";
	public static String ROOT = "src/main/resources/static/images";
    
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/moncompte").setViewName("moncompte");
        registry.addViewController("/apropos").setViewName("apropos");
        registry.addViewController("/nouveautes").setViewName("nouveautes");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/location").setViewName("location");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/userexist").setViewName("userexist");
        registry.addViewController("/login?error").setViewName("login?error");
        registry.addViewController("/validation").setViewName("validation");
        
        registry.addViewController("/espaceadmin").setViewName("espaceadmin");
        registry.addViewController("/removeUser/{id}").setViewName("espaceadmin");
        registry.addViewController("/activeLog/{l_id}").setViewName("espaceadmin");
        
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/details_logement").setViewName("details_logement");
        registry.addViewController("/proposerlog").setViewName("proposerlog");
        registry.addViewController("/details_logement/{l_id}").setViewName("details_logement");
        registry.addViewController("/deleteLogement/{l_id}").setViewName("location");
        
        registry.addViewController("/carte").setViewName("carte");
        registry.addViewController("/espacemembre").setViewName("espacemembre");
        registry.addViewController("/infospratiques").setViewName("infospratiques");
        registry.addViewController("/entercode").setViewName("entercode");
        registry.addViewController("/oubliMDP").setViewName("oubliMDP");
        
        registry.addViewController("/uploadForm").setViewName("uploadForm");
        registry.addViewController("/upload").setViewName("upload");
        registry.addViewController("/upload-dir/*").setViewName("upload");
        
        registry.addViewController("/newsletter").setViewName("newsletter");
        
        
    }

    @Bean
    CommandLineRunner init() {
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	

	
}
