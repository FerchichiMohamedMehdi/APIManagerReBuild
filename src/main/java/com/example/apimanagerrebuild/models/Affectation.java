package com.example.apimanagerrebuild.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Entity
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffectation;
    private Long idApi;
    private Long idConsumer;

    @CreatedDate
    LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

}
