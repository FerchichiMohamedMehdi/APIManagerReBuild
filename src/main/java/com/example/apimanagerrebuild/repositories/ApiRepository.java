package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.models.Categorie;
import com.example.apimanagerrebuild.models.Etat;
import com.example.apimanagerrebuild.models.TypeApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiRepository extends JpaRepository<Api, Long> {
  
	Api findByIdApi(Long idApi);
	
	List<Api> findByType(TypeApi type);
	
	List<Api> findByCategorie(Categorie categorie);
	List<Api> findByEtat(Etat etat);
}
