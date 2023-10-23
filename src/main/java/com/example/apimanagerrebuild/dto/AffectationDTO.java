package com.example.apimanagerrebuild.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class AffectationDTO implements Serializable{

	public long idAffectation;
	public long idApi;
	public List<Long> clients;
	public String adresseIP;
	public List<Long> apps;
	public LocalDate dateAffectation;
}
