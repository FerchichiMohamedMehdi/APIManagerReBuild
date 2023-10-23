package com.example.apimanagerrebuild.services;

import com.Gestionnaire_API.DTO.ApiDTO;
import com.Gestionnaire_API.Exception.NullException;
import com.Gestionnaire_API.Modele.*;
import com.Gestionnaire_API.Repository.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiService {

	
	@Autowired ModelMapper modelMapper;
	@Autowired ApiRepository apiRepo;
	@Autowired IntervenantRepository intRepo;
	@Autowired CategorieRepository catRepo;
	@Autowired TagRepository tagRepo;
	@Autowired CategorieService catService;
	@Autowired IntervenantService iService;
	@Autowired TypeApiService tService;
     @Autowired RessourceRepository rRepo;
	@Autowired TagService tagService;
	public ApiDTO ToDto(Api api) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT);
		ApiDTO apiDto = new ApiDTO();
		
		apiDto = modelMapper.map(api, ApiDTO.class);

		return apiDto;
			}
	
	/*-------- methode To Entity-------*/
	public Api ToEntity(ApiDTO apiDTO) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		Api api = new Api();
		  /*api.setCategorie(catService.getById(apiDTO.getIdCategorie()));
		    api.setFournisseur(iService.getById(apiDTO.getIdIntervenant()));
		    api.setType(tService.getById(apiDTO.getIdTypeApi()));*/
		api = modelMapper.map(apiDTO, Api.class);
	  
		return api;
	}

	/*-------- methode Lister APIs-------*/
	public List<ApiDTO> getAllApis(){
		return apiRepo.findAll()
				.stream()
				.map(this::ToDto)
				.collect(Collectors.toList());
	}
	public List<Api> getApis(){
		return apiRepo.findAll();
	}
	public int NbrApi() {
		return apiRepo.findAll().size();
	}
	
/*-------- methode Get Api by ID-------*/
	
	public ApiDTO getApi(long id) {
		Api api = apiRepo.findByIdApi(id);
		return ToDto(api);
	}
	

	
	/*-------- methode Delete API-------*/
	public void deleteApi(Long id) {
		Api api = apiRepo.findByIdApi(id);
		if (id == null) {
			throw new NullException("Id not found");
		}
		List<Api_Tag> lst = api.getTags();
		for(Api_Tag ap:lst) {
			Tag tag = tagRepo.findById(ap.getTags().getIdTag()).get();
			tag.setOccurence(tag.getOccurence()-1);
			api.removeTag(tag);
		}
		apiRepo.delete(api);
	}
	/*-------- methode Ajout API-------*/
	public Api ajouterApi(ApiDTO apiDTO) {
		System.out.println(apiDTO.toString());
		Api api = apiRepo.save(toEntity(apiDTO));
		List<Ressources> lst = apiDTO.getResources();
	    for(Ressources r: lst ) {
	    	r.setApi(api);
	    	rRepo.save(r);
	    }
	    System.out.println(api.toString());
		return api;
			
	}

	
    /*-------- methode Mise a jour API-------*/
   public void UpdateApi(ApiDTO apiDto,Long id) {
   	Api api  = apiRepo.findByIdApi(id);
   	if(api!=null) {
   		
     api =  this.toEntity(apiDto);
     api.setIdApi(id);
     apiRepo.save(api);
			System.out.println("save ok");
   }else {
	   throw new NullException("api null");
   }
   }
   
   
   public Api getApiById(Long id) {
	   return apiRepo.findByIdApi(id);
   }
   
   
   
	 public Api toEntity(ApiDTO apiDTO) {
		 Api api = new Api();
		 api.setCategorie(apiDTO.categorie);
		 api.setFournisseur(apiDTO.fournisseur);
		 api.setType(apiDTO.type);
		 api.setNomApi(apiDTO.nomApi);
		 api.setDateVersion(apiDTO.dateVersion);
		 api.setDefault(apiDTO.isDefault);
		 api.setListFiles(apiDTO.listFiles);
		 api.setEtat(apiDTO.etat);
		 api.setUrl(apiDTO.url);
		 api.setVersion(apiDTO.version);
		 api.setDescription(apiDTO.description);
		 List<String> lst1 =apiDTO.getTags();
			List<Api_Tag> lst2= new ArrayList<>();
			
	    	for(String s: lst1) {
	    	if	(tagService.getTagsByNom(s)==null) {
	    		Tag tag = new Tag();
	    		tag.setNomTag(s);
	    		tagRepo.save(tag);
	    		Api_Tag atTags =new Api_Tag(api, tag);
	    		lst2.add(atTags);
	           api.setTags(lst2);
	    	}else {
	    		Tag t = tagService.getTagsByNom(s);
	    		int i = t.getOccurence();
	    		t.setOccurence(i+1);
	    		tagService.UpdateTags(t);
	    		Api_Tag atTags =new Api_Tag(api, t);
	    		lst2.add(atTags);
	           api.setTags(lst2);
	    		
	    	}
	   
	    	}
		 return api;
	 }
	 
	 public List<Api> findByCategorie(Long id){
		 return apiRepo.findByCategorie(catService.getById(id));
	 }
	 public List<Api> findByType(Long id){
		 return apiRepo.findByType(tService.getById(id));
	 }
	public int NbrPrototyped() {
		return apiRepo.findByEtat(Etat.Prototyped).size();
	}
	public int NbrPublished() {
		return apiRepo.findByEtat(Etat.Published).size();
	}
	public int NbrDeprecated() {
		return apiRepo.findByEtat(Etat.Deprecated).size();
	}
	public int NbrBlocked() {
		return apiRepo.findByEtat(Etat.Blocked).size();
	}
	public int NbrRetired() {
		return apiRepo.findByEtat(Etat.Retired).size();
	}
	
}
