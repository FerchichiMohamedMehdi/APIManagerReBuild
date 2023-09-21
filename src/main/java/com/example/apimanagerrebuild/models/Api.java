package com.example.apimanagerrebuild.models;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Method.class)
    @CollectionTable(name = "api_method" , joinColumns = @JoinColumn(name ="idApi"))
    @Column(name = "method")
    private Set<Method> methodApi;

    @Embedded
    @Enumerated(EnumType.STRING)
    private Type monType;


    @ManyToOne
    @JoinColumn(name="idCategory", nullable = false)
    private Category apiCategory;

    @ManyToOne
    @JoinColumn(name="idProvider")
    private Provider apiProvider;

    @OneToMany(mappedBy = "monApi")
    private List<Affectation> listAffectation= new ArrayList<Affectation>();

    @OneToMany(mappedBy = "monApi")
    private List<Tag> mesTag = new ArrayList<>();

}
