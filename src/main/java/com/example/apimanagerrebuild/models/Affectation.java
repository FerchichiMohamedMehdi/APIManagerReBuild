package com.example.apimanagerrebuild.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Data
@Getter
@Setter
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffectation;

    @ManyToOne
    @JoinColumn(name="id_Api")
    private Api api;

    @ManyToOne
    @JoinColumn(name="id_consuler")
    private Consumer consumer;

    @CreatedDate
    LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

}
