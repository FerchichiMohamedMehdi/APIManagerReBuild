package com.example.apimanagerrebuild.controller;


import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO rest of CRUD to complete
@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    ApiService apiService;

    @PostMapping("add")
    public void addOrUpdate(@RequestBody Api api){
        apiService.addApi(api);
    }
}
