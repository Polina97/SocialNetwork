package kurbatova.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long userId;
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "BLOCKED")
	private Boolean blocked;
	@Column(name = "EMAIL")
	private String email;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Profile profile;
	@ManyToOne
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;
	
	public User() {
	}

	public User(String login, String password, Boolean blocked, String email, UserRole userRole) {
		this.login = login;
		this.password = password;
		this.blocked = blocked;
		this.email = email;
		this.userRole = userRole;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		String result = String.format("User[userId=%d, login='%s', password='%s', blocked='%s', email='%s', userRole='%s']%n", userId,  login, password,
				blocked, email, userRole);
		result += String.format("Profile[id=%d, firstName='%s', lastName='%s', birthDay='%s', userGender='%s', address='%s', martialStatus='%s']", 
				profile.getProfileId(), profile.getFirstName(), profile.getLastName(), profile.getBirthDay(), profile.getUserGender(),
				profile.getAddress(), profile.getMartialStatus());
		return result;
	}
}
