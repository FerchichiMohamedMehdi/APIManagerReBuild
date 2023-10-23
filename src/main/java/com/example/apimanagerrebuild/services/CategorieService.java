package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.exception.NullException;
import com.example.apimanagerrebuild.models.Categorie;
import com.example.apimanagerrebuild.repositories.CategorieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
	@Autowired ModelMapper modelMapper;
	@Autowired
	CategorieRepository catRepo;
	public Categorie AjoutCategorie(Categorie c) {
		catRepo.save(c);
		return c;
	}
	
	public void UpdateCategorie(Categorie c ,Long id) {
		Categorie categorie = catRepo.findByIdCategorie(id);
		
		if(categorie != null) {
			categorie.setNomCategorie(c.getNomCategorie());
			catRepo.save(categorie);
		}else {
			throw new NullException("categroie not found");
		}
		
	}
	
	public void supprimerCategorie(Long id) {
		
			Categorie categorie = catRepo.findByIdCategorie(id);
		       System.out.println(categorie.toString());
		    	catRepo.delete(categorie);
		      
	}
	 public Categorie getById(Long id) {
		  Categorie categorie = catRepo.findByIdCategorie(id);
		  return categorie;
	 }
	 public List<Categorie> listerCategorie(){
		 return catRepo.findAll();
	 }
	


}
