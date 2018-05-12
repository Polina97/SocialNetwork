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
@Table(name = "profile_photo")
public class ProfilePhoto implements Serializable {

	private static final long serialVersionUID = -5367919916019744214L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long profilePhotoId;
	@Column(name = "URL")
	private String url;
	@Column(name = "CURRENT")
	private Boolean current;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	public ProfilePhoto() {
	}

	public Long getProfilePhotoId() {
		return profilePhotoId;
	}
	public void setProfilePhotoId(Long profilePhotoId) {
		this.profilePhotoId = profilePhotoId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getCurrent() {
		return current;
	}
	public void setCurrent(Boolean current) {
		this.current = current;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return String.format("ProfilePhoto[profilePhotoId=%d, url='%s', current='%s']", profilePhotoId, url, current);
	}
}
