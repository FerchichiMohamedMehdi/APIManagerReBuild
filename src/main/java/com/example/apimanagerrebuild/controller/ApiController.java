package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.dto.ApiDTO;
import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ApiService apiService;
	

	@GetMapping("/apis")
	public List<ApiDTO> getApis(){
		return apiService.getAllApis();
	}
	@GetMapping("/apis/list")
	public List<Api> getApisa(){
		return apiService.getApis();
	}
	@GetMapping("/apis/NbrApi")
	public int nbrApi(){
		return apiService.NbrApi();
	}
	@GetMapping("/apis/listByCategories/{id}")
	public List<Api> getApisByCat(@PathVariable(value = "id")Long id){
		return apiService.findByCategorie(id);
	}
	


	@PostMapping("/apis")
	public Api AddApi(@RequestBody ApiDTO apiDto){
		   return apiService.ajouterApi(apiDto);
	}

	
	@DeleteMapping("/apis/{id}")
	public void delApi(@PathVariable(value = "id")Long id) {
		apiService.deleteApi(id);
	
	}
	@PutMapping("/apis/update/{id}")
	public void updateApi(@RequestBody ApiDTO api ,@PathVariable(value = "id")Long id) {
		 apiService.UpdateApi(api,id);
	}
	@GetMapping("/apis/{id}")
	public ApiDTO getApi(@PathVariable(value ="id")Long id) {
		return apiService.getApi(id);
	}
	@GetMapping("/apis/getById/{id}")
	public Api getOne(@PathVariable(value ="id")Long id) {
		return apiService.getApiById(id);
	}
	/*@GetMapping("/apis/nbrSoap")
	public int getApisSoap(){
		return apiService.NbrApiSoap();
	}
	@GetMapping("/apis/nbrRest")
	public int getApisRest(){
		return apiService.NbrApiRest();
	}
	@GetMapping("/apis/nbrGraph")
	public int getApisGraph(){
		return apiService.NbrApiGraphhQl();
	}*/
	@GetMapping("/apis/nbrPro")
	public int prototyped() {
		return apiService.NbrPrototyped();
	}
	@GetMapping("/apis/nbrDep")
	public int deprecated() {
		return apiService.NbrDeprecated();
	}
	@GetMapping("/apis/nbrPub")
	public int published() {
		return apiService.NbrPublished();
	}
	@GetMapping("/apis/nbrBlocked")
	public int blocked() {
		return apiService.NbrBlocked();
	}
	@GetMapping("/apis/nbrRet")
	public int retired() {
		return apiService.NbrRetired();
	}
	
	

}
