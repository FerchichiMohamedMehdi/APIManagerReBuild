package com.example.apimanagerrebuild.controller;


import com.example.apimanagerrebuild.models.Consumer;
import com.example.apimanagerrebuild.models.Organization;
import com.example.apimanagerrebuild.services.CategoryService;
import com.example.apimanagerrebuild.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @PostMapping("/add")
    public void addOrUpdateConsumer(@RequestBody Consumer c){

        consumerService.addOrUpdateConsumer(c);
    }


}
