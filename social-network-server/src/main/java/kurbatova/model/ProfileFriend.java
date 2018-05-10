package kurbatova.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kurbatova.model.enums.FriendshipStatus;

@Entity
@Table(name = "profile_friend")
public class ProfileFriend implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long profileFriendId;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "profile_id")
	private Profile profile;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
	@JoinColumn(name = "friend_id")
	private Profile friend;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private FriendshipStatus friendshipStatus;

	public Long getProfileFriendId() {
		return profileFriendId;
	}
	public void setProfileFriendId(Long profileFriendId) {
		this.profileFriendId = profileFriendId;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Profile getFriend() {
		return friend;
	}
	public void setFriend(Profile friend) {
		this.friend = friend;
	}
	public FriendshipStatus getFriendshipStatus() {
		return friendshipStatus;
	}
	public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
		this.friendshipStatus = friendshipStatus;
	}
}
