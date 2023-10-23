package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.dto.ApplicationDTO;
import com.example.apimanagerrebuild.models.Application;
import com.example.apimanagerrebuild.services.ApplicationService;
import com.example.apimanagerrebuild.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ApplicationController {
@Autowired
ApplicationService appService;
@Autowired
IntervenantService iService;
	@PostMapping("/Applications/add")
	public Application AjoutApplications(@RequestBody ApplicationDTO c) {
		return appService.AjoutApplication(c);
	}
	
	@PutMapping("/Applications/update/{id}")
	public void updateApplication(@RequestBody Application i,@PathVariable(value ="id") Long id) {
		appService.UpdateApplication(i,id);
	}
	
	@GetMapping("/Applications/list")
	public List<ApplicationDTO> listApplications(){
		return appService.listerApplication();
	}
	@GetMapping("/Applications/listByClient/{id}")
	public List<Application> listApplicationsByClients(@PathVariable(value ="id") Long id){
		return appService.findByClient(iService.getById(id));
	}
	@GetMapping("/Applications/listNom")
	public List<String> listNomApplications(){
		return appService.getAppsNames();
	}
	
	
	@GetMapping("/Applications/getById/{id}")
    public Application getById(@PathVariable(value ="id") Long id) {
		return appService.getById(id);
	}
	
	@DeleteMapping("/Applications/delete/{id}")
	public void deleteApplication(@PathVariable(value ="id") Long id) {
		 appService.supprimerApplication(id);
	}

}
