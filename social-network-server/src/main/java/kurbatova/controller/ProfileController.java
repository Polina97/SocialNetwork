package kurbatova.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Profile;
import kurbatova.model.ProfilePhoto;
import kurbatova.model.ProfileWallMessage;
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
	
	@PostMapping(value="profile/getById")
	public Map<String, Object> getProfileById(@RequestParam(value="userId", required=true) String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Profile profile = profileRepository.getProfileByUserId(userId);
			List<ProfileWallMessage> profileWallMessages = profileWallMessagesRepo.findAllByMessageOwner(profile);
			List<ProfilePhoto> profilePhotos = photoRepository.findByProfileAndCurrent(profile, true);
			result.put("result", 0);
			result.put("profile", profile);
			result.put("wallMessages", profileWallMessages);
			if (!profilePhotos.isEmpty()) {
				result.put("photoUrl", profilePhotos.get(0).getUrl());
			}
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
}
