package com.example.apimanagerrebuild.models;

import lombok.*;

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

    @ManyToMany(mappedBy = "mesTag")
    private List<Api> listApi = new ArrayList<Api>();

    public Tag(String nameTag) {
        this.nameTag = nameTag;
    }
}
