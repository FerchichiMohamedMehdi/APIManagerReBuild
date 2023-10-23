package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.dto.TypeApiDTO;
import com.example.apimanagerrebuild.exception.NullException;
import com.example.apimanagerrebuild.exception.ResourceNotFoundException;
import com.example.apimanagerrebuild.models.TypeApi;
import com.example.apimanagerrebuild.repositories.TypeApiRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeApiService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TypeApiRepository typeRepo;
	public TypeApi AjoutTypeApi(TypeApi c) {
		typeRepo.save(c);
		return c;
	}
	
	public void UpdateTypeApi(TypeApi c,Long id) {
		TypeApi TypeApi = typeRepo.findByIdTypeApi(id);
		
		if(TypeApi != null) {
		
			typeRepo.save(TypeApi);
		}else {
			throw new NullException("Type not found");		}
		
	}
	
	public void supprimerTypeApi(Long id) {
		try {
			TypeApi TypeApi = typeRepo.findByIdTypeApi(id);
		        try {
		    	typeRepo.delete(TypeApi);
		        }catch(Exception e) {
		        	throw new ResourceNotFoundException("Erreur lors de la suppression");
		        }
		        
			    }catch(Exception e) {
					   throw new NullException("id not found");
				   }
	}
	 public TypeApi getById(Long id) {
		  TypeApi TypeApi = typeRepo.findByIdTypeApi(id);
		  return TypeApi;
	 }
	 public List<TypeApi> listerTypeApis(){
		 return typeRepo.findAll();
	 }
	 
	 public TypeApiDTO ToDto(TypeApi i) {
			modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STRICT);
			TypeApiDTO iDto = new TypeApiDTO();
			
			iDto = modelMapper.map(i, TypeApiDTO.class);

			return iDto;
				}
		
		/*-------- methode To Entity-------*/
		public TypeApi ToEntity(TypeApiDTO iDTO) {
			modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STRICT);
			TypeApi i = new TypeApi();
			
			i = modelMapper.map(iDTO, TypeApi.class);
		
			return i;
		}

}
