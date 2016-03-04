package fr.uha.miage.benelhne.zimmerch.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NamedQuery(name = "Users.findByEnabled",
			query = "SELECT U FROM Users U WHERE U.enabled =1 OR U.enabled =0")
@NamedQueries({
	@NamedQuery(name = "Users.findByUserName",
				query = "select id,username from Users where username = ?1"),
	@NamedQuery(name = "Users.findByEmail",
				query = "SELECT U FROM Users U WHERE U.username = ?1")
})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    //@OneToMany(fetch=FetchType.EAGER)

    //private List<Logement> logements=new ArrayList<Logement>();
	
	private String lastname;
	private String userdate;
	private String username;
	private String password;
	private String surname;
	private String email;
	private String tel;
	
	private int enabled;

	
	public Users() {
		super();
	}
	
	/*private List<Role> role_user=new ArrayList();
	
	public List<Role> getRole_user() {
		return role_user;
	}

	public void setRole_user(List<Role> role_user) {
		this.role_user = role_user;
	}*/


	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/*public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users(Long id) {
		super();
		this.id = id;
	}

	/*public Users(String username_u, String email_u, String mdp_u,
			int enabled_u, String surname_u, int userid_u) {
		// TODO Auto-generated constructor stub
	}*/

	public String getUsername() {
		return username;
	}

	public Users(Long id,
			String username,
			String email,
			String password,
			int enabled,
			String surname) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.surname = surname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		this.password=hashedPassword;
	}

	public Object getUsername(String user_good) {
		return null;
	}

	public String getUserdate() {
		return userdate;
	}

	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}




}
	