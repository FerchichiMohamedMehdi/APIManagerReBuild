package com.example.apimanagerrebuild.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="Ressource")
public class Ressources implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRessource;
	private String libelleRessource;
    private Method method;
    @ManyToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name="idApi")
	public Api api ;
    
}
