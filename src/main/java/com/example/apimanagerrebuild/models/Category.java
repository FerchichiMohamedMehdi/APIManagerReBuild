package com.example.apimanagerrebuild.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCategory;
    private String desription;
    @OneToMany(mappedBy = "apiCategory")
    private List<Api> listApi = new ArrayList<>();




}
