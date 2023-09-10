package com.example.apimanagerrebuild.models;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Data
public class Api {

    @Id
    // à comprendre les différent Stratégie
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private float version;

    private boolean isDefault;

    @CreatedDate
    LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

    private State apiState;
    private Method methodApi;
    //private Category apiCategory;
    //private Provider apiProvider;

    private Type apiType;




}
