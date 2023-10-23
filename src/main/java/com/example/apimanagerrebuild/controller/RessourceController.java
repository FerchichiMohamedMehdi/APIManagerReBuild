package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Ressources;
import com.example.apimanagerrebuild.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RessourceController {
	
	@Autowired
	RessourceService resService;
	
	@PostMapping("/Ressources/add")
	public Ressources AjoutRessourcess(@RequestBody Ressources c) {
		return resService.AjoutRessources(c);
	}
	
	@PutMapping("/Ressources/update/{id}")
	public void updateRessources(@RequestBody Ressources i,@PathVariable(value ="id") Long id) {
		resService.UpdateRessources(i,id);
	}
	
	@GetMapping("/Ressources/list")
	public List<Ressources> listRessourcess(){
		return resService.listerRessources();
	}
	
	@GetMapping("/Ressources/getById/{id}")
    public Ressources getById(@PathVariable(value ="id") Long id) {
		return resService.getById(id);
	}
	
	@DeleteMapping("/Ressources/delete/{id}")
	public void deleteRessources(@PathVariable(value ="id") Long id) {
		 resService.supprimerRessources(id);
	}

}
