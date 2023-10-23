package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TagController {
	@Autowired TagService tagService;
	
	@PostMapping("/tags/add")
	public Tag AjoutTags(@RequestBody Tag t) {
		return tagService.AjoutTags(t);
	}
	
	@PutMapping("/tags/update")
	public void updateTags(@RequestBody Tag t) {
		tagService.UpdateTags(t);
	}
	
	@GetMapping("/tags/list")
	public List<Tag> listTags(){
		return tagService.listerTags();
	}
	
	@GetMapping("/tags/getById/{id}")
    public Tag getById(@PathVariable(value ="id") Long id) {
		return tagService.getById(id);
	}
	
	@DeleteMapping("/tags/delete/{id}")
	public void deleteTags(@PathVariable(value ="id") Long id) {
		 tagService.supprimerTags(id);
	}
	@GetMapping("/tags/listNomTags")
	public List<String> listNomTags(){
		return tagService.listerNameTags();
	}

}
