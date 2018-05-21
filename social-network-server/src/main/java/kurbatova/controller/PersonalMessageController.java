package kurbatova.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.PersonalMessage;
import kurbatova.model.PersonalMessageProfile;
import kurbatova.model.Profile;
import kurbatova.repo.PersonalMessageProfileRepository;
import kurbatova.repo.PersonalMessageRepository;
import kurbatova.repo.ProfileRepository;

@RestController
public class PersonalMessageController {
	@Autowired
	PersonalMessageRepository messageRepo;
	@Autowired
	PersonalMessageProfileRepository messageProfileRepo;
	@Autowired
	ProfileRepository profileRepo;
	
	@PostMapping(value="message/writeMessage")
	public Map<String, Object> writeMessage(
			@RequestParam(value="ownerId", required=true) String ownerId,
			@RequestParam(value="targetId", required=true) String targetId,
			@RequestParam(value="message", required=true) String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Profile owner = new Profile();
			owner.setProfileId(Long.valueOf(ownerId));
			Profile target = new Profile();
			target.setProfileId(Long.valueOf(targetId));
			
			PersonalMessage personalMessage = new PersonalMessage();
			personalMessage.setOwner(owner);
			personalMessage.setMessage(message);
			personalMessage.setReaded(false);
			personalMessage.setDate(new Date());
			personalMessage = messageRepo.save(personalMessage);
			
			PersonalMessageProfile persMessageProfile = new PersonalMessageProfile();
			persMessageProfile.setProfile(target);
			persMessageProfile.setPersonalMessage(personalMessage);
			persMessageProfile.setIsGroupChat(false);
			messageProfileRepo.save(persMessageProfile);
			
			result.put("result", 0);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
	
	@PostMapping(value="message/getDialogs")
	public Map<String, Object> getDialogs(@RequestParam(value="ownerId", required=true) String ownerId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Long ownerIdLong = Long.valueOf(ownerId);
			Set<PersonalMessageProfile> messagesProfiles = messageProfileRepo.getDialogs(ownerIdLong);
			Set<Long> profileIds = new HashSet<Long>();
			for (PersonalMessageProfile messageProfile : messagesProfiles) {
				Long profileId = messageProfile.getProfile().getProfileId();
				if (profileId != ownerIdLong) {
					profileIds.add(profileId);
				}
				
				if (messageProfile.getPersonalMessage() != null) {
					Long ownerProfileId = messageProfile.getPersonalMessage().getOwner().getProfileId();
					if (ownerProfileId != ownerIdLong) {
						profileIds.add(ownerProfileId);
					}
				}
			}
			
			Iterable<Profile> profiles = profileRepo.getProfilesById((Iterable<Long>) profileIds);

			result.put("result", 0);
			result.put("profiles", profiles);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}
		
		return result;
	}
}
