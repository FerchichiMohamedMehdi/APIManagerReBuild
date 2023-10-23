package com.example.apimanagerrebuild.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idAffectation")
@Table(name ="Affectation")
public class Affectation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffectation;
	
	private String adressesIP;
	private LocalDate dateAffectation; 
    
	@ManyToMany
	@JoinTable(name= "affectation_applications",
	joinColumns= @JoinColumn(name="idAffectation"),
	inverseJoinColumns = @JoinColumn(name="idApplication"))
    public List<Application> applications = new ArrayList<>();
   
	@ManyToMany
	@JoinTable(name= "affectation_clients",
	joinColumns= @JoinColumn(name="idAffectation"),
	inverseJoinColumns = @JoinColumn(name="idIntervenant"))
    public List<Intervenant> clients;
	
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="idApi")
	public Api api;

	public Affectation(String adressesIP, LocalDate dateAffectation, List<Intervenant> clients,Api api) {
	
		this.adressesIP = adressesIP;
		this.dateAffectation = dateAffectation;
		this.clients = clients;
		this.api= api;
	}
	
	

}
