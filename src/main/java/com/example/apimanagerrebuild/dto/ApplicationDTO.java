package com.example.apimanagerrebuild.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationDTO implements Serializable{

	public long idIntervenant;
	public String nomApplication;

}
