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

@Entity
@Table(name = "profile_group")
public class ProfileGroup implements Serializable {

	private static final long serialVersionUID = 7331404152161089468L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long profileGroupId;
	@Column(name = "CONFIRMED")
	private Boolean confirmed;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
	@JoinColumn(name = "group_id")
	private Group group;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "profile_id")
	private Profile profile;

	public Long getProfileGroupId() {
		return profileGroupId;
	}
	public void setProfileGroupId(Long profileGroupId) {
		this.profileGroupId = profileGroupId;
	}
	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
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
}
