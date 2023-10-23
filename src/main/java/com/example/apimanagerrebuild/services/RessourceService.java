package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.exception.NullException;
import com.example.apimanagerrebuild.exception.ResourceNotFoundException;
import com.example.apimanagerrebuild.models.Ressources;
import com.example.apimanagerrebuild.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RessourceService {
	
	@Autowired
	RessourceRepository resRepo;
	public Ressources AjoutRessources(Ressources c) {
		resRepo.save(c);
		return c;
	}
	
	public void UpdateRessources(Ressources c,Long id) {
		Ressources ressource = resRepo.findByIdRessource(id);
		
		if(ressource != null) {

			resRepo.save(ressource);
		}else {
			throw new NullException("ressource not found");
		}
		
	}
	
	public void supprimerRessources(Long id) {
		try {
			Ressources Ressources = resRepo.findByIdRessource(id);
		        try {
		    	resRepo.delete(Ressources);
		        }catch(Exception e) {
		        	throw new ResourceNotFoundException("Erreur lors de la suppression");
		        }
		        
			    }catch(Exception e) {
					   throw new NullException("id not found");
				   }
	}
	 public Ressources getById(Long id) {
		  Ressources Ressources = resRepo.findByIdRessource(id);
		  return Ressources;
	 }
	 public List<Ressources> listerRessources(){
		 return resRepo.findAll();
	 }

}
