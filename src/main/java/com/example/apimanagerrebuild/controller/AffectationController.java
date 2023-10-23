package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.dto.AffectationDTO;
import com.example.apimanagerrebuild.models.Affectation;
import com.example.apimanagerrebuild.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AffectationController {
@Autowired
AffectationService afService;
	
	@PostMapping("/Affectations/add")
	public Affectation AjoutAffectation(@RequestBody AffectationDTO c) {
		return afService.ajouter(c);
	}
	@GetMapping("/Affectations/list")
	public List<AffectationDTO> listAffectations(){
		return afService.listerAffectations();
	}
	@GetMapping("/Affectations/list/Affectations")
	public List<Affectation> getAllAffectations(){
		return afService.getAll();
	}
	@GetMapping("/Affectations/NbrAffectations")
	public int nbrAffectations(){
		return afService.NbrAffectations();
	}
	@PutMapping("/Affectations/update/{id}")
	public void updateApi(@RequestBody AffectationDTO afDto,@PathVariable(value = "id")Long id ) {
		 afService.UpdateAffectation(afDto, id);
	}
	@DeleteMapping("/Affectations/delete/{id}")
	public void deleteAffectation(@PathVariable(value = "id")Long id) {
		
		afService.deleteAf(id);
	
	}
	@GetMapping("/Affectations/{id}")
	public AffectationDTO getAffectationById(@PathVariable(value ="id")Long id) {
		return afService.getAffectation(id);
	}
	

}
