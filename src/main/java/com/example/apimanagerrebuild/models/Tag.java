package com.example.apimanagerrebuild.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="Tags")
public class Tag implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTag;
	private String nomTag;
	private int occurence=1;
    @JsonIgnore
	@OneToMany(mappedBy = "tags",cascade = CascadeType.ALL)
	private List<Api_Tag> apis = new ArrayList<>();

}
