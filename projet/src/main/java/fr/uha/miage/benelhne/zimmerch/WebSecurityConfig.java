package fr.uha.miage.benelhne.zimmerch;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.benelhne.zimmerch.modele.Users;
import fr.uha.miage.benelhne.zimmerch.modele.repository.UtilisateursRepository;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	

	
	@Autowired
	DataSource dataSource;
	
	//public static String ROOT = "upload-dir";
	public static String ROOT = "src/main/resources/templates/images";
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost/utilisateurs");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("");
		return driverManagerDataSource;
	}
	
    @Bean
    CommandLineRunner init() {
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, role from user_roles where username=?")
			;
	}
	


	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder password = new BCryptPasswordEncoder();
		return password;
	}
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/index",
                			 "/",
                			 "/css/*",
                			 "/js/*",
                			 "/img/*",
                			 "/dist/*",
                			 "/userexist",
                			 "/validation",
                			 "/apropos",
                			 "/location",
                			 "/contact",
                			 "/nouveautes",
                			 "/register",
                			 "/details_logement",
                			 "/details_logement/*",
                			 "/infospratiques",
                			 "/uploadForm",
                			 "/upload",
                			 "/upload-dir/*",
                			 "/carte",
                			 "/entercode",
                			 "/oubliMDP",
                			 "/activeLog/*",
                			 "/newsletter",
                			 "/login"
                		).permitAll()
				//.antMatchers("/admin/**").hasRole("ADMIN")
				//.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
				.anyRequest().authenticated()
				.and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
        
        //http.csrf().disable();
    }
    
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/index";
	}
	


   /*@Bean @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
   @Autowired
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth
           .inMemoryAuthentication()
               .withUser("user@locavacances.fr").password("password").roles("USER").and()
               .withUser("admin@locavacances.fr").password("password").roles("USER", "ADMIN");
   }*/
   
}