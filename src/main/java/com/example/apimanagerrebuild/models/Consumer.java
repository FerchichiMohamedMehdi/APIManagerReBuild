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
@Table(name="consumer")
public class Consumer extends Organization{


    private String activitySector;
    @OneToMany(mappedBy = "consumer")
    private List<Affectation> listAffectation= new ArrayList<Affectation>();

}
