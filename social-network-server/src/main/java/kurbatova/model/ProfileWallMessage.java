package kurbatova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile_wall_message")
public class ProfileWallMessage implements Serializable {

	private static final long serialVersionUID = 3528053478510234916L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "message")
	private String message;
	@Column(name = "date")
	private Date date;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Profile messageOwner;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	public ProfileWallMessage() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Profile getMessageOwner() {
		return messageOwner;
	}
	public void setMessageOwner(Profile messageOwner) {
		this.messageOwner = messageOwner;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return String.format("ProfileWallMessage[id=%d, message='%s', date='%s']",id,  message, date);
	}
}
