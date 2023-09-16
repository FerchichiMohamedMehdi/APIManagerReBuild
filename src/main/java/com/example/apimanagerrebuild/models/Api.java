package com.example.apimanagerrebuild.models;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Data
@Getter
@Setter
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private float version;

    private boolean isDefault;

    @CreatedDate
            @NonNull
    LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

    @Enumerated(EnumType.STRING)
    @Embedded
    private State apiState;

    @Embedded
    @Enumerated(EnumType.STRING)
    private Method methodApi;

    @Embedded
    @Enumerated(EnumType.STRING)
    private Type monType;


    @ManyToOne(fetch = FetchType.LAZY)
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
