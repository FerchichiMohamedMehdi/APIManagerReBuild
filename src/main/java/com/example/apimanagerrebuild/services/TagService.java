package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.exception.NullException;
import com.example.apimanagerrebuild.exception.ResourceNotFoundException;
import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagService {
	
	@Autowired
	TagRepository tagsRepo;
	
	public Tag AjoutTags(Tag t) {
		tagsRepo.save(t);
		return t;
	}
	
	public void UpdateTags(Tag t) {
		if(t != null) {
			tagsRepo.save(t);
		}
		else {
			 throw new NullException("Tags not found");
		}
	}
	
	public void supprimerTags(Long id) {
		try {
			Tag t = tagsRepo.findById(id).get();
		        try {
		    	tagsRepo.delete(t);
		        }catch(Exception e) {
		        	throw new ResourceNotFoundException("Erreur lors de la suppression");
		        }
		        
			    }catch(Exception e) {
					   throw new NullException("id not found");
				   }
	}
	 public Tag getById(Long id) {
		 return tagsRepo.findById(id).get();
	 }
	 public List<Tag> listerTags(){
		 return tagsRepo.findAll();
	 }
	 
	 public List<String> listerNameTags(){
		 List<Tag> lstTags = this.listerTags();
		 List<String> lstNom = new ArrayList<String>();
		 for(Tag t: lstTags) {
			 lstNom.add(t.getNomTag());
		 }
		 return lstNom;
	 }
	 public Tag getTagsByNom(String s) {
			return tagsRepo.findByNomTag(s);
		 }
	

}
