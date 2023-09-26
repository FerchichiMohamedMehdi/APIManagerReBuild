package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Affectation;
import com.example.apimanagerrebuild.repositories.AffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationService {
    @Autowired
    AffectationRepository affectationRepository;

    //add Affectation
    public void addAffectation(Affectation a){
        affectationRepository.save(a);
    }
    // deleting Affectation by id
    public void deleteAffectationById(Long id){
        affectationRepository.deleteById(id);
    }

}