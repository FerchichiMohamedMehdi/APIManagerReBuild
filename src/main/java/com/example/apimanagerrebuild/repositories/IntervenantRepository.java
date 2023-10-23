package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Intervenant;
import com.example.apimanagerrebuild.models.TypeIntervenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface IntervenantRepository extends JpaRepository<Intervenant, Long>{

	  List<Intervenant> findByType(TypeIntervenant type);
	  Intervenant findByIdIntervenant(Long idIntervenant);

}
