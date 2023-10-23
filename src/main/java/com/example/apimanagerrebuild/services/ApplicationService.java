package com.example.apimanagerrebuild.services;

import com.Gestionnaire_API.DTO.ApplicationDTO;
import com.Gestionnaire_API.Exception.NullException;
import com.Gestionnaire_API.Exception.ResourceNotFoundException;
import com.Gestionnaire_API.Modele.Application;
import com.Gestionnaire_API.Modele.Intervenant;
import com.Gestionnaire_API.Repository.ApplicationRepository;
import com.Gestionnaire_API.Repository.IntervenantRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
	
@Autowired ModelMapper modelMapper;
	
	@Autowired ApplicationRepository appRepo;
	@Autowired IntervenantRepository iRepo;
	
	public ApplicationDTO ToDto(Application ap) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		ApplicationDTO apDto = new ApplicationDTO();
		apDto = modelMapper.map(ap, ApplicationDTO.class);
		return apDto;
			}
	
	
	public Application toEntity(ApplicationDTO apdto) {
		Application ap = new Application();
		ap.setClient(iRepo.findById(apdto.getIdIntervenant()).get());
		ap.setNomApplication(apdto.getNomApplication());
		return ap;
	    
	}
	public List<ApplicationDTO> listerApplication(){
		return appRepo.findAll()
				.stream()
				.map(this::ToDto)
				.collect(Collectors.toList());
	}
	
	public Application AjoutApplication(ApplicationDTO app) {
		
		 Application ap =appRepo.save(toEntity(app));
		return ap;
	}
	
	public void UpdateApplication(Application app,Long id) {
		Application  ap = appRepo.findByIdApplication(id);
		if(ap != null) {
			appRepo.save(ap);
		}
		else {
			 throw new NullException("Application not found");
		}
	}
	
	public void supprimerApplication(Long id) {
		try {
			Application t = appRepo.findById(id).get();
		        try {
		    	appRepo.delete(t);
		        }catch(Exception e) {
		        	throw new ResourceNotFoundException("Erreur lors de la suppression");
		        }
		        
			    }catch(Exception e) {
					   throw new NullException("id not found");
				   }
	}
	 public Application getById(Long id) {
		 return appRepo.findByIdApplication(id);
	 }
	 public List<String> getAppsNames(){
		 List<Application> apps = appRepo.findAll();
		 List<String> appsNames =new ArrayList<String>();
		 for(Application a:apps) {
			 String s = a.getNomApplication();
			 appsNames.add(s);
		 }
		 return appsNames;
	 }
   public List<Application> findByClient(Intervenant client){
	   return appRepo.findByClient(client);
   }
	

}
