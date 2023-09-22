package com.example.apimanagerrebuild.models;

import com.example.apimanagerrebuild.services.CategoryService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    private String nameCategory;
    private String description;


    public Category(int id) {
        CategoryService categoryService = new CategoryService();
        Category cat = categoryService.findById((long) id);
        this.description= cat.getDescription();
        this.nameCategory=cat.getNameCategory();

    }

    @JsonCreator
    public Category(@JsonProperty("idCategory") Long idCategory) {
        this.idCategory = idCategory;
    }

    @OneToMany(mappedBy = "apiCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Api> listApi = new ArrayList<>();




}
