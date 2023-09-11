package com.example.apimanagerrebuild.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCategory;
    private String desription;
    @OneToMany(mappedBy = "apiCategory")
    private List<Api> listApi = new ArrayList<>();




}
