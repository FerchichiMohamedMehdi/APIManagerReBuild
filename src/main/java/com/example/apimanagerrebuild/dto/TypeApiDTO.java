package com.example.apimanagerrebuild.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeApiDTO {

	
	public Long idTypeApi;
	public String libelleTypeApi;
	public TypeApiDTO(String libelleTypeApi) {
		super();
		this.libelleTypeApi = libelleTypeApi;
	}
	
}
