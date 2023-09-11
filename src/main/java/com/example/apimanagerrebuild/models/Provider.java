package com.example.apimanagerrebuild.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Provider extends Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfAuthorisation;
    //private List<Api> listApiProvided = new ArrayList<Api>();
}
