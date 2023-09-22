package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Consumer;
import com.example.apimanagerrebuild.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    void deleteByIdConsumer(Long id);
    Consumer getConsumerByName(String name);
}
