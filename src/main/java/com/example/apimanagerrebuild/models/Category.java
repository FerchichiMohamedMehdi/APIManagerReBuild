package com.example.apimanagerrebuild.models;

import lombok.*;

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
    private Long id;

    private String nameCategory;
    private String description;




    @OneToMany(mappedBy = "apiCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Api> listApi = new ArrayList<>();




}
