package com.example.apimanagerrebuild.models;



import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Data
@Getter
@Setter
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApi;

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
    @JoinColumn(name="id", nullable = false)
    private Category apiCategory;

    @ManyToOne
    @JoinColumn(name="id_provider")
    private Provider apiProvider;

    @OneToMany(mappedBy = "api")
    @JsonIgnore
    private List<Affectation> listAffectation= new ArrayList<Affectation>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="Api_Tag",
            joinColumns = @JoinColumn(name="idApi"),
            inverseJoinColumns = @JoinColumn(name="idTag")
    )
    private List<Tag> mesTag= new ArrayList<>();

}
