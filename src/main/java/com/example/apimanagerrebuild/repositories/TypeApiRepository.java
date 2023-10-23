package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.TypeApi;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TypeApiRepository extends JpaRepository<TypeApi, Long> {

	TypeApi findByIdTypeApi(Long idTypeApi);
}
