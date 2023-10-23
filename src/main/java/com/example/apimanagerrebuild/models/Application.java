package com.example.apimanagerrebuild.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="Application")
public class Application implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApplication;
	private String nomApplication;
	@ManyToMany(mappedBy="applications")
	List<Affectation> affectations = new ArrayList<>();
    
	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name="idIntervenant")
	public Intervenant client;
	public Application(String nomApplication) {

		this.nomApplication = nomApplication;
	}
	

}
