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

    //private int occurence=1;

    @ManyToOne
    @JoinColumn(name="idApi", nullable = true)
    Api monApi;

    public Tag(String nameTag) {
        this.nameTag = nameTag;
    }
}
