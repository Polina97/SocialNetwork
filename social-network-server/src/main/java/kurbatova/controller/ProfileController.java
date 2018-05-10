package kurbatova.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Profile;
import kurbatova.model.User;
import kurbatova.repo.ProfileRepository;

@RestController
public class ProfileController {
	@Autowired
	ProfileRepository profileRepository;
	
	@PostMapping(value="profile/getById")
	public Map<String, Object> getProfileById(@RequestParam(value="userId", required=true) String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			User user = new User();
			user.setUserId(Long.valueOf(userId));
			Profile profile = profileRepository.getProfileById(user);
			result.put("result", 0);
			result.put("profile", profile);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
}
