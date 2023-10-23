package com.example.apimanagerrebuild.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="API_Tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Api_Tag implements Serializable {
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Api_Tag_PK apiTagsPK ;
	
	@ManyToOne(targetEntity = Api.class)
	@MapsId("idApi")
	@JoinColumn(name="idApi")
	private Api api = new Api();
	@ManyToOne(targetEntity = Tag.class)
	@MapsId("idTag")
	@JoinColumn(name="idTag")
	private Tag tags = new Tag();
	public Api_Tag(Api api, Tag tags) {
		this.apiTagsPK =new Api_Tag_PK(api.getIdApi(),tags.getIdTag());
		this.api = api;
		this.tags = tags;
	}
     
	
}
