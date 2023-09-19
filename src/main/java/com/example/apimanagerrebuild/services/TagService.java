package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public List<Tag> getAllTag(){
        List<Tag> tags = new ArrayList<>();
        tags= tagRepository.findAll();

        return tags;

    }



    public void addTag (List<Tag> listTagToAdd){

        List<Tag> ExistedTags = this.getAllTag();
        System.out.println(ExistedTags.toString()+"test");

        for (Tag tagToAdd:listTagToAdd){
            for (Tag ExistedTag:ExistedTags){
                if(tagToAdd.getNameTag().equalsIgnoreCase(ExistedTag.getNameTag())){
                    ExistedTag.setOccurence(ExistedTag.getOccurence()+1);
                    tagRepository.save(ExistedTag);
                    break;
                }
                else {
                    tagRepository.save(tagToAdd);
                }

        }
        }
    }
    public void addTag(Tag tagToAdd){
        //List<Tag> existedTags = this.getAllTag();
        /*for (Tag existedTag:existedTags){
            if(tagToAdd.getNameTag().equalsIgnoreCase((existedTag.getNameTag()))){
                existedTag.setOccurence(existedTag.getOccurence()+1);
                tagRepository.save(existedTag);
            }
            tagRepository.save(tagToAdd);
        }*/
        tagRepository.save(tagToAdd);

    }

    public void addSingleTag(Tag tag){
        tagRepository.save(tag);
    }

}
