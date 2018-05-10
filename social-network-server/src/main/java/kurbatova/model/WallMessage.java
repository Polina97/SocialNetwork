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

@Entity
@Table(name = "wall_message")
public class WallMessage implements Serializable {

	private static final long serialVersionUID = -7731147650763286399L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long wallMessageId;
	@Column(name = "message")
	private String message;
	@Column(name = "date")
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "message_owner")
	private Profile messageOwner;

	public Long getWallMessageId() {
		return wallMessageId;
	}
	public void setWallMessageId(Long wallMessageId) {
		this.wallMessageId = wallMessageId;
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
}
