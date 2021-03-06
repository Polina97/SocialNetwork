package kurbatova.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kurbatova.model.enums.FriendshipStatus;

@Entity
@Table(name = "profile_friend")
public class ProfileFriend implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long profileFriendId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "friend_id")
	private Profile friend;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private FriendshipStatus friendshipStatus;
	
	public ProfileFriend() {
	}

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
	
	@Override
	public String toString() {
		return String.format("ProfileFriend[profileFriendId=%d, friend='%s', friendshipStatus='%s']", profileFriendId, friend, friendshipStatus);
	}
}
