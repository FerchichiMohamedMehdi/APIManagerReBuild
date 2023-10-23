package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Api_Tag;
import com.example.apimanagerrebuild.models.Api_Tag_PK;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ApiTagRepository extends JpaRepository<Api_Tag, Api_Tag_PK>{

	Api_Tag  findByApiTagsPK(Api_Tag_PK apiTagsPK);
}
