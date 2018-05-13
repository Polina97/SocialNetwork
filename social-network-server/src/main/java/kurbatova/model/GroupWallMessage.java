package kurbatova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "group_wall_message")
public class GroupWallMessage implements Serializable {

	private static final long serialVersionUID = 3779757678526898445L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "message")
	private String message;
	@Column(name = "date")
	private Date date;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
	@JoinColumn(name = "group_id")
	private Group group;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "owner_id")
	private Profile profile;

	public GroupWallMessage() {
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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return String.format("GroupWallMessage[id=%d, message='%s', date='%s']",id,  message, date);
	}
}
