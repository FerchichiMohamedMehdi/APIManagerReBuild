package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Affectation;
import com.example.apimanagerrebuild.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/affectation")
public class AffectationController {
    @Autowired
    AffectationService affectationService;

    @PostMapping("/add")
    public void Affectation(@RequestBody Affectation a){
        affectationService.addAffectation(a);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAffectation(@PathVariable("id") Long id){
        affectationService.deleteAffectationById(id);
    }
}