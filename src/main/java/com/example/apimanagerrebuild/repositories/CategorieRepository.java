package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	Categorie findByIdCategorie(Long idCategorie);
	
}
