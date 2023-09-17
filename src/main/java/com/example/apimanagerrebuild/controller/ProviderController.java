package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Provider;
import com.example.apimanagerrebuild.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @PostMapping("add")
    public void addOrUpdateProvider(@RequestBody Provider p){
        providerService.addOrUpdateProvider(p);
    }
}
