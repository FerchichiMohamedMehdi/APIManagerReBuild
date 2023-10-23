package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.dto.IntervenantDTO;
import com.example.apimanagerrebuild.exception.NullException;
import com.example.apimanagerrebuild.exception.ResourceNotFoundException;
import com.example.apimanagerrebuild.models.Intervenant;
import com.example.apimanagerrebuild.models.TypeIntervenant;
import com.example.apimanagerrebuild.repositories.IntervenantRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IntervenantService {

	
	@Autowired ModelMapper modelMapper;
	@Autowired
	IntervenantRepository intRepo;
	
	public Intervenant ajoutIntervenant(Intervenant i) {
		return intRepo.save(i);
	}
	public void UpdateIntervenant(Intervenant t , Long id) {
		Intervenant i = intRepo.findByIdIntervenant(id);
		
		if(i != null) {
			t.setIdIntervenant(id);
			intRepo.save(t);
		}
		else {
			 throw new NullException("Intervenant not found");
		}
	}
	
	public void supprimerIntervenant(Long id) {
		try {
			Intervenant t = intRepo.findByIdIntervenant(id);
		        try {
		    	intRepo.delete(t);
		        }catch(Exception e) {
		        	throw new ResourceNotFoundException("Erreur lors de la suppression");
		        }
		        
			    }catch(Exception e) {
					   throw new NullException("id not found");
				   }
	}
	 public Intervenant getById(Long id) {
		 return intRepo.findByIdIntervenant(id);
	 }
	 public List<Intervenant> listerIntervenant(){
		 return intRepo.findAll();
	 }
	 public int NbrIntervenant() {
		 return intRepo.findAll().size();
	 }
	 public int NbrClients() {
		 return this.getAllClient().size();
	 }
	 public int NbrFournisseurs() {
		 return this.getAllFournisseurs().size();
	 }
	 public List<Intervenant> getAllFournisseurs(){
		 return intRepo.findByType(TypeIntervenant.Fournisseur);
	 }
	 public List<Intervenant> getAllClient(){
		 return intRepo.findByType(TypeIntervenant.Client);
	 }
	
	 public IntervenantDTO ToIDto(Intervenant intervenant) {
			modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STRICT);
			IntervenantDTO iDto = new IntervenantDTO();
			
			iDto = modelMapper.map(intervenant, IntervenantDTO.class);

			return iDto;
				}
	
		public Intervenant ToIEntity(IntervenantDTO iDTO) {
			modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STRICT);
			Intervenant i = new Intervenant();
			
			i = modelMapper.map(iDTO, Intervenant.class);
		
			return i;
		}
	
	
}
