package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Categorie;
import com.example.apimanagerrebuild.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {
	
   @Autowired
   CategorieService catService;
	
	@PostMapping("/Categories/add")
	public Categorie AjoutCategories(@RequestBody Categorie c) {
		return catService.AjoutCategorie(c);
	}
	
	@PutMapping("/Categories/update/{id}")
	public void updateCategorie(@RequestBody Categorie i,@PathVariable(value ="id") Long id) {
		catService.UpdateCategorie(i,id);
	}
	
	@GetMapping("/Categories/list")
	public List<Categorie> listCategories(){
		return catService.listerCategorie();
	}
	
	@GetMapping("/Categories/getById/{id}")
    public Categorie getById(@PathVariable(value ="id") Long id) {
		return catService.getById(id);
	}
	
	@DeleteMapping("/Categories/delete/{id}")
	public void deleteCategorie(@PathVariable(value ="id") Long id) {
		 catService.supprimerCategorie(id);
	}

}
