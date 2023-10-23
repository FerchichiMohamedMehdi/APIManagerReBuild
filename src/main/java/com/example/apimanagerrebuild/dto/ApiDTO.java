package com.example.apimanagerrebuild.dto;

import com.example.apimanagerrebuild.models.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class ApiDTO implements Serializable {
	public Long idApi;
	public String nomApi;
	public String description;
	public String listFiles ;
	public String url;
	public String version;
	public boolean isDefault;
    @JsonFormat(pattern="yyyy-MM-dd") 
    public Date dateVersion;
    public TypeApi type;
    public Intervenant  fournisseur;
    public Etat etat;
    public List<Ressources> resources;
    public List<String> tags;
    public Categorie categorie;
    
    
	
	
	

}
