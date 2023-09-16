package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Consumer;
import com.example.apimanagerrebuild.models.Organization;
import com.example.apimanagerrebuild.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {


    @Autowired
    ConsumerRepository consumerRepository;

    public void addOrUpdateConsumer(Consumer c){
        consumerRepository.save(c);
    }
}
