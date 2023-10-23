package com.example.apimanagerrebuild.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntervenantDTO {

	
	public Long idIntervenant;
	public String nomIntervenant;
	public IntervenantDTO(String nomIntervenant) {
	
		this.nomIntervenant = nomIntervenant;
	}
	
	
}
