package com.example.apimanagerrebuild.models;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Api_Tag_PK implements Serializable {

	private Long idApi;
	private Long idTag;
	public Api_Tag_PK(Long idApi, Long idTag) {
	
		this.idApi = idApi;
		this.idTag = idTag;
	}
	public Api_Tag_PK() {
	}
	
	
	
	

}
