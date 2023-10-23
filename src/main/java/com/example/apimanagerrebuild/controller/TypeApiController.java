package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.TypeApi;
import com.example.apimanagerrebuild.services.TypeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypeApiController {
	
	@Autowired
	TypeApiService typeService;
	
	@PostMapping("/TpyeApi/add")
	public TypeApi AjoutTypeApis(@RequestBody TypeApi c) {
		return typeService.AjoutTypeApi(c);
	}
	
	@PutMapping("/TypeApis/update/{id}")
	public void updateTypeApi(@RequestBody TypeApi i,@PathVariable(value ="id") Long id) {
		typeService.UpdateTypeApi(i,id);
	}
	
	@GetMapping("/TypeApis/list")
	public List<TypeApi> listTypeApis(){
		return typeService.listerTypeApis();
	}
	
	@GetMapping("/TypeApis/getById/{id}")
    public TypeApi getById(@PathVariable(value ="id") Long id) {
		return typeService.getById(id);
	}
	
	@DeleteMapping("/TypeApis/delete/{id}")
	public void deleteTypeApi(@PathVariable(value ="id") Long id) {
		 typeService.supprimerTypeApi(id);
	}


}
