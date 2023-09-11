package com.example.apimanagerrebuild.models;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Organization {


    private String name;
    private String adress;
    private int phone;
    private String mail;
}
