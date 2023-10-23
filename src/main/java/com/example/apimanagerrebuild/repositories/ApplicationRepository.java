package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Application;
import com.example.apimanagerrebuild.models.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ApplicationRepository  extends JpaRepository<Application, Long>{

	Application  findByIdApplication(Long idApplication);
	
	List<Application> findByClient(Intervenant client);
}
