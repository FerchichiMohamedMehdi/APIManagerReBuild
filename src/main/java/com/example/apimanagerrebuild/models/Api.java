package com.example.apimanagerrebuild.models;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Data
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private float version;

    private boolean isDefault;

    @CreatedDate
    LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

    @Enumerated(EnumType.STRING)
    private State apiState;
    @Enumerated(EnumType.STRING)
    private Method methodApi;
    @Enumerated(EnumType.STRING)
    private Type monType;


    @ManyToOne
    @JoinColumn(name="id_provider", nullable = false)
    private Category apiCategory;
    @ManyToOne
    @JoinColumn(name="id", insertable = false,updatable = false)
    private Provider apiProvider;

    @OneToMany(mappedBy = "api")
    private List<Affectation> listAffectation= new ArrayList<Affectation>();

    @ManyToMany
    private List<Tag> mesTag= new ArrayList<Tag>();




}
