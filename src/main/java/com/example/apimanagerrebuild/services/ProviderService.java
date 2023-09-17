package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Provider;
import com.example.apimanagerrebuild.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    public void addOrUpdateProvider(Provider p){
        providerRepository.save(p);
    }
}
