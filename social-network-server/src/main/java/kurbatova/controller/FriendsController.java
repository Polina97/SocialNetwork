package kurbatova.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Profile;
import kurbatova.model.ProfileFriend;
import kurbatova.repo.ProfileFriendRepository;
import kurbatova.repo.ProfileRepository;

@RestController
public class FriendsController {
	@Autowired
	ProfileFriendRepository friendRepository;
	@Autowired
	ProfileRepository profileRepository;
	
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
	public Map<String, Object> findFriends(@RequestParam(value="profileId", required=true) String profileId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<Profile> notFriends = profileRepository.findNewFriends(profileId);
			result.put("result", 0);
			result.put("notFriends", notFriends);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
}
