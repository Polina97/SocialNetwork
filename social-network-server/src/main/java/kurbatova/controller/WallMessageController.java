package kurbatova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.repo.WallMessageRepository;

@RestController
public class WallMessageController {
	@Autowired
	WallMessageRepository repository;
}
