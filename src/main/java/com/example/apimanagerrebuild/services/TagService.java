package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.repositories.TagRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepositoty tagRepositoty;
    Api api;

    public List<Tag> getAllTag(){
        List<Tag> tags =tagRepositoty.findAll();

        return tags;

    }



    public void addTag (List<Tag> listTagToAdd){

        List<Tag> ExistedTags = this.getAllTag();
        System.out.println(ExistedTags.toString()+"test");

        for (Tag tagToAdd:listTagToAdd){
            for (Tag ExistedTag:ExistedTags){
                if(tagToAdd.getNameTag().equalsIgnoreCase(ExistedTag.getNameTag())){
                    ExistedTag.setOccurence(ExistedTag.getOccurence()+1);
                    tagRepositoty.save(ExistedTag);
                    break;
                }
                else {
                    tagRepositoty.save(tagToAdd);
                }

        }
        }
    }
    public void addTag(Tag tagToAdd){
        List<Tag> ExistedTags = this.getAllTag();
        for (Tag ExistedTag:ExistedTags){
            if(tagToAdd.getNameTag().equalsIgnoreCase((ExistedTag.getNameTag()))){
                ExistedTag.setOccurence(ExistedTag.getOccurence()+1);
                tagRepositoty.save(ExistedTag);
            }
            else{
                tagRepositoty.save(tagToAdd);
            }
        }

    }

    public void addSingleTag(Tag tag){
        tagRepositoty.save(tag);
    }

}
