package com.example.apimanagerrebuild.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="provider")
@Getter
@Setter
@Data
public class Provider extends Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idProvider;
    private int numberOfAuthorisation;

    @OneToMany(mappedBy = "apiProvider")
    private List<Api> listApiProvided = new ArrayList<Api>();

    @JsonCreator
    public Provider(@JsonProperty("idProvider") Long idProvider) {
        this.idProvider = idProvider;
    }
}
