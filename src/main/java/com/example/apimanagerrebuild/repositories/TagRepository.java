package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TagRepository extends JpaRepository<Tag, Long>{

	/*@Query("SELECT t from Tags t where t.nomTag=?1")
	Tag findTagByNomTag(String s);*/

   Tag   findByNomTag(String s);
	
}
