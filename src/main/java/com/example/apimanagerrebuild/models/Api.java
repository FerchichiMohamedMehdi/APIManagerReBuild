package com.example.apimanagerrebuild.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idApi")
@Table(name ="API")
public class Api implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApi;
	private String nomApi;
	private String description;
	private String listFiles ;
	private String url;
	private String version;
	private boolean isDefault;
    @JsonFormat(pattern="yyyy-MM-dd") 
    private Date dateVersion;
	private Etat etat;
 
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="idTypeApi")
    public TypeApi type;
  
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idIntervenant")
	public Intervenant fournisseur;
	
   
    

  @OneToMany(targetEntity = Ressources.class,mappedBy = "api",cascade = CascadeType.MERGE)
    public List<Ressources> resources = new ArrayList<>();
    
	@OneToMany(mappedBy = "api",cascade = CascadeType.ALL)
	private List<Api_Tag> tags = new ArrayList<>();

	/*@OneToMany(targetEntity = Affectation.class,mappedBy = "api",cascade = CascadeType.ALL)
    public List<Affectation> affectations;*/

	  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	    @JoinColumn(name = "idCategorie")
	public Categorie categorie ;
    
    

	 public void addTag(Tag tag) {
	        Api_Tag apiTag = new Api_Tag(this, tag);
	        tags.add(apiTag);
	        tag.getApis().add(apiTag);
	    }
	 
	 
	    public void removeTag(Tag tag) {
	        for (Iterator<Api_Tag> iterator = tags.iterator();
	             iterator.hasNext(); ) {
	            Api_Tag apiTag = iterator.next();
	 
	            if (apiTag.getApi().equals(this) &&
	                    apiTag.getTags().equals(tag)) {
	                iterator.remove();
	                apiTag.getTags().getApis().remove(apiTag);
	                apiTag.setApi(null);
	                apiTag.setTags(null);
	            }
	        }}


		public Api(String nomApi, String description, String listFiles, String url, String version,
				boolean isDefault, Date dateVersion, TypeApi type, Intervenant fournisseur, Etat etat,Categorie categorie) {
		
			this.nomApi = nomApi;
			this.description = description;
		
			this.listFiles = listFiles;
			this.url = url;
			this.version = version;
			this.isDefault = isDefault;
			this.dateVersion = dateVersion;
			this.type = type;
			this.fournisseur = fournisseur;
			this.etat = etat;
			this.categorie = categorie;
		}


		
}
