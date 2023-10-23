package com.example.apimanagerrebuild.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name ="Intervenant")
public class Intervenant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIntervenant;
	private String nomIntervenant;
	private String adresse;
	private String email;
	private String numTelephone;
	private String Fax;
	private TypeStructure structure;
	private TypeIntervenant type;
/*
	@OneToMany(targetEntity = Api.class,mappedBy = "fournisseur",cascade = CascadeType.ALL)
	  public List<Api> apis;*/
    @JsonIgnore
	@ManyToMany(mappedBy="clients")
	List<Affectation> affectations = new ArrayList<>();

	public Intervenant(String nomIntervenant, String adresse, String email, String numTelephone, String fax,
			TypeStructure structure, TypeIntervenant type) {
	
		this.nomIntervenant = nomIntervenant;
		this.adresse = adresse;
		this.email = email;
		this.numTelephone = numTelephone;
		Fax = fax;
		this.structure = structure;
		this.type = type;
	}

	public Intervenant(Long idIntervenant) {
		this.idIntervenant = idIntervenant;
	}
	
	
}
