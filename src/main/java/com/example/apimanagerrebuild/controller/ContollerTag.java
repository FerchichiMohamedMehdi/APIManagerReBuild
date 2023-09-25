package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequestMapping("tag")
@RestController
public class ContollerTag {

    @Autowired
    TagService tagService;

    @GetMapping("/List")
    public List<Tag> getAllTags() {
        return tagService.getAllTag();
    }

    @GetMapping("/occurence")
    public Map<String, Integer> getOccurence(){
        return tagService.getTagOccurence();
    }


    @PostMapping("/add")
    public void addTag(@RequestBody Tag t){
        tagService.addTag(t);
    }
    @GetMapping("/getOccurence/{name}")
    public int getOccurence(@PathVariable("name") String name){
        return  tagService.getOccurence(name);
    }


}
