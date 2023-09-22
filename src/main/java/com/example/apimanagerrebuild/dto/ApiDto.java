package com.example.apimanagerrebuild.dto;

import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.models.Method;
import com.example.apimanagerrebuild.models.State;
import com.example.apimanagerrebuild.models.Tag;
import com.example.apimanagerrebuild.services.TagService;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data

public class ApiDto {

    private Long idApi;

    private String nameApi;

    private float version;

    private LocalDate creationDate;

    private Set<Method> methods;

    private State apiState;

    private String apiType;

    private String apiProvider;

    private String apiCategory;

    private List<String> tags;


    public ApiDto fromEntity(Api api){
        ApiDto ApiDto = new ApiDto();
        TagService tagService ;
        if(api==null){
            return null;
        }

        ApiDto.setIdApi(api.getIdApi());
        ApiDto.setNameApi(api.getName());
        ApiDto.setVersion(api.getVersion());
        ApiDto.setCreationDate(api.getDate());
        ApiDto.setMethods(api.getMesMethod());
        ApiDto.setApiState(api.getApiState());
        ApiDto.setApiType(api.getMonType().toString());
        ApiDto.setApiProvider(api.getApiProvider().getName());
        ApiDto.setApiCategory(api.getApiCategory().getNameCategory());

        List<Tag> tags = api.getMesTag();
        List<String> namesTags = new ArrayList<>();
        for(Tag t : tags){
            namesTags.add(t.getNameTag());
        }
        ApiDto.setTags(namesTags);

        return ApiDto;
    }


}