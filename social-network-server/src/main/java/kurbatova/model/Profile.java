package kurbatova.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kurbatova.model.enums.MartialStatus;
import kurbatova.model.enums.UserGender;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {
	
	private static final long serialVersionUID = -2857618689675119043L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long profileId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "BIRTH_DATE")
	private Date birthDay;
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER")
	private UserGender userGender;
	@Column(name = "ADDRESS")
	private String address;
	@Enumerated(EnumType.STRING)
	@Column(name = "martial_status")
	private MartialStatus martialStatus;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@JoinTable(name = "profile_wall", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = { @JoinColumn(name = "wall_message_id") })
	@ManyToMany(targetEntity = WallMessage.class, fetch = FetchType.LAZY)
	private Set<WallMessage> wallMessages = new TreeSet<WallMessage>();
	
	protected Profile() {
	}
	
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public UserGender getUserGender() {
		return userGender;
	}
	public void setUserGender(UserGender userGender) {
		this.userGender = userGender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MartialStatus getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(MartialStatus martialStatus) {
		this.martialStatus = martialStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<WallMessage> getWallMessages() {
		return wallMessages;
	}
	public void setWallMessages(Set<WallMessage> wallMessages) {
		this.wallMessages = wallMessages;
	}
	
	@Override
	public String toString() {
		return String.format("Profile[id=%d, firstName='%s', lastName='%s', birthDay='%s', userGender='%s', address='%s', martialStatus='%s']",
				profileId,  firstName, lastName, birthDay, userGender, address, martialStatus);
	}
}
