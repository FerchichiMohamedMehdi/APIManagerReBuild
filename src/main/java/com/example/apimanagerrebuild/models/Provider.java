package com.example.apimanagerrebuild.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="provider")
public class Provider extends Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private int numberOfAuthorisation;

    @OneToMany(mappedBy = "apiProvider")
    private List<Api> listApiProvided = new ArrayList<Api>();
}
