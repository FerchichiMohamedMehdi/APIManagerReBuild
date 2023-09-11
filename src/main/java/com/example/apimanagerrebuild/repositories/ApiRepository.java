package com.example.apimanagerrebuild.repositories;


import com.example.apimanagerrebuild.models.Api;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Api, Long> {

}