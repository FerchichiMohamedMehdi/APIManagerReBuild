package com.example.apimanagerrebuild.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@Data
public abstract class Organization {


    private String name;
    private String adress;
    private int phone;
    private String mail;
}
