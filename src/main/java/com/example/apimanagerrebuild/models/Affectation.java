package com.example.apimanagerrebuild.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Affectation {
    private Long idAffectation;
    private Long idApi;
    private Long idConsumer;

    @CreatedDate
    LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

}
