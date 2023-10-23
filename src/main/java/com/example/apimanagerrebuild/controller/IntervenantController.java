package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Intervenant;
import com.example.apimanagerrebuild.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IntervenantController {
	
@Autowired
IntervenantService intService;
	
	@PostMapping("/Intervenants/add")
	public Intervenant AjoutIntervenants(@RequestBody Intervenant i) {
		return intService.ajoutIntervenant(i);
	}
	
	@PutMapping("/Intervenants/update/{id}")
	public void updateIntervenant(@RequestBody Intervenant i,@PathVariable(value ="id") Long id) {
		intService.UpdateIntervenant(i,id);
	}
	
	@GetMapping("/Intervenants/list")
	public List<Intervenant> listIntervenants(){
		return intService.listerIntervenant();
	}
	@GetMapping("/Intervenants/NbrIntervenant")
	public int nbrIntervenants(){
		return intService.NbrIntervenant();
	}
	@GetMapping("/Intervenants/NbrClients")
	public int nbrClients(){
		return intService.NbrClients();
	}
	@GetMapping("/Intervenants/NbrFournisseurs")
	public int nbrFournisseurs(){
		return intService.NbrFournisseurs();
	}
	
	@GetMapping("/Intervenants/getById/{id}")
    public Intervenant getById(@PathVariable(value ="id") Long id) {
		return intService.getById(id);
	}
	
	
	@DeleteMapping("/Intervenants/delete/{id}")
	public void deleteIntervenant(@PathVariable(value ="id") Long id) {
		 intService.supprimerIntervenant(id);
	}
	@GetMapping("/Intervenants/getClients")
    public List<Intervenant> getClients() {
		return intService.getAllClient();
	}
	@GetMapping("/Intervenants/getFournisseurs")
    public List<Intervenant> getFournisseurs() {
		return intService.getAllFournisseurs();
	}
	

}
