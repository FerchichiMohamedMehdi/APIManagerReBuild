package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Api;
import com.example.apimanagerrebuild.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    void deleteByIdTag(Long id);
    Tag findByNameTag(String name);
    List<Tag> findByMonApi_IdApi(Api api);

}
