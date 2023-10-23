package com.example.apimanagerrebuild.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name ="Categorie")
public class Categorie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie;
	@JsonBackReference
	@OneToMany(targetEntity = Api.class,mappedBy = "categorie",cascade = CascadeType.ALL)
    public List<Api> apis;

	public Categorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	
}
