package com.example.apimanagerrebuild.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@MappedSuperclass
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;



    private String name;
    private String adress;
    private int phone;
    private String mail;

}
