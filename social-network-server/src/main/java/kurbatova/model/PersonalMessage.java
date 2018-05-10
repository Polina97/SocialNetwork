package kurbatova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_message")
public class PersonalMessage implements Serializable {

	private static final long serialVersionUID = -4853992926000654315L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long personalMessageId;
	@Column(name = "MESSAGE")
	private String message;
	@Column(name = "READED")
	private Boolean readed;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "EDIT_END_DATE")
	private Date editEndDate;

	public Long getPersonalMessageId() {
		return personalMessageId;
	}
	public void setPersonalMessageId(Long personalMessageId) {
		this.personalMessageId = personalMessageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getReaded() {
		return readed;
	}
	public void setReaded(Boolean readed) {
		this.readed = readed;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getEditEndDate() {
		return editEndDate;
	}
	public void setEditEndDate(Date editEndDate) {
		this.editEndDate = editEndDate;
	}
}
