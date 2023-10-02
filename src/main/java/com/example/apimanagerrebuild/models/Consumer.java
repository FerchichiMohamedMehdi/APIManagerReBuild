package com.example.apimanagerrebuild.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Data
@Table(name="consumer")
@AllArgsConstructor
@NoArgsConstructor
//id provided with parent class OrganizationS
public class Consumer extends Organization{

    @JsonCreator
    public Consumer(@JsonProperty("idConsumer") Long idConsumer) {
        this.idConsumer = idConsumer;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idConsumer;

    @Column
    private String activitySector;

    @OneToMany(mappedBy = "monConsumer")
    private List<Affectation> listAffectation= new ArrayList<Affectation>();





}
