package kurbatova.model;

import java.io.Serializable;

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
@Table(name = "personal_message_profile")
public class PersonalMessageProfile implements Serializable {

	private static final long serialVersionUID = -7571502462765592151L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long personalMessageProfileId;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "profile_id")
	private Profile profile;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PersonalMessage.class)
	@JoinColumn(name = "personal_message_id")
	private PersonalMessage personalMessage;
	@Column(name = "GROUP_CHAT")
	private Boolean isGroupChat;
	
	public PersonalMessageProfile() {
	}

	public Long getPersonalMessageProfileId() {
		return personalMessageProfileId;
	}
	public void setPersonalMessageProfileId(Long personalMessageProfileId) {
		this.personalMessageProfileId = personalMessageProfileId;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public PersonalMessage getPersonalMessage() {
		return personalMessage;
	}
	public void setPersonalMessage(PersonalMessage personalMessage) {
		this.personalMessage = personalMessage;
	}
	public Boolean getIsGroupChat() {
		return isGroupChat;
	}
	public void setIsGroupChat(Boolean isGroupChat) {
		this.isGroupChat = isGroupChat;
	}
	
	@Override
	public String toString() {
		String result = String.format("PersonalMessageProfile[personalMessageProfileId=%d, isGroupChat='%s']%n",
				personalMessageProfileId, isGroupChat);
		if (profile != null) {
            result += String.format("Profile[profileId=%d]%n",
            		profile.getProfileId());
        }
		if (personalMessage != null) {
            result += String.format("PersonalMessage[personalMessageId=%d, ownerId='%s']",
            		personalMessage.getPersonalMessageId(), personalMessage.getOwner().getProfileId());
        }
		return result;
	}
}
