package com.example.apimanagerrebuild.models;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTag;

    private String nameTag;

    private int occurence=1;

    @ManyToMany(mappedBy = "mesTag", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Api> listApi = new ArrayList<>();

    public Tag(String nameTag) {
        this.nameTag = nameTag;
    }
}
