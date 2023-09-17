package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("tag")
@RestController
public class ContollerTag {

    @Autowired
    TagService tagService;

    @GetMapping ("List")
    public ArrayList<Tag> getAllTags(){
        return tagService.getAllTag();
    }




}
