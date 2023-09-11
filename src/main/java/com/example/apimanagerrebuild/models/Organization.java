package com.example.apimanagerrebuild.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    private String name;
    private String adress;
    private int phone;
    private String mail;
}
