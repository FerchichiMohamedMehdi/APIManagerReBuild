package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.repositories.TagRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagService {

    @Autowired
    TagRepositoty tagRepositoty;
    Api api;

    public ArrayList<Tag> getAllTag(){

        return (ArrayList<Tag>) tagRepositoty.findAll();

    }



    public void addTag (ArrayList<Tag> listTagToAdd){

        ArrayList<Tag> ExistedTags = this.getAllTag();

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

}
