package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Ressources;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RessourceRepository extends JpaRepository<Ressources, Long>{

	Ressources findByIdRessource(Long idRessource);
}
