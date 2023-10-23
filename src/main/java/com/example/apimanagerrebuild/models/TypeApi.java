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
@Table(name ="Type_API")
public class TypeApi implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeApi;
	private String libelleTypeApi;
    @JsonBackReference
	@OneToMany(targetEntity = Api.class,mappedBy = "type",cascade = CascadeType.ALL)
	  public List<Api> apis;

	public TypeApi(Long idTypeApi) {
	
		this.idTypeApi = idTypeApi;
	}
	

}
