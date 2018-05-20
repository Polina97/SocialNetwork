package kurbatova.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Profile;
import kurbatova.model.ProfileFriend;
import kurbatova.model.enums.MartialStatus;
import kurbatova.model.enums.UserGender;
import kurbatova.repo.ProfileFriendRepository;
import kurbatova.repo.ProfileRepository;

@RestController
public class FriendsController {
	@Autowired
	ProfileFriendRepository friendRepository;
	@Autowired
	ProfileRepository profileRepository;
	
	@PersistenceContext
    private EntityManager manager;
	
	@PostMapping(value="friends/getFriends")
	public Map<String, Object> getFriends(@RequestParam(value="profileId", required=true) String profileId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<ProfileFriend> profileFriends = friendRepository.findProfileFriends(Long.valueOf(profileId));
			Set<Profile> friends = new HashSet<Profile>();
			for (ProfileFriend profileFriend: profileFriends) {
				if (profileFriend.getProfile().getProfileId() != Long.valueOf(profileId)) {
					friends.add(profileFriend.getProfile());
				}
				if (profileFriend.getFriend().getProfileId() != Long.valueOf(profileId)) {
					friends.add(profileFriend.getFriend());
				}
			}
			result.put("result", 0);
			result.put("friends", friends);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
	
	@PostMapping(value="friends/findFriends")
	public Map<String, Object> findFriends(
			@RequestParam(value="profileId", required=true) String profileId,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="bDayStart", required=false) String bDayStart,
			@RequestParam(value="bDayEnd", required=false) String bDayEnd,
			@RequestParam(value="gender", required=false) String gender,
			@RequestParam(value="martialStatus", required=false) String martialStatus) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {		
			String query = "SELECT * FROM social_network.profile p WHERE p.id != " + profileId + " ";
			if (gender != null) {
				query += "AND p.gender = '" + UserGender.values()[Integer.valueOf(gender)] + "' ";
			}
			if (martialStatus != null) {
				query += "AND p.martial_status = '" + MartialStatus.values()[Integer.valueOf(martialStatus)] + "' ";
			}
			if (bDayStart != null && bDayEnd != null) {
				query += "AND (p.birth_date > '" + bDayStart +"' AND p.birth_date < '" + bDayEnd + "') ";
			}
			if (name != null) {
				String[] nameParts = name.split(" ");
				String firstPart = "";
				String secondPart = "";
				if (nameParts.length > 1) {
					firstPart = nameParts[0];
					for (Integer i=1; nameParts.length > i; i++) {
						secondPart += nameParts[i];
					}
					query += "AND (p.first_name LIKE '%" + firstPart + "%' OR p.last_name LIKE '%" + firstPart + "%' " +
							"OR p.first_name LIKE '%" + secondPart +"%' OR p.last_name LIKE '%" + secondPart +"%') ";
				} else {
					query += "AND (p.first_name LIKE '%" + name + "%' OR p.last_name LIKE '%" + name + "%') ";
				}
			}
			query += "AND p.id NOT IN " + 
					"(SELECT profile_id FROM social_network.profile_friend pf WHERE pf.profile_id = " + profileId + " OR pf.friend_id = " + profileId + ") " + 
					"AND p.id NOT IN " + 
					"(SELECT friend_id FROM social_network.profile_friend pf WHERE pf.profile_id = " + profileId + " OR pf.friend_id = " + profileId + ")";
			
			@SuppressWarnings("rawtypes")
			List notFriends = manager.createNativeQuery(query, Profile.class).getResultList();

			result.put("result", 0);
			result.put("notFriends", notFriends);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
}
