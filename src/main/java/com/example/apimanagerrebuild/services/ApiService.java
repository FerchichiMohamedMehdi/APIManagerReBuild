package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.repositories.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    ApiRepository apiRepository;
    TagService tagService;

    public void addApi(Api api){

        List<Tag> tagToAdd = api.getMesTag();
        System.out.println(tagToAdd.toString()+"test");
        for (Tag t:tagToAdd){
            tagService.addTag(t);
        }


        apiRepository.save(api);
    }
}
