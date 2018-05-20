package kurbatova.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Group;
import kurbatova.repo.GroupRepository;

@RestController
public class GroupController {
	@Autowired
	GroupRepository groupRepo;
	
	@PostMapping(value="groups/getGroups")
	public Map<String, Object> login() {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<Group> groups = groupRepo.getAll();
			result.put("result", 0);
			result.put("groups", groups);
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}

		return result;
	}
}
