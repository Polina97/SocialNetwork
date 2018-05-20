package kurbatova.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Profile;
import kurbatova.repo.ProfilePhotoRepository;
import kurbatova.repo.ProfileRepository;
import kurbatova.repo.ProfileWallMessageRepository;

@RestController
public class ProfileController {
	@Autowired
	ProfileRepository profileRepository;
	@Autowired
	ProfileWallMessageRepository profileWallMessagesRepo;
	@Autowired
	ProfilePhotoRepository photoRepository;
	
	@PostMapping(value="profile/getByUserId")
	public Map<String, Object> getProfileByUserId(@RequestParam(value="userId", required=true) String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Profile profile = profileRepository.getByUserId(Long.valueOf(userId));
			result.put("result", 0);
			result.put("profile", profile);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
	
	@PostMapping(value="profile/getProfile")
	public Map<String, Object> getProfileById(@RequestParam(value="profileId", required=true) String profileId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Set<Profile> profileSet = profileRepository.getProfileByProfileId(profileId);
			Object[] profileArr = profileSet.toArray();
			result.put("result", 0);
			result.put("profile", profileArr[0]);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
}
